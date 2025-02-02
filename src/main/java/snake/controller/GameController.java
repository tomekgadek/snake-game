package snake.controller;

import snake.model.Keyboard;
import snake.view.GameWindow;

import javax.swing.*;


public class GameController {

	private final GameWindow gameWindow;

	private final static int DELAY = 120;

	private final Timer gameTimer;
	
	public GameController(final GameWindow gameWindow) {
		this.gameWindow = gameWindow;

		this.gameTimer = new Timer(DELAY, this.gameWindow.gamePanel());
		this.gameTimer.start();
	}
	
	public void control() {
		showBoard();
	}
	
	private void showBoard() {
		gameWindow.setVisible(true);
	}
}
