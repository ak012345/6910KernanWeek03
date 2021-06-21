package edu.westga.cs6910.pig.testing.computerPlayer;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;
import edu.westga.cs6910.pig.model.strategies.PigStrategy;

/**
 * JUnit Tests that ensures a Computer Players turn is taken properly.
 * Conditions verified herein are: 1) Turn ends when rolls a 1 2) TurnTotal is
 * zeroized when rolling a 1 3) when roll !=1, sum of dice are added to turn
 * total. 4) Haman's Game total remains after rolling a 1
 * 
 * @author Alex Kernan
 * @version 6/12/2021
 */
class TestComputerPlayerWhenTakeTurn {

	@Test
	void testTurnEndsWhenRollsManyTimesAndAtLeastASingleDieReadsOne() {
		PigStrategy currentStrategy =  new CautiousStrategy();
		ComputerPlayer testComputerPlayer = new ComputerPlayer(currentStrategy);
		boolean oneHasBeenRolled;
		testComputerPlayer.setIsMyTurn(true);

		for (int rollCount = 0; rollCount < 100; rollCount++) {
			testComputerPlayer.takeTurn();
			oneHasBeenRolled = testComputerPlayer.getDicePair().getDie1Value() == 1
					|| testComputerPlayer.getDicePair().getDie2Value() == 1;
			if (oneHasBeenRolled && testComputerPlayer.getIsMyTurn()) {
				fail("Should not still be the players turn after rolling a one");
			}
		}
	}

	@Test
	void testTurnTotalIsResetWhenRollsManyTimes() {
		PigStrategy currentStrategy =  new CautiousStrategy();
		ComputerPlayer testComputerPlayer = new ComputerPlayer(currentStrategy);
		boolean oneHasBeenRolled;
		testComputerPlayer.setIsMyTurn(true);

		for (int rollCount = 0; rollCount < 100; rollCount++) {
			testComputerPlayer.takeTurn();
			oneHasBeenRolled = testComputerPlayer.getDicePair().getDie1Value() == 1
					|| testComputerPlayer.getDicePair().getDie2Value() == 1;
			if (oneHasBeenRolled && testComputerPlayer.getTurnTotal() > 0) {
				fail("Score Should have been erased when rolling a One");
			}
		}
	}

	@Test
	void testTurnTotalIsSumOfDiceWhenOneHasntBeenRolled() {
		PigStrategy currentStrategy =  new CautiousStrategy();
		ComputerPlayer testComputerPlayer = new ComputerPlayer(currentStrategy);
		boolean oneHasBeenRolled;
		int die1Value;
		int die2Value;
		int turnTotal;

		testComputerPlayer.setIsMyTurn(true);

		for (int rollCount = 0; rollCount < 100; rollCount++) {
			testComputerPlayer.setTotal(0);
			testComputerPlayer.setTurnTotal(0);
			testComputerPlayer.takeTurn();
			oneHasBeenRolled = testComputerPlayer.getDicePair().getDie1Value() == 1
					|| testComputerPlayer.getDicePair().getDie2Value() == 1;

			turnTotal = testComputerPlayer.getTurnTotal();
			die1Value = testComputerPlayer.getDicePair().getDie1Value();
			die2Value = testComputerPlayer.getDicePair().getDie2Value();

			if (!oneHasBeenRolled && (turnTotal != (die1Value + die2Value))) {
				fail("The dice were not added to the turnTotal correctly ");
			}

		}
	}

	@Test
	void testGameTotalRemainsAfterDieEqualsOne() {
		PigStrategy currentStrategy =  new CautiousStrategy();
		ComputerPlayer testComputerPlayer = new ComputerPlayer(currentStrategy);
		boolean oneHasBeenRolled;
		testComputerPlayer.setTotal(50);
		testComputerPlayer.setIsMyTurn(true);

		for (int rollCount = 0; rollCount < 100; rollCount++) {
			testComputerPlayer.takeTurn();
			oneHasBeenRolled = testComputerPlayer.getDicePair().getDie1Value() == 1
					|| testComputerPlayer.getDicePair().getDie2Value() == 1;

			if (oneHasBeenRolled && (testComputerPlayer.getTotal() != 50)) {
				fail("The total score should Not have been erased");
			}
		}
	}

}
