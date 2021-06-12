package edu.westga.cs6910.pig.testing.humanPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * JUnit test to ensure the getDiceValues() method functions as expected. 
 * 
 * @author AlexKernan
 * @version 6/12/2021
 */

public class TestHumanPlayerWhenGetDiceValues {

	@Test
	void testWhenGetDiceValuesMethodIsCalledOneOne() {
		HumanPlayer testHumanPlayer = new HumanPlayer("Alex");
		assertEquals("1, 1", testHumanPlayer.getDiceValues());
	}
}
