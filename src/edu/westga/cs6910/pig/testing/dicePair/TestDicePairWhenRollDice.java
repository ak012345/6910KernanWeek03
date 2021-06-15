package edu.westga.cs6910.pig.testing.dicePair;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.DicePair;

/**
 * 
 * Tests that the dice are rolled and that their values fall within the allowed
 * range (1 through 6)
 * 
 * @author Alex Kernan
 * @version 6/12/2021
 */

public class TestDicePairWhenRollDice {

	@Test
	void testWhenRollDicePairTenThousandTimes() {
		DicePair testPair = new DicePair();

		for (int rollNumber = 0; rollNumber < 10000; rollNumber++) {
			testPair.rollDice();
			if ((testPair.getDie1Value() < 1) || (testPair.getDie1Value() > 6)) {
				fail("Bad Die1 value! Number was:  " + testPair.getDie1Value());
			}
			if ((testPair.getDie2Value() < 1) || (testPair.getDie2Value() > 6)) {
				fail("Bad Die2 value! Number was:  " + testPair.getDie1Value());
			}
		}

	}

}
