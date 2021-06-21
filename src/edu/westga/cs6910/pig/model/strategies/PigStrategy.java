package edu.westga.cs6910.pig.model.strategies;

/**
 * The Pig strategy interface outlines the common elements required for a Pig
 * strategy to be implemented.
 * 
 * @author Alex Kernan
 * @version 6/20/2021
 */

public interface PigStrategy {

	/**
	 * rollAgain determines if the player should roll again
	 * 
	 * @param numberRollsThisTurn                    The number of rolls this turn
	 * @param numberPointsThisTurn                   The number of points this turn
	 * @param differenceBetweenFinalAndCurrentPoints number of points required to
	 *                                               win.
	 * @return true if player should roll again.
	 */
	boolean rollAgain(int numberRollsThisTurn, int numberPointsThisTurn, int differenceBetweenFinalAndCurrentPoints);

	/**
	 * Returns the name of the Strategy
	 * @return a string representation / name of the Strategy
	 */
	String getStrategyName();
}
