package edu.westga.cs6910.pig.model;

/**
 * Abstract superclass that has common elements required of a Pig player.
 * 
 * @author Alex Kernan
 * @version 6/8/2021
 */
public abstract class AbstractPlayer implements Player {

	private String name;
	private DicePair thePair;
	private boolean isMyTurn;
	private int total;
	private int turnTotal;

	/**
	 * Abstract constructor method
	 * 
	 * @requires name != null
	 * @param name the name of the player
	 */
	public AbstractPlayer(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Player's name cannot be null");
		}
		this.name = name;
		this.thePair = new DicePair();
		this.total = 0;
		this.turnTotal = 0;
	}

	/**
	 * reset turn total to zero
	 */
	public void resetTurnTotal() {
		this.turnTotal = 0;
	}

	/**
	 * Sets the turnTotal instance variable. Utilizing default modifier so only
	 * classes in this package can use it. cannot be part of the Player interface
	 * because we are not able to down-grade the access modifier
	 * 
	 * @requires turnTotal >= 0
	 */
	void setTurnTotal(int turnTotal) {
		if (turnTotal < 0) {
			throw new IllegalArgumentException("turnTotal cannot be negative");
		}
		this.turnTotal = turnTotal;
	}

	/**
	 * Sets the turnTotal instance variable. Utilizing default modifier so only
	 * classes in this package can use it. cannot be part of the Player interface
	 * because we are not able to down-grade the access modifier
	 */
	void setTotal(int total) {
		if (total < 0) {
			throw new IllegalArgumentException("total cannot be negative");
		}
		this.total = total;
	}

	@Override
	public void setIsMyTurn(boolean isMyTurn) {
		this.isMyTurn = isMyTurn;
	}

	@Override
	public DicePair getDicePair() {
		return this.thePair;
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