package edu.westga.cs6910.pig.model;

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

	/**
	 * Creates a new ComputerPlayer with the specified name.
	 */

	public ComputerPlayer() {
		super(NAME);
		this.setMaximumRolls();
	}

	/**
	 * Implements Player's setMaximumRolls, but is not normally called by client
	 * objects. Instead, clients usually call the 0-parameter version
	 * 
	 * @requires maximumRolls >0
	 * 
	 * @param maximumRolls The maximum number of times the computer will roll before
	 *                     holding
	 */
	public void setMaximumRolls(int maximumRolls) {
		if (maximumRolls <= 0) {
			throw new IllegalArgumentException("Maximum number of rolls must be greater than 0");
		}
		this.maximumRolls = maximumRolls;
	}

	/**
	 * Getter method for the maximumRolls instance variable
	 * 
	 * @return maximumRolls the number of rolls the computer should make in it's
	 * turn
	 */
	public int getMaximumNumberOfRolls() {
		return this.maximumRolls;

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
	}

}
