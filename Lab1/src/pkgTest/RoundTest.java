package pkgTest;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import pkgCore.Die;
import pkgCore.Roll;
import pkgCore.Round;
import pkgCore.eGameResult;

public class RoundTest {

	@Test
	public void TestRound() {
		
		Round r = new Round();
		LinkedList<Roll> rolls = r.getRolls();
		Roll LastRoll = rolls.getLast();
		
		if(r.RollCount() == 1 && LastRoll.getScore() == 2 || LastRoll.getScore() == 3 || LastRoll.getScore() == 12) {
			assertEquals(r.geteGameResult(),eGameResult.CRAPS);
		}
		else if(r.RollCount() == 1 && LastRoll.getScore() == 7 || LastRoll.getScore() == 11) {
			assertEquals(r.geteGameResult(),eGameResult.NATURAL);
		}
		else if(r.RollCount() > 1 && LastRoll.getScore() == 7) {
			assertEquals(r.geteGameResult(),eGameResult.SEVEN_OUT);
		}
		else {
			assertEquals(r.geteGameResult(),eGameResult.POINT);
		}
	}

}

