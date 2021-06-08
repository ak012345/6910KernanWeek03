package edu.westga.cs6910.pig.model;

// TODO: Classes ComputerPlayer and HumanPlayer share most of their code.
//		 Refactor their code:
// 		 1. Create abstract base class AbstractPlayer to implement the
//			shared code and define abstract methods for methods without
//			duplicate code. AbstractPlayer should implement interface Player.
//		 2. Have ComputerPlayer and HumanPlayer extend AbstractPlayer to
//		    implement the unshared constructor code and the abstract methods.

/**
 * ComputerPlayer represents a very simple automated player in the game Pig.
 * It rolls exactly 1 time and then holds.
 * 
 * @author CS6910
 * @version Summer 2021
 */
public class ComputerPlayer extends AbstractPlayer {
	private static final String NAME = "Simple computer";
	private int maximumRolls;
	private int total;
	private int turnTotal;
	private boolean isMyTurn;
	/**
	 * Creates a new ComputerPlayer with the specified name.
	 */
	public ComputerPlayer() {
		this.name = NAME;
		
		this.thePair = new DicePair();
	}

	/**
	 * Implements Player's setMaximumRolls, but is not normally
	 * called by client objects.  Instead, clients usually
	 * call the 0-parameter version
	 * 
	 * @param	maximumRolls	The maximum number of times the computer
	 * 							will roll before holding
	 */
	public void setMaximumRolls(int maximumRolls) {
		this.maximumRolls = maximumRolls;
	}

	/**
	 * Implements Player's setMaximumRolls() to set the 
	 * maximum number of rolls to 1
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
			this.thePair.rollDice();
			
			int die1Value = this.thePair.getDie1Value();
			int die2Value = this.thePair.getDie2Value();
			if (die1Value == 1 || die2Value == 1) {
				this.total -= this.turnTotal;
				this.isMyTurn = false;
				return;
			} else {		
				this.turnTotal += die1Value + die2Value;
				this.total += die1Value + die2Value;		
			}		
		}
		this.isMyTurn = false;
	}
}
