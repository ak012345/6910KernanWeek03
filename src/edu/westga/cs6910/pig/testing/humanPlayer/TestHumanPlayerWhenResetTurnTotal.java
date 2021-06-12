package edu.westga.cs6910.pig.testing.humanPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * JUnit test that checks if the player's turnTotoal is set to zero via the
 * resetTurnTotal() method
 * 
 * @author Alex Kernan
 * @version 6/12/2021
 *
 */
class TestHumanPlayerWhenResetTurnTotal {

	@Test
	void testWhenSettingTotalTo50() {
		HumanPlayer testHumanPlayer = new HumanPlayer("Alex");
		testHumanPlayer.setTurnTotal(50);
		testHumanPlayer.resetTurnTotal();
		assertEquals(0, testHumanPlayer.getTurnTotal());
	}

}
