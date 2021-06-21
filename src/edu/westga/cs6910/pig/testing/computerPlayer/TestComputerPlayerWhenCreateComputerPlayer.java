package edu.westga.cs6910.pig.testing.computerPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Player;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;
import edu.westga.cs6910.pig.model.strategies.PigStrategy;

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
		PigStrategy currentStrategy =  new CautiousStrategy();
		ComputerPlayer testComputerPlayer = new ComputerPlayer(currentStrategy);
		assertEquals("Simple Computer", testComputerPlayer.getName());
	}

	@Test
	void testWhenCreateComputerDiceVaueInitializedDieOneEqualsOne() {
		PigStrategy currentStrategy =  new CautiousStrategy();
		ComputerPlayer testComputerPlayer = new ComputerPlayer(currentStrategy);
		assertEquals(1, testComputerPlayer.getDicePair().getDie1Value());

	}

	@Test
	void testWhenCreateComputerDiceVaueInitializedDieTwoEqualsTwo() {
		PigStrategy currentStrategy =  new CautiousStrategy();
		ComputerPlayer testComputerPlayer = new ComputerPlayer(currentStrategy);
		assertEquals(1, testComputerPlayer.getDicePair().getDie1Value());
	}

	@Test
	void testComputerPlayerIsAnInstanceOfPlayer() {
		PigStrategy currentStrategy =  new CautiousStrategy();
		ComputerPlayer testComputerPlayer = new ComputerPlayer(currentStrategy);
		assertTrue(testComputerPlayer instanceof Player);
	}

}
