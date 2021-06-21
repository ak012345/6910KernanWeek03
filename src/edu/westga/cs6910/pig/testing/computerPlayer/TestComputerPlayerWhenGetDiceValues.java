package edu.westga.cs6910.pig.testing.computerPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;
import edu.westga.cs6910.pig.model.strategies.PigStrategy;

/**
 * JUnit test to ensure the getDiceValues() method functions as expected.
 * 
 * @author AlexKernan
 * @version 6/12/2021
 */

public class TestComputerPlayerWhenGetDiceValues {

	@Test
	void testWhenGetDiceValuesMethodIsCalledOneOne() {
		PigStrategy currentStrategy =  new CautiousStrategy();
		ComputerPlayer testComputerPlayer = new ComputerPlayer(currentStrategy);
		assertEquals("1, 1", testComputerPlayer.getDiceValues());
	}
}
