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
		super.getDicePair().rollDice();

		int die1Value = super.getDicePair().getDie1Value();
		int die2Value = super.getDicePair().getDie2Value();
		int total =  super.getTotal();
		int turnTotal = super.getTurnTotal();
		
		if (die1Value == 1 || die2Value == 1) {
			total -= turnTotal;
	
			super.resetTurnTotal();
			super.setIsMyTurn(false);
		} else {
			turnTotal += die1Value + die2Value;
			total += die1Value + die2Value;
			super.setTurnTotal(turnTotal);
		
			super.setIsMyTurn(true);
		}
		super.setTotal(total);
	}

}
