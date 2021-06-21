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

	@Override
	/**
	 * 
	 * @see Player#takeTurn()
	 * 
	 */
	public void takeTurn() {
		super.takeTurn();
		super.setIsMyTurn(false);
		if (this.currentStrategy.rollAgain(1, 1, 1)) {
			this.rollsThisTurn++;
			this.takeTurn();
		}
		this.rollsThisTurn = 0;
	}

}
