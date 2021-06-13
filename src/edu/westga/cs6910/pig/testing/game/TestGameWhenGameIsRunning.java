package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;

class TestGameWhenGameIsRunning {

	@Test
	void testGameTotalRemainsOnceItIsHumanPlayersTurnAgain() {
		
		
		HumanPlayer testHumanPlayer = new HumanPlayer("Alex");
		ComputerPlayer testComputerPlayer = new ComputerPlayer();
		Game testGame = new Game(testHumanPlayer, null);
		boolean oneHasBeenRolled;
		testHumanPlayer.setTotal(50);
		testHumanPlayer.setIsMyTurn(true);
		int humanGameTotal;

		do {
			testHumanPlayer.takeTurn();
			humanGameTotal = testHumanPlayer.getTotal();
		} while(testHumanPlayer.getIsMyTurn());

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
