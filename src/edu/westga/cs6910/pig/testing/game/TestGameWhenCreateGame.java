package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * JUnit test that ensures the constructor initializes the instance variables as
 * desired.expected
 * 
 * @author Alex Kernan
 * @version 6/12/2021
 */
class TestGameWhenCreateGame {

	@Test
	void testConstructorAndToStringMethodWhenCreateGameObject() {
		HumanPlayer testHuman = new HumanPlayer("Alex");
		ComputerPlayer testComputer = new ComputerPlayer();
		Game testGame = new Game(testHuman, testComputer);
		assertEquals("Goal Score: 20\r\n" + "Alex: 0\r\n" + "Simple Computer: 0", testGame.toString());
	}

}
