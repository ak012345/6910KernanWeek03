package edu.westga.cs6910.pig.testing.computerPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;

/**
 * Test the ComputerPlayer setTotal() and getTotal() Functionality
 * 
 * @author Alex Kernan
 * @version 6/12/2021
 *
 */

public class TestComputerPlayerWhenSetAndGetTotal {

	@Test
	void testWhenSettingTotalTo50() {
		ComputerPlayer testComputerPlayer = new ComputerPlayer();
		testComputerPlayer.setTotal(50);
		assertEquals(50, testComputerPlayer.getTotal());
	}
}
