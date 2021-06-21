package edu.westga.cs6910.pig.testing.computerPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;
import edu.westga.cs6910.pig.model.strategies.PigStrategy;

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
		PigStrategy currentStrategy =  new CautiousStrategy();
		ComputerPlayer testComputerPlayer = new ComputerPlayer(currentStrategy);
		testComputerPlayer.setTurnTotal(50);
		assertEquals(50, testComputerPlayer.getTurnTotal());
	}
}
