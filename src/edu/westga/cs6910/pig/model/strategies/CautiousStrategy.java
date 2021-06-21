package edu.westga.cs6910.pig.model.strategies;

/**
 * 
 * The Caution Strategy always returns false. Yielding a single roll per turn.
 * 
 * @author Alex Kernan
 * @version 6/20/2021
 *
 */
public class CautiousStrategy implements PigStrategy {
	private String stragetyName = "Cautious";
	
	@Override
	public boolean rollAgain(int numberRollsThisTurn, int numberPointsThisTurn,
			int differenceBetweenFinalAndCurrentPoints) {
		return false;
	}

	@Override
	public String getStrategyName() {
		return this.stragetyName;
	}

}
