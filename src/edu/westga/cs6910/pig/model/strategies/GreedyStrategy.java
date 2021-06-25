package edu.westga.cs6910.pig.model.strategies;

/**
 * The Greedy Strategy will always attempt to roll exactly three times.
 * 
 * @author Alex Kernan
 * @version 6/21/2021
 */

public class GreedyStrategy implements PigStrategy {
	private String stragetyName = "Greedy";

	@Override
	public boolean rollAgain(int numberRollsThisTurn, int numberPointsThisTurn,
			int pointsNeededToWin) {
		if (numberRollsThisTurn < 3) {
			return true;
		}
		return false;
	}

	@Override
	public String getStrategyName() {
		return this.stragetyName;
	}

}
