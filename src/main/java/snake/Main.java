package snake;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;

import snake.controller.GameController;
import snake.model.Apple;
import snake.model.Keyboard;
import snake.model.Snake;
import snake.view.Board;
import snake.view.GameEngine;

// TODO: Dodac ladne tlo
// TODO: Poprawic grafike
// Menu: Tytul, Nowa gra, rekordy, wyjscie

public class Main {
	
	private static final String title = "Snake";

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            final Apple apple = new Apple();
            final Snake snake = new Snake();
            final Keyboard keyboard = new Keyboard();

            final GameEngine view = new GameEngine(apple, snake, keyboard);

            final Board board = new Board(title, view);

            final GameController controller = new GameController(board);

            controller.control();
        });
    }
}