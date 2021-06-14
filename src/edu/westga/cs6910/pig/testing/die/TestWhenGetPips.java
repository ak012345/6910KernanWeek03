package edu.westga.cs6910.pig.testing.die;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.Die;

/**
 * 
 * Test that the getNumebrOfPips() method returns the Expected integer Value.
 * 
 * @author Alex Kernan
 * @version 6/12/2021
 *
 */

public class TestWhenGetPips {

	@Test
	void testWithNewDieShouldHave1Pip() {
		Die testDie = new Die();
		assertEquals(1, testDie.getNumberOfPips());
	}

}
