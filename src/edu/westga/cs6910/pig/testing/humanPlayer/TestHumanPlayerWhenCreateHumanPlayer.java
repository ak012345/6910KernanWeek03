package edu.westga.cs6910.pig.testing.humanPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.Player;

/**
 * Tests the creation of a HumanPlayer Object as well as the associated getters
 * associated with the instance variables set while the object's constructor is
 * called; also tests that the Object is an instance of PLayer, as it's
 * superclass is that which implements it.
 * 
 * @author Alex Kernan
 * @version 6/12/2021
 *
 */

class TestHumanPlayerWhenCreateHumanPlayer {

	@Test
	void testWhenCreateHumanNameIsAlex() {
		HumanPlayer testHumanPlayer = new HumanPlayer("Alex");
		assertEquals("Alex", testHumanPlayer.getName());
	}

	@Test
	void testWhenCreateHumanDiceVaueInitializedDieOneEqualsOne() {
		HumanPlayer testHumanPlayer = new HumanPlayer("Alex");
		assertEquals(1, testHumanPlayer.getDicePair().getDie1Value());

	}

	@Test
	void testWhenCreateHumanDiceVaueInitializedDieTwoEqualsTwo() {
		HumanPlayer testHumanPlayer = new HumanPlayer("Alex");
		assertEquals(1, testHumanPlayer.getDicePair().getDie1Value());
	}

	@Test
	void testHumanPlayerIsAnInstanceOfPlayer() {
		HumanPlayer testHumanPlayer = new HumanPlayer("Alex");
		assertTrue(testHumanPlayer instanceof Player);
	}

}
