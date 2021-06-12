package edu.westga.cs6910.pig.testing.dicePair;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.DicePair;

/**
 * Tests the creation of a dice pair as well as the getDie#Value() methods
 * 
 * @author Alex Kernan
 * @version 6/12/2021
 *
 */

public class TestDicePairWhenCreateDicePair {

	@Test
	void testWhenNewDicePairCreated() {
		DicePair testPair = new DicePair();
		if (testPair.getDie1Value() != 1) {
			fail("Dice 1 not properly created");
		}
		if (testPair.getDie2Value() != 1) {
			fail("Dice 2 not properly created");
		}
	}

}
