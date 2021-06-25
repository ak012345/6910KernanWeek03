package edu.westga.cs6910.pig.model.strategies;

/**
 * 
 * The Random Strategy has equal chance of tryign to roll again.
 * 
 * @author Alex Kernan
 * @version 6/20/2021
 *
 */

public class RandomStrategy implements PigStrategy {
	private String stragetyName = "Random";

	@Override
	public boolean rollAgain(int numberRollsThisTurn, int numberPointsThisTurn,
			int pointsNeededToWin) {
		return Math.random() > .1;
	}

	@Override
	public String getStrategyName() {
		return this.stragetyName;
	}

}
