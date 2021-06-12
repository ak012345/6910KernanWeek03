package edu.westga.cs6910.pig.testing.humanPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 *  Test the HumanPlayer setTotal() and getTotal() Functionality
 *  
 * @author Alex Kernan
 * @version 6/12/2021
 *
 */

public class TestHumanPlayerWhenSetAndGetTotal {

	@Test
	void testWhenSettingTotalTo50() {
		HumanPlayer testHumanPlayer = new HumanPlayer("Alex");
		testHumanPlayer.setTotal(50);
		assertEquals(50, testHumanPlayer.getTotal());
	}
}
