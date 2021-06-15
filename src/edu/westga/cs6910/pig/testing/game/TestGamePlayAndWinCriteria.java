package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * 
 * This JUnit test ensures various play-styles/ways in which the game could be
 * played always culminate one player or the other winning.
 * 
 * @author Alex Kernan
 * @verison 6/12/2021
 *
 */
class TestGamePlayAndWinCriteria {

	@Test
	void testGameWinCriteriaHumanPlayerRollsEveryTimeUnlessHitAOne() {
		HumanPlayer testHuman = new HumanPlayer("Alex");
		ComputerPlayer testComputer = new ComputerPlayer();
		Game testGame = new Game(testHuman, testComputer);
		testGame.startNewGame(testHuman);
		int numberOfTurnsTaken = 0;
		while (!testGame.isGameOver()) {
			testGame.play();
			numberOfTurnsTaken++;
			if (numberOfTurnsTaken > Game.GOAL_SCORE * 10) {
				fail("Game Never Reached win criteria");
			}
		}
	}

	@Test
	void testGameWinCriteriaHumanPlayerHoldsEveryTime() {
		HumanPlayer testHuman = new HumanPlayer("Alex");
		ComputerPlayer testComputer = new ComputerPlayer();
		Game testGame = new Game(testHuman, testComputer);
		testGame.startNewGame(testHuman);
		int numberOfTurnsTaken = 0;
		while (!testGame.isGameOver()) {

			if (testGame.getCurrentPlayer() == testGame.getHumanPlayer()) {
				testGame.hold();
			} else {
				testGame.play();
			}
			numberOfTurnsTaken++;
			if (numberOfTurnsTaken > Game.GOAL_SCORE * 10) {
				fail("Game Never Reached win criteria");
			}
		}

	}

	@Test
	void testGameWinCriteriaHumanPlayerDecidesToRollFiftyPercentOfTheTime() {
		HumanPlayer testHuman = new HumanPlayer("Alex");
		ComputerPlayer testComputer = new ComputerPlayer();
		Game testGame = new Game(testHuman, testComputer);
		testGame.startNewGame(testComputer);
		int numberOfTurnsTaken = 0;
		double shouldRollThreshHold = .5;
		double randomChanceToRoll;

		while (!testGame.isGameOver()) {
			randomChanceToRoll = Math.random();

			if (testGame.getHumanPlayer().getIsMyTurn() && randomChanceToRoll < shouldRollThreshHold) {
				testGame.hold();
			} else {
				testGame.play();
			}
			numberOfTurnsTaken++;
			if (numberOfTurnsTaken > Game.GOAL_SCORE * 10) {
				fail("Game Never Reached win criteria");
			}
		}
	}

}
