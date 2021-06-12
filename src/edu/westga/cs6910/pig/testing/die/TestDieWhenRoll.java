package edu.westga.cs6910.pig.testing.die;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.Die;

/**
 * Test that utilizes the die Object's GetNumberOfPips() method to see if the
 * number rolled is ever outside the expected parameters (1 through 6)
 * 
 * @author Alex Kenan
 * @version 6/12/2021
 */

class TestDieWhenRoll {

	@Test
	void testWhenRollSingleDieWithFiftyAttempts() {
		Die testDie = new Die();
		for (int rollNumber = 0; rollNumber < 50; rollNumber++) {
			testDie.roll();
			if ((testDie.getNumberOfPips() < 1) || (testDie.getNumberOfPips() > 6)) {
				fail("Bad die value! Number of pips:  " + testDie.getNumberOfPips());
			}
		}
	}

}
