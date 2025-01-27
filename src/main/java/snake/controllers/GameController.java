package snake.controllers;

import snake.views.Board;

public class GameController {

	private final Board board;
	
	public GameController(final Board board) {
		this.board = board;
	}
	
	public void control() {
		showBoard();
	}
	
	private void showBoard() {
		board.setVisible(true);
	}
}
