package edu.westga.cs6910.pig.model.strategies;

/**
 * 
 * The Caution Strategy always returns false. Yielding a single roll per turn.
 * 
 * @author Alex Kernan
 * @version 6/20/2021
 *
 */

public class RandomStrategy implements PigStrategy {

	@Override
	public boolean rollAgain(int numberRollsThisTurn, int numberPointsThisTurn,
			int differenceBetweenFinalAndCurrentPoints) {
		System.out.println("Rolling again...");
		return Math.random() < .5;
	}

}
