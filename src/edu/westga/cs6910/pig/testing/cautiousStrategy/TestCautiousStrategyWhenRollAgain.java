package edu.westga.cs6910.pig.testing.cautiousStrategy;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;
import edu.westga.cs6910.pig.model.strategies.PigStrategy;

class TestCautiousStrategyWhenRollAgain {

	@Test
	void testCautiousStrategyretrunRollAgainShouldBeFalse() {
		PigStrategy testStrategy = new CautiousStrategy();
		assertFalse(testStrategy.rollAgain(1, 1, 1));
	}
}
