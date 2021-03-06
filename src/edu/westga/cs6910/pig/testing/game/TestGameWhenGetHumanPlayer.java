package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;
import edu.westga.cs6910.pig.model.strategies.PigStrategy;

/**
 * JUnit test for the getHumanPlayer method() within the game model class.
 * 
 * @author Alex Kernan
 * @version 6/14/2021
 *
 */

public class TestGameWhenGetHumanPlayer {

	@Test
	void testGetHumanPlayerMethod() {
		HumanPlayer testHuman = new HumanPlayer("Alex");
		PigStrategy currentStrategy =  new CautiousStrategy();
		ComputerPlayer testComputer = new ComputerPlayer(currentStrategy);
		Game testGame = new Game(testHuman, testComputer);
		assertEquals(testHuman, testGame.getHumanPlayer());
	}
}
