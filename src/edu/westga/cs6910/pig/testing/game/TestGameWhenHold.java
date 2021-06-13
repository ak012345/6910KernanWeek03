package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.Player;

/**
 * 
 * JUnit Test the validates the Game object's hold() method switches the current player
 * 
 * @author Alex Kernan
 * @version 6/12/2021
 *
 */
class TestGameWhenHold {

	@Test
	void testHoldTurnSwitchesCurrentPlayerHumanToComputer() {
		HumanPlayer testHuman = new HumanPlayer("Alex");
		ComputerPlayer testComputer = new ComputerPlayer();
		Game testGame = new Game(testHuman, testComputer);
		testGame.startNewGame(testHuman);
		Player preHoldPlayer = testGame.getCurrentPlayer();
		testGame.hold();
		assertTrue(preHoldPlayer != testGame.getCurrentPlayer());
	}

	@Test
	void testHoldTurnSwitchesCurrentPlayerComputerToHuman() {
		HumanPlayer testHuman = new HumanPlayer("Alex");
		ComputerPlayer testComputer = new ComputerPlayer();
		Game testGame = new Game(testHuman, testComputer);
		testGame.startNewGame(testComputer);
		Player preHoldPlayer = testGame.getCurrentPlayer();
		testGame.hold();
		assertTrue(preHoldPlayer != testGame.getCurrentPlayer());
	}
}
