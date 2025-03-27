package snake;

import java.awt.EventQueue;

import snake.controller.GameController;
import snake.model.Apple;
import snake.model.Keyboard;
import snake.model.Snake;
import snake.view.GameWindow;
import snake.view.GamePanel;

public class Main {
	
	private static final String title = "Snake";

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            final Apple apple = new Apple();
            final Snake snake = new Snake();
            final Keyboard keyboard = new Keyboard();

            final GamePanel gamePanel = new GamePanel(apple, snake, keyboard);
            final GameWindow gameWindow = new GameWindow(title, gamePanel);

            final GameController controller = new GameController(gameWindow);

            controller.control();
        });
    }
}
