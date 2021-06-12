package edu.westga.cs6910.pig.testing.humanPlayer;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * Tests the setter/getter methods of the HumanPLayer class.
 * 
 * @author Alex Kernan
 * @version 6/12/2021
 */
class TestHumanPlayerWhenSetAndGetIsMyTurn {

	@Test
	void testWhenIsMyTurnCalledIsTrue() {
		HumanPlayer testHumanPlayer = new HumanPlayer("Alex");
		testHumanPlayer.setIsMyTurn(true);
		assertTrue(testHumanPlayer.getIsMyTurn());
	}
	
	@Test
	void testWhenIsMyTurnCalledIsFalse() {
		HumanPlayer testHumanPlayer = new HumanPlayer("Alex");
		testHumanPlayer.setIsMyTurn(false);
		assertFalse(testHumanPlayer.getIsMyTurn());
	}
}
