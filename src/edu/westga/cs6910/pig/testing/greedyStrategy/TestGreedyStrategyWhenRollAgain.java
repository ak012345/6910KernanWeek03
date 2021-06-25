package edu.westga.cs6910.pig.testing.greedyStrategy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.GreedyStrategy;
import edu.westga.cs6910.pig.model.strategies.PigStrategy;

/**
 * checks that the rollAgain method only tries to roll up to 3 times (0 up to
 * 2). NOTE: Roll occurs after this check, so number of rolls equals N+1
 * 
 * @author Alex Kernan
 * @version 6/21/2021
 *
 */
class TestGreedyStrategyWhenRollAgain {

	@Test
	void testGreedyStrategyRollAgainAfterOneRollsShouldBeTrue() {
		PigStrategy testStrategy = new GreedyStrategy();
		assertTrue(testStrategy.rollAgain(0, 99, 99));
	}

	@Test
	void testGreedyStrategyRollAgainAfterTwoRollsShouldBeTrue() {
		PigStrategy testStrategy = new GreedyStrategy();
		assertTrue(testStrategy.rollAgain(1, 99, 99));
	}

	@Test
	void testGreedyStrategyRollAgainAfterThreeRollsShouldBeFalse() {
		PigStrategy testStrategy = new GreedyStrategy();
		assertFalse(testStrategy.rollAgain(3, 99, 99));
	}

}
