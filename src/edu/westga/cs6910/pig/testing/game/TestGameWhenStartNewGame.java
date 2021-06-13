package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * 
 * @author Alex Kernan
 * @version 6/12/2021
 *
 */
class TestGameWhenStartNewGame {

	@Test
	void testStartNewGameHumanGoesFirst() {
		HumanPlayer testHuman = new HumanPlayer("Alex");
		ComputerPlayer testComputer = new ComputerPlayer();
		Game testGame = new Game(testHuman, testComputer);
		testGame.startNewGame(testHuman);
		assertEquals(testHuman, testGame.getCurrentPlayer());
	}
	
	@Test
	void testStartNewGameComputerGoesFirst() {
		HumanPlayer testHuman = new HumanPlayer("Alex");
		ComputerPlayer testComputer = new ComputerPlayer();
		Game testGame = new Game(testHuman, testComputer);
		testGame.startNewGame(testComputer);
		assertEquals(testComputer, testGame.getCurrentPlayer());
	}
}