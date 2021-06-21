package edu.westga.cs6910.pig.testing.randomStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.PigStrategy;
import edu.westga.cs6910.pig.model.strategies.RandomStrategy;

/**
 * Tests the getStrategyName() method within the RandomStrategy class.
 * 
 * @author Alex Kernan
 * @version 6/21/2021
 *
 */
class TestRandomStrategyWhenGetStrategyName {

	@Test
	void testRandomStrategyGetName() {
		PigStrategy testStrategy = new RandomStrategy();
		assertEquals("Random", testStrategy.getStrategyName());
	}

}
