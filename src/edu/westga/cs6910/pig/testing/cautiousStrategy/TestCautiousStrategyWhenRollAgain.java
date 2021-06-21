package edu.westga.cs6910.pig.testing.cautiousStrategy;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;
import edu.westga.cs6910.pig.model.strategies.PigStrategy;

/**
 * checks that the rollAgain method always returns false.
 * 
 * @author Alex Kernan
 * @verison 6/21/2021
 *
 */

class TestCautiousStrategyWhenRollAgain {

	@Test
	void testCautiousStrategyretrunRollAgainShouldBeFalse111() {
		PigStrategy testStrategy = new CautiousStrategy();
		assertFalse(testStrategy.rollAgain(1, 1, 1));
	}

	@Test
	void testCautiousStrategyretrunRollAgainShouldBeFalse123() {
		PigStrategy testStrategy = new CautiousStrategy();
		assertFalse(testStrategy.rollAgain(1, 2, 3));
	}
}
