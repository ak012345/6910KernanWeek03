package edu.westga.cs6910.pig.model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Game represents a Pig game.
 * 
 * @author ALex Kernan
 * @version 6/12/2021
 */
public class Game implements Observable {
	/**
	 * The goal score for the game
	 */
	public static final int GOAL_SCORE = 20;

	private ObjectProperty<Player> currentPlayerObject;
	private HumanPlayer theHuman;
	private ComputerPlayer theComputer;

	/**
	 * Creates a Pig Game with the specified Players and a pair of dice.
	 * 
	 * @param theComputer the automated player
	 * @param theHuman    the human player
	 * 
	 * @require theHuman != null && theComputer != null
	 * 
	 * @ensure humanPlayer().equals(theHuman) && computerPlayer.equals(theComputer)
	 */
	public Game(HumanPlayer theHuman, ComputerPlayer theComputer) {

		if (theHuman == null) {
			throw new IllegalArgumentException("HumanPlayer cannot be null");
		}
		if (theComputer == null) {
			throw new IllegalArgumentException("ComputerPlayer cannot be null");
		}

		this.theHuman = theHuman;
		this.theComputer = theComputer;
		this.currentPlayerObject = new SimpleObjectProperty<Player>();

	}

	/**
	 * Initializes the game for play.
	 * 
	 * @param firstPlayer the Player who takes the first turn
	 * 
	 * @require firstPlayer != null && firstPlayer.getTotal() == 0
	 * 
	 * @ensures whoseTurn().equals(firstPlayer)
	 */
	public void startNewGame(Player firstPlayer) {
		if (firstPlayer == null) {
			throw new IllegalArgumentException("Player cannot be null");
		}
		if (firstPlayer.getTotal() != 0) {
			throw new IllegalArgumentException("This player already has a score");
		}
		if (firstPlayer.getTurnTotal() != 0) {
			throw new IllegalArgumentException("This player has already taken a turn");
		}

		firstPlayer.setIsMyTurn(true);
		this.currentPlayerObject.setValue(firstPlayer);
	}

	/**
	 * Conducts a move in the game, allowing the appropriate Player to take a turn.
	 * Has no effect if the game is over.
	 * 
	 * @ensures !whoseTurn().equals(whoseTurn()@prev)
	 */
	public void play() {

		Player currentPlayer = this.currentPlayerObject.getValue();

		this.currentPlayerObject.getValue().takeTurn();

		this.currentPlayerObject.setValue(null);
		this.currentPlayerObject.setValue(currentPlayer);

		if (!this.currentPlayerObject.getValue().getIsMyTurn()) {
			this.hold();
		}

	}

	/**
	 * Notifies the game that the player is holding
	 * 
	 * @requires !isGameOver()
	 * 
	 */
	public void hold() {
		if (!this.isGameOver()) {
			this.swapWhoseTurn();
		}
	}

	/**
	 * Returns the human Player object.
	 * 
	 * @return the human Player
	 */
	public AbstractPlayer getHumanPlayer() {
		return this.theHuman;
	}

	/**
	 * Returns the computer Player object.
	 * 
	 * @return the computer Player
	 */
	public ComputerPlayer getComputerPlayer() {
		return this.theComputer;
	}

	/**
	 * Returns the Player whose turn it is.
	 * 
	 * @return the current Player
	 */
	public Player getCurrentPlayer() {
		return this.currentPlayerObject.getValue();
	}

	/**
	 * Return whether the game is over.
	 * 
	 * @return true iff currentPlayer.getTotal() >= GOAL_SCORE
	 */
	public boolean isGameOver() {
		if (this.currentPlayerObject.getValue() == null) {
			return true;
		}

		if (this.theHuman.getTotal() >= GOAL_SCORE || this.theComputer.getTotal() >= GOAL_SCORE) {
			return true;
		}
		return false;
	}

	/**
	 * Returns a String showing the goal score, or, if the game is over, the name of
	 * the winner.
	 * 
	 * @return a String representation of this Game
	 */
	public String toString() {
		String result = "Goal Score: " + GOAL_SCORE;
		result += System.getProperty("line.separator") + this.theHuman.getName() + ": " + this.theHuman.getTotal();
		result += System.getProperty("line.separator") + this.theComputer.getName() + ": "
				+ this.theComputer.getTotal();

		if (this.theHuman.getTotal() >= GOAL_SCORE) {
			return result + System.getProperty("line.separator") + "Game over! Winner: " + this.theHuman.getName();
		} else if (this.theComputer.getTotal() >= GOAL_SCORE) {
			return result + System.getProperty("line.separator") + "Game over! Winner: " + this.theComputer.getName();
		} else {
			return result;
		}
	}

	private void swapWhoseTurn() {
		if (this.getCurrentPlayer() == this.theHuman) {
			this.currentPlayerObject.set(this.theComputer);
			this.currentPlayerObject.getValue().setIsMyTurn(true);
			this.theComputer.setIsMyTurn(true);
			this.theComputer.resetTurnTotal();
		} else {
			this.currentPlayerObject.set(this.theHuman);
			this.currentPlayerObject.getValue().setIsMyTurn(true);
			this.theHuman.setIsMyTurn(true);
			this.theHuman.resetTurnTotal();
		}

	}

	@Override
	public void addListener(InvalidationListener theListener) {
		this.currentPlayerObject.addListener(theListener);
	}

	@Override
	public void removeListener(InvalidationListener theListener) {
		this.currentPlayerObject.removeListener(theListener);
	}

}
