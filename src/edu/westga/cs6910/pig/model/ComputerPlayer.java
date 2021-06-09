package edu.westga.cs6910.pig.model;

/**
 * ComputerPlayer represents a very simple automated player in the game Pig. It
 * rolls exactly 1 time and then holds.
 * 
 * @author Alex Kernan
 * @version 6/8/2021
 */
public class ComputerPlayer extends AbstractPlayer {
	private static final String NAME = "Simple computer";
	private int maximumRolls;

	/**
	 * Creates a new ComputerPlayer with the specified name.
	 */

	public ComputerPlayer() {
		super(NAME);
	}

	/**
	 * Implements Player's setMaximumRolls, but is not normally called by client
	 * objects. Instead, clients usually call the 0-parameter version
	 * 
	 * @param maximumRolls The maximum number of times the computer will roll before
	 *                     holding
	 */
	public void setMaximumRolls(int maximumRolls) {
		this.maximumRolls = maximumRolls;
	}

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
			super.thePair.rollDice();

			int die1Value = super.thePair.getDie1Value();
			int die2Value = super.thePair.getDie2Value();
			if (die1Value == 1 || die2Value == 1) {	
				super.total -= super.turnTotal;
			} else {
				super.turnTotal += die1Value + die2Value;
				super.total += die1Value + die2Value;
				
			}
		}
		super.isMyTurn = false;
	}

}
