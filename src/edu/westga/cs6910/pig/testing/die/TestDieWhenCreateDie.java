package edu.westga.cs6910.pig.testing.die;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.Die;

/**
 * Tests that a die object is created as expected
 * 
 * @author Alex Kernan
 * @version 6/12/2021
 */
public class TestDieWhenCreateDie {

	@Test
	void testWhenDieIsCreated() {
		Die testDie = new Die();
		assertEquals("pips: 1", testDie.toString());
	}

}
