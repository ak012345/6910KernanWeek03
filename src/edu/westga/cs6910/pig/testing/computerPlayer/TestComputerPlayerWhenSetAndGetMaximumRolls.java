package edu.westga.cs6910.pig.testing.computerPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;

/**
 * JUnit test that tests the getter & setter methods for the number of rolls
 * 
 * @author Alex Kernan
 * @version 6/14/2021
 *
 */
class TestComputerPlayerWhenSetAndGetMaximumRolls {

	@Test
	void testWhenSetMaximumRollsToDefaultOFOne() {
		ComputerPlayer testComputerPlayer = new ComputerPlayer();
		testComputerPlayer.setMaximumRolls();
		testComputerPlayer.setIsMyTurn(true);
		assertEquals(1, testComputerPlayer.getMaximumNumberOfRolls());
	}

	@Test
	void testWhenSetMaximumRollsToFive() {
		ComputerPlayer testComputerPlayer = new ComputerPlayer();
		testComputerPlayer.setMaximumRolls(5);
		testComputerPlayer.setIsMyTurn(true);
		assertEquals(5, testComputerPlayer.getMaximumNumberOfRolls());
	}
}
