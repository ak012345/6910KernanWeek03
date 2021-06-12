package edu.westga.cs6910.pig.testing.computerPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;

/**
 * JUnit test that validates that the ComputerPLayer's TurnTotal getters/setters
 * function as intended.
 * 
 * @author Alex Kernan
 * @version 6/12/2021
 */
class TestComputerPlayerWhenSetAndGetTurnTotal {

	@Test
	void testWhenSettingTotalTo50() {
		ComputerPlayer testComputerPlayer = new ComputerPlayer();
		testComputerPlayer.setTurnTotal(50);
		assertEquals(50, testComputerPlayer.getTurnTotal());
	}
}
