package edu.westga.cs6910.pig.testing.greedyStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.GreedyStrategy;
import edu.westga.cs6910.pig.model.strategies.PigStrategy;

/**
 * Tests the getStrategyName() method within the GreedyStrategy class.
 * 
 * @author Alex Kernan
 * @version 6/21/2021
 */
class TestGreedyStrategyWhenGetStrategyName {

	@Test
	void testGreedyStrategyGetName() {
		PigStrategy testStrategy = new GreedyStrategy();
		assertEquals("Greedy", testStrategy.getStrategyName());
	}

}
