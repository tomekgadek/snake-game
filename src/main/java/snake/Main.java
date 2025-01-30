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

/*
	Zastanowic sie nad implemetacja FPS

	import javax.swing.*;
import java.awt.*;

public class Game extends JPanel implements Runnable {

    private final int FPS = 60; // Docelowe FPS
    private final int DELAY = 1000 / FPS; // Opóźnienie w milisekundach (16,67 ms)
    private Thread gameThread; // Wątek gry
    private boolean running = true; // Flaga dla pętli gry

    public Game() {
        setPreferredSize(new Dimension(800, 600)); // Rozmiar okna
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime(); // Czas rozpoczęcia
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            long elapsed = now - lastTime; // Czas między klatkami
            lastTime = now;

            update(); // Aktualizacja logiki gry
            repaint(); // Rysowanie grafiki

            // Oblicz pozostały czas i wstrzymaj wątek
            long sleepTime = DELAY - (System.nanoTime() - now) / 1_000_000;
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            frames++;

            // Wyświetl FPS co sekundę
            if (System.currentTimeMillis() - timer > 1000) {
                System.out.println("FPS: " + frames);
                frames = 0;
                timer += 1000;
            }
        }
    }

    private void update() {
        // Logika gry, np. ruch węża
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Rysowanie gry
        g.drawString("Hello, Snake!", 50, 50);
    }

    public synchronized void startGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public synchronized void stopGame() {
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        Game game = new Game();

        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        game.startGame();
    }
}


 */