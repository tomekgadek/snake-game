package main;

import java.awt.EventQueue;

import models.Apple;

import controllers.GameController;
import views.Board;
import views.ViewGame;

public class Main {
	
	private static final String gameName = "Snake";

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {

            public void run() {
            	final Apple apple = new Apple();	// model
                final ViewGame view = new ViewGame(apple);	// view
                final Board board = new Board(gameName, view);	// view
                final GameController controller = new GameController(board);	// controller
                controller.control();
            }
        });
    }
}