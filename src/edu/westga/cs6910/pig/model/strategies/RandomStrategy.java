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
		
		boolean rollAgain = Math.random() > .5;
//		if (rollAgain) {
//			System.out.println("Rolling again..." + rollAgain);
//		} else {
//			System.out.println("NO roll again: " + rollAgain);
//		}
		return rollAgain;
	}

}
