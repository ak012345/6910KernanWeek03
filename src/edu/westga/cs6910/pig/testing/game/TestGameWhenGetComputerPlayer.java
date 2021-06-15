package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * JUnit test for the getHumanPlayer method() within the game model class.
 * 
 * @author Alex Kernan
 * @version 6/14/2021
 *
 */
public class TestGameWhenGetComputerPlayer {

	@Test
	void testGetComputerPlayerMethod() {
		HumanPlayer testHuman = new HumanPlayer("Alex");
		ComputerPlayer testComputer = new ComputerPlayer();
		Game testGame = new Game(testHuman, testComputer);
		assertEquals(testComputer, testGame.getComputerPlayer());
	}

}
