package edu.westga.cs6910.pig.view;

import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * Defines a GUI for the Pig game. This class was started by CS6910
 * 
 * @author Alex Kernan
 * @version 6/8/2021
 */
public class PigPane extends BorderPane {
	private Game theGame;
	private BorderPane pnContent;
	private HumanPane pnHumanPlayer;
	private ComputerPane pnComputerPlayer;
	private StatusPane pnGameInfo;
	private Pane pnChooseFirstPlayer;

	/**
	 * Creates a pane object to provide the view for the specified Game model
	 * object.
	 * 
	 * @param theGame the domain model object representing the Pig game
	 * 
	 * @requires theGame != null
	 * @ensures the pane is displayed properly
	 */
	public PigPane(Game theGame) {
		this.theGame = theGame;

		this.pnContent = new BorderPane();

		this.addFirstPlayerChooserPane(theGame);
		this.humanPlayerPane(theGame);
		this.statusPane(theGame);
		this.computerPlayerPane(theGame);
		this.windowMenu();
		this.setCenter(this.pnContent);
	}

	private void windowMenu() {
		MenuBar windowMenu = new MenuBar();
		Menu gameMenu = this.createGameMenu();
		Menu computerStrategyMenu = this.createComputerStrategyMenu();
		windowMenu.getMenus().addAll(gameMenu, computerStrategyMenu);
		this.setTop(windowMenu);
	}

	private Menu createGameMenu() {
		Menu gameMenu = new Menu("_Game");
		gameMenu.setMnemonicParsing(true);
		gameMenu.setAccelerator(KeyCombination.valueOf("Ctrl+G"));

		MenuItem exitGame = new MenuItem("E_xit");
		exitGame.setMnemonicParsing(true);
		exitGame.setAccelerator(KeyCombination.valueOf("Ctrl+X"));
		exitGame.setOnAction(actionEvent -> System.exit(0));
		gameMenu.getItems().add(exitGame);
		return gameMenu;
	}

	private Menu createComputerStrategyMenu() {
		Menu computerStrategy = new Menu("_Strategy");
		computerStrategy.setMnemonicParsing(true);
		computerStrategy.setAccelerator(KeyCombination.valueOf("Ctrl+S"));

		MenuItem cautiousStrategy = new MenuItem("_Cautious");
		cautiousStrategy.setMnemonicParsing(true);
		cautiousStrategy.setAccelerator(KeyCombination.valueOf("Ctrl+C"));

		MenuItem greedyStrategy = new MenuItem("Gr_eedy");
		greedyStrategy.setMnemonicParsing(true);
		greedyStrategy.setAccelerator(KeyCombination.valueOf("Ctrl+E"));

		MenuItem randomStrategy = new MenuItem("_Random");
		randomStrategy.setMnemonicParsing(true);
		randomStrategy.setAccelerator(KeyCombination.valueOf("Ctrl+R"));

		computerStrategy.getItems().addAll(cautiousStrategy, randomStrategy, greedyStrategy);
		return computerStrategy;
	}

	private void addFirstPlayerChooserPane(Game theGame) {
		HBox topBox = new HBox();
		topBox.getStyleClass().add("pane-border");
		this.pnChooseFirstPlayer = new NewGamePane(theGame);
		topBox.getChildren().add(this.pnChooseFirstPlayer);
		this.pnContent.setTop(topBox);
	}

	private void humanPlayerPane(Game theGame) {
		HBox humanPlayerBox = new HBox();
		humanPlayerBox.getStyleClass().add("pane-border");
		this.pnHumanPlayer = new HumanPane(theGame);
		humanPlayerBox.getChildren().add(this.pnHumanPlayer);
		this.pnHumanPlayer.setDisable(true);
		this.pnContent.setLeft(humanPlayerBox);

	}

	private void statusPane(Game theGame) {
		HBox statusBox = new HBox();
		statusBox.getStyleClass().add("pane-border");
		this.pnGameInfo = new StatusPane(theGame);
		statusBox.getChildren().add(this.pnGameInfo);
		this.pnContent.setCenter(statusBox);
	}

	private void computerPlayerPane(Game theGame) {
		HBox computerPlayerBox = new HBox();
		computerPlayerBox.getStyleClass().add("pane-border");
		this.pnComputerPlayer = new ComputerPane(theGame);
		computerPlayerBox.getChildren().add(this.pnComputerPlayer);
		this.pnComputerPlayer.setDisable(true);
		this.pnContent.setRight(computerPlayerBox);
	}

	/**
	 * Defines the panel in which the user selects which Player plays first.
	 */
	private final class NewGamePane extends GridPane {
		private RadioButton radHumanPlayer;
		private RadioButton radComputerPlayer;

		private Game theGame;
		private Player theHuman;
		private Player theComputer;

		private NewGamePane(Game theGame) {
			this.theGame = theGame;

			this.theHuman = this.theGame.getHumanPlayer();
			this.theComputer = this.theGame.getComputerPlayer();

			this.buildPane();
		}

		private void buildPane() {
			this.setHgap(20);

			this.radHumanPlayer = new RadioButton(this.theHuman.getName() + " first");
			this.radHumanPlayer.setOnAction(new HumanFirstListener());

			this.radComputerPlayer = new RadioButton(this.theComputer.getName() + " first");
			this.radComputerPlayer.setOnAction(new ComputerFirstListener());

			final ToggleGroup firstMoveToggleGroup = new ToggleGroup();
			this.radHumanPlayer.setToggleGroup(firstMoveToggleGroup);
			this.radComputerPlayer.setToggleGroup(firstMoveToggleGroup);

			this.add(this.radHumanPlayer, 1, 0);
			this.add(this.radComputerPlayer, 2, 0);

		}

		/**
		 * Defines the listener for computer player first button.
		 */
		private class ComputerFirstListener implements EventHandler<ActionEvent> {
			@Override
			/**
			 * Enables the ComputerPlayerPanel and starts a new game. Event handler for a
			 * click in the computerPlayerButton.
			 */
			public void handle(ActionEvent arg0) {
				PigPane.this.pnComputerPlayer.setDisable(false);
				PigPane.this.pnChooseFirstPlayer.setDisable(true);
				PigPane.this.theGame.startNewGame(NewGamePane.this.theComputer);
			}
		}

		/**
		 * Defines the listener for human player first button.
		 */
		private class HumanFirstListener implements EventHandler<ActionEvent> {
			/**
			 * Sets up user interface and starts a new game. Event handler for a click in
			 * the human player button.
			 */
			@Override
			public void handle(ActionEvent event) {
				PigPane.this.pnChooseFirstPlayer.setDisable(true);
				PigPane.this.pnHumanPlayer.setDisable(false);
				PigPane.this.pnChooseFirstPlayer.setDisable(true);
				PigPane.this.theGame.startNewGame(NewGamePane.this.theHuman);

			}
		}
	}
}
