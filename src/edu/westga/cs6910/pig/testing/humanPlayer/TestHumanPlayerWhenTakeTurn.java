package edu.westga.cs6910.pig.testing.humanPlayer;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * 
 * 
 * @author Alex Kernan
 * @version 6/12/2021
 */
class TestHumanPlayerWhenTakeTurn {

	@Test
	void testTurnEndsWhenRollsManyTimesAndAtLeastASingleDieReadsOne() {
		HumanPlayer testHumanPlayer = new HumanPlayer("Alex");
		boolean oneHasBeenRolled;
		testHumanPlayer.setIsMyTurn(true);

		for (int rollCount = 0; rollCount < 100; rollCount++) {
			testHumanPlayer.takeTurn();
			oneHasBeenRolled = testHumanPlayer.getDicePair().getDie1Value() == 1
					|| testHumanPlayer.getDicePair().getDie2Value() == 1;
			if (oneHasBeenRolled && testHumanPlayer.getIsMyTurn()) {
				fail("Should not still be the players turn after rolling a one");
			}
		}
	}

	@Test
	void testTurnTotalIsResetWhenRollsManyTimes() {
		HumanPlayer testHumanPlayer = new HumanPlayer("Alex");
		boolean oneHasBeenRolled;
		testHumanPlayer.setIsMyTurn(true);

		for (int rollCount = 0; rollCount < 100; rollCount++) {
			testHumanPlayer.takeTurn();
			oneHasBeenRolled = testHumanPlayer.getDicePair().getDie1Value() == 1
					|| testHumanPlayer.getDicePair().getDie2Value() == 1;
			if (oneHasBeenRolled && testHumanPlayer.getTurnTotal() > 0) {
				fail("Score Should have been erased when rolling a One");
			}
		}
	}

	@Test
	void testTurnTotalIsSumOfDiceWhenOneHasntBeenRolled() {
		HumanPlayer testHumanPlayer = new HumanPlayer("Alex");
		boolean oneHasBeenRolled;
		int die1Value;
		int die2Value;
		int turnTotal;

		testHumanPlayer.setIsMyTurn(true);

		for (int rollCount = 0; rollCount < 100; rollCount++) {
			testHumanPlayer.takeTurn();
			oneHasBeenRolled = testHumanPlayer.getDicePair().getDie1Value() == 1
					|| testHumanPlayer.getDicePair().getDie2Value() == 1;

			turnTotal = testHumanPlayer.getTurnTotal();
			die1Value = testHumanPlayer.getDicePair().getDie1Value();
			die2Value = testHumanPlayer.getDicePair().getDie1Value();

			if (!oneHasBeenRolled && (turnTotal != (die1Value + die2Value))) {
				fail("The dice were not added to the turnTotal correctly ");
			}
			testHumanPlayer.setTotal(0);
			testHumanPlayer.setTurnTotal(0);
		}
	}

	@Test
	void testGameTotalRemainsAfterDieEqualsOne() {
		HumanPlayer testHumanPlayer = new HumanPlayer("Alex");
		boolean oneHasBeenRolled;
		testHumanPlayer.setTotal(50);
		testHumanPlayer.setIsMyTurn(true);

		for (int rollCount = 0; rollCount < 100; rollCount++) {
			testHumanPlayer.takeTurn();
			oneHasBeenRolled = testHumanPlayer.getDicePair().getDie1Value() == 1
					|| testHumanPlayer.getDicePair().getDie2Value() == 1;

			if (oneHasBeenRolled && (testHumanPlayer.getTotal() != 50)) {
				fail("The total score should Not have been erased");
			}
		}
	}
}
