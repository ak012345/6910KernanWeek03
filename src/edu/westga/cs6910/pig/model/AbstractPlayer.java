package edu.westga.cs6910.pig.model;

/**
 * Abstract superclass that has common elements required of a Pig player.
 * 
 * @author Alex Kernan
 * @version 6/8/2021
 *
 */
public class AbstractPlayer implements Player{

	protected String name;
	protected DicePair thePair;
	private boolean isMyTurn;
	private int total;
	private int turnTotal;

	public AbstractPlayer() {
		super();
	}


	public void resetTurnTotal() {
		this.turnTotal = 0;
	}


	public void takeTurn() {	
		this.thePair.rollDice();
		
		int die1Value = this.thePair.getDie1Value();
		int die2Value = this.thePair.getDie2Value();
		if (die1Value == 1 || die2Value == 1) {	
			this.total -= this.turnTotal;
			this.isMyTurn = false;
		} else {
			this.turnTotal += die1Value + die2Value;
			this.total += die1Value + die2Value;
			this.isMyTurn = true;
		}
	}

	@Override
	public boolean getIsMyTurn() {
		return this.isMyTurn;
	}

	@Override
	public int getTurnTotal() {
		return this.turnTotal;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getDiceValues() {
		//need null pointer exception handler
		return this.thePair.getDie1Value() + ", " + this.thePair.getDie2Value();
	}

	@Override
	public int getTotal() {
		return this.total;
	}

}