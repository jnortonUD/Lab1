package pkgCore;

import java.util.LinkedList;

public class Round {

	private int ComeOutScore;
	private eGameResult eGameResult;
	private LinkedList<Roll> rolls = new LinkedList<Roll>();

	public Round() {
		
		Roll ComeOutRoll = new Roll();
		ComeOutScore = ComeOutRoll.getScore();
		rolls.add(ComeOutRoll);
		
		if(ComeOutScore == 2 || ComeOutScore == 3 || ComeOutScore == 12) {
			eGameResult = eGameResult.CRAPS;
		}
		
		else if(ComeOutScore == 7 || ComeOutScore == 11) {
			eGameResult = eGameResult.NATURAL;
		}
		
		else {
			while(true) {
				Roll newRoll = new Roll();
				int rollScore = newRoll.getScore();
				rolls.add(newRoll);
				
				if(rollScore == 7) {
					eGameResult = eGameResult.SEVEN_OUT;
					break;
				}
				else if(rollScore == ComeOutScore) {
					eGameResult = eGameResult.POINT;
					break;
				}
			}
		}
	}

	public int RollCount() {
		return rolls.size();
	}
	
	public eGameResult geteGameResult() {
		return eGameResult;
	}
	
	public LinkedList<Roll> getRolls(){
		return rolls;
	}
}
