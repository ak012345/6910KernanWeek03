package edu.westga.cs6910.pig.testing.computerPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;

/**
 * JUnit test that checks if the player's turnTotoal is set to zero via the
 * resetTurnTotal() method
 * 
 * @author Alex Kernan
 * @version 6/12/2021
 *
 */
class TestComputerPlayerWhenResetTurnTotal {

	@Test
	void testWhenSettingTotalTo50() {
		ComputerPlayer testComputerPlayer = new ComputerPlayer();
		testComputerPlayer.setTurnTotal(50);
		testComputerPlayer.resetTurnTotal();
		assertEquals(0, testComputerPlayer.getTurnTotal());
	}

}
