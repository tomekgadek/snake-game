package snake;

import java.awt.EventQueue;

import snake.controller.GameController;
import snake.model.Apple;
import snake.model.Snake;
import snake.view.Board;
import snake.view.ViewGame;

public class Main {
	
	private static final String title = "Snake";

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            final Apple apple = new Apple();
            final Snake snake = new Snake();

            final ViewGame view = new ViewGame(apple, snake);
            final Board board = new Board(title, view);

            final GameController controller = new GameController(board);

            controller.control();
        });
    }
}