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
	 * @ensure name().equals(name) && getTotal() == 0
	 */
	public HumanPlayer(String name) {
		super(name);
	}

}
