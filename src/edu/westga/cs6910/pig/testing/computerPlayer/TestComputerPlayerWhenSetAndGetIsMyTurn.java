package edu.westga.cs6910.pig.testing.computerPlayer;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;
import edu.westga.cs6910.pig.model.strategies.PigStrategy;

/**
 * Tests the setter/getter methods of the ComputerPLayer class.
 * 
 * @author Alex Kernan
 * @version 6/12/2021
 */
class TestComputerPlayerWhenSetAndGetIsMyTurn {

	@Test
	void testWhenIsMyTurnCalledIsTrue() {
		PigStrategy currentStrategy =  new CautiousStrategy();
		ComputerPlayer testComputerPlayer = new ComputerPlayer(currentStrategy);
		testComputerPlayer.setIsMyTurn(true);
		assertTrue(testComputerPlayer.getIsMyTurn());
	}

	@Test
	void testWhenIsMyTurnCalledIsFalse() {
		PigStrategy currentStrategy =  new CautiousStrategy();
		ComputerPlayer testComputerPlayer = new ComputerPlayer(currentStrategy);
		testComputerPlayer.setIsMyTurn(false);
		assertFalse(testComputerPlayer.getIsMyTurn());
	}
}
