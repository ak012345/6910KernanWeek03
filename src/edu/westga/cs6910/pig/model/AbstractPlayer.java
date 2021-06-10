package edu.westga.cs6910.pig.model;

/**
 * Abstract superclass that has common elements required of a Pig player.
 * 
 * @author Alex Kernan
 * @version 6/8/2021
 */
public abstract class AbstractPlayer implements Player {

	String name;
	DicePair thePair;
	boolean isMyTurn;
	int total;
	int turnTotal;

	/**
	 * Abstract constructor method
	 * @param name the name of the player
	 */
	public AbstractPlayer(String name) {

		this.name  = name;
		this.thePair =  new DicePair();
		
	}

	/**
	 * reset turn total to zero
	 */
	public void resetTurnTotal() {
		this.turnTotal = 0;
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

		return this.thePair.getDie1Value() + ", " + this.thePair.getDie2Value();
	}

	@Override
	public int getTotal() {
		return this.total;
	}

}