package snake;

import java.awt.EventQueue;

import snake.controllers.GameController;
import snake.models.Apple;
import snake.views.Board;
import snake.views.ViewGame;

public class Main {
	
	private static final String gameName = "Snake";

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            final Apple apple = new Apple();
            final ViewGame view = new ViewGame(apple);
            final Board board = new Board(gameName, view);
            final GameController controller = new GameController(board);
            controller.control();
        });
    }
}