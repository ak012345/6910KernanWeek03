package edu.westga.cs6910.pig.model;

/**
 * HumanPlayer represents a human player in the game Pig.
 * 
 * @author Alex Kernan
 * @version 6/8/2021
 */
public class HumanPlayer extends AbstractPlayer {

	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * 
	 * @param name this Player's name
	 * 
	 * @requires name != null
	 * @ensure name().equals(name) && getTotal() == 0
	 */
	public HumanPlayer(String name) {
		super(name);

	}

	/**
	 * takes the players turn. consists of rolling the dice, adding the totals, and
	 * setting the players turn
	 */
	public void takeTurn() {
		super.thePair.rollDice();

		int die1Value = super.thePair.getDie1Value();
		int die2Value = super.thePair.getDie2Value();
		if (die1Value == 1 || die2Value == 1) {
			super.total -= super.turnTotal;
			super.isMyTurn = false;
		} else {
			super.turnTotal += die1Value + die2Value;
			super.total += die1Value + die2Value;
			super.isMyTurn = true;
		}
	}

}
