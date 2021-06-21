package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;
import edu.westga.cs6910.pig.model.strategies.PigStrategy;

/**
 * JUnit test that ensures the constructor initializes the instance variables as
 * desired.expected
 * 
 * @author Alex Kernan
 * @version 6/12/2021
 */
public class TestGameWhenCreateGame {

	@Test
	void testConstructorAndToStringMethodWhenCreateGameObject() {
		HumanPlayer testHuman = new HumanPlayer("Alex");
		PigStrategy currentStrategy =  new CautiousStrategy();
		ComputerPlayer testComputerPlayer = new ComputerPlayer(currentStrategy);
		Game testGame = new Game(testHuman, testComputerPlayer);
		assertEquals("Goal Score: " + Game.GOAL_SCORE + "\r\n" + "Alex: 0\r\n" + "Simple Computer: 0", testGame.toString());
	}

}
