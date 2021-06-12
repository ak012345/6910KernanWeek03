package edu.westga.cs6910.pig.testing.humanPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

class TestHumanPlayerWhenSetAndGetTurnTotal {

	@Test
	void testWhenSettingTotalTo50() {
		HumanPlayer testHumanPlayer = new HumanPlayer("Alex");
		testHumanPlayer.setTurnTotal(50);
		assertEquals(50, testHumanPlayer.getTurnTotal());
	}
}
