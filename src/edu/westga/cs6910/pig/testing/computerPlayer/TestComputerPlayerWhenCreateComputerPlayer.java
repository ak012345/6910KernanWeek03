package edu.westga.cs6910.pig.testing.computerPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Player;

/**
 * Tests the creation of a ComputerPlayer Object as well as the associated
 * getters associated with the instance variables set while the object's
 * constructor is called; also tests that the Object is an instance of PLayer,
 * as it's superclass is that which implements it.
 * 
 * @author Alex Kernan
 * @version 6/12/2021
 *
 */

class TestComputerPlayerWhenCreateComputerPlayer {

	@Test
	void testWhenCreateComputerNameIsAlex() {
		ComputerPlayer testComputerPlayer = new ComputerPlayer();
		assertEquals("Simple Computer", testComputerPlayer.getName());
	}

	@Test
	void testWhenCreateComputerDiceVaueInitializedDieOneEqualsOne() {
		ComputerPlayer testComputerPlayer = new ComputerPlayer();
		assertEquals(1, testComputerPlayer.getDicePair().getDie1Value());

	}

	@Test
	void testWhenCreateComputerDiceVaueInitializedDieTwoEqualsTwo() {
		ComputerPlayer testComputerPlayer = new ComputerPlayer();
		assertEquals(1, testComputerPlayer.getDicePair().getDie1Value());
	}

	@Test
	void testComputerPlayerIsAnInstanceOfPlayer() {
		ComputerPlayer testComputerPlayer = new ComputerPlayer();
		assertTrue(testComputerPlayer instanceof Player);
	}

}
