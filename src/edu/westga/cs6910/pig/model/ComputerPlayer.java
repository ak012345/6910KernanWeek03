package edu.westga.cs6910.pig.model;

import edu.westga.cs6910.pig.model.strategies.PigStrategy;

/**
 * ComputerPlayer represents a very simple automated player in the game Pig. It
 * rolls exactly 1 time and then holds.
 * 
 * @author Alex Kernan
 * @version 6/8/2021
 */
public class ComputerPlayer extends AbstractPlayer {
	private static final String NAME = "Simple Computer";
	private int maximumRolls;
	private PigStrategy currentStrategy;
	private int rollsThisTurn;

	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * 
	 * @param currentStrategy the current strategy the computer should play by.
	 */

	public ComputerPlayer(PigStrategy currentStrategy) {
		super(NAME);
		if (currentStrategy == null) {
			throw new IllegalArgumentException("The current strategy cannot be null");
		}

		this.currentStrategy = currentStrategy;
		this.rollsThisTurn = 0;
	}

	/**
	 * This method will set the Computer Strategy to a new one
	 * 
	 * @param newStrategy is the new PigStrategy for the computerPlayer
	 */
	public void setComputerStrategy(PigStrategy newStrategy) {
		if (newStrategy == null) {
			throw new IllegalArgumentException("Invalid Strategy");
		}
		this.currentStrategy = newStrategy;
	}

	/**
	 * THe getter method that retrieve the current computer strategy
	 * 
	 * @return this.currentStrategy the current strategy the computer is using
	 */
	public PigStrategy getComputerStrategy() {
		return this.currentStrategy;
	}

//	/**
//	 * Implements Player's setMaximumRolls, but is not normally called by client
//	 * objects. Instead, clients usually call the 0-parameter version
//	 * 
//	 * @requires maximumRolls > 0
//	 * 
//	 * @param maximumRolls The maximum number of times the computer will roll before
//	 *                     holding
//	 */
//	public void setMaximumRolls(int maximumRolls) {
//		if (maximumRolls <= 0) {
//			throw new IllegalArgumentException("Maximum number of rolls must be greater than 0");
//		}
//		this.maximumRolls = maximumRolls;
//	}
//
//	/**
//	 * Getter method for the maximumRolls instance variable
//	 * 
//	 * @return maximumRolls the number of rolls the computer should make in it's
//	 *         turn
//	 */
//	public int getMaximumNumberOfRolls() {
//		switch (this.currentStrategy) {
//		case 
//		}
//		return this.maximumRolls;
//
//	}

	/**
	 * Implements Player's setMaximumRolls() to set the maximum number of rolls to 1
	 * 
	 */
	public void setMaximumRolls() {
		this.maximumRolls = 1;
	}

	@Override
	/**
	 * @see Player#takeTurn()
	 */
	public void takeTurn() {
		for (int count = 0; count < this.maximumRolls; count++) {

			super.getDicePair().rollDice();

			int die1Value = super.getDicePair().getDie1Value();
			int die2Value = super.getDicePair().getDie2Value();
			int total = super.getTotal();
			int turnTotal = super.getTurnTotal();

			if (die1Value == 1 || die2Value == 1) {
				total -= turnTotal;
				super.resetTurnTotal();
			} else {

				turnTotal += die1Value + die2Value;
				total += die1Value + die2Value;
				super.setTurnTotal(turnTotal);
			}
			super.setTotal(total);
		}
		super.setIsMyTurn(false);
		if (this.currentStrategy.rollAgain(1, 1, 1)) {
			this.rollsThisTurn++;
			this.takeTurn();
		}
		this.rollsThisTurn = 0;
	}

}
