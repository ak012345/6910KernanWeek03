package edu.westga.cs6910.pig.testing.cautiousStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;
import edu.westga.cs6910.pig.model.strategies.PigStrategy;

/**
 * Tests the getStrategyName() method within the cautiousStrategy class.
 * 
 * @author Alex Kernan
 * @version 6/21/2021
 *
 */
class TestCautionsStrategyWhenGetStartegyName {

	@Test
	void testCautiousStrategyGetName() {
		PigStrategy testStrategy = new CautiousStrategy();
		assertEquals("Cautious", testStrategy.getStrategyName());
	}
}
