package snake.controller;

import snake.view.GameWindow;

public class GameController {

	private final GameWindow gameWindow;

	public GameController(final GameWindow gameWindow) {
		this.gameWindow = gameWindow;
	}
	
	public void control() {
		showBoard();
	}
	
	private void showBoard() {
		gameWindow.setVisible(true);
	}
}
