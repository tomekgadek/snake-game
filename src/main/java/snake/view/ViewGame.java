package snake.view;

import snake.model.Apple;
import snake.model.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ViewGame extends JPanel implements ActionListener {

	private final int BOARD_WIDTH = 600;
	private final int BOARD_HEIGHT = 600;
	private final static int DELAY = 80;
	private final static int DOT_SIZE = 10;

	private boolean leftDirection = false;
	private boolean rightDirection = true;
	private boolean upDirection = false;
	private boolean downDirection = false;
	private boolean inGame = true;
	private Timer timer;
	
	private final Apple apple;
	private final Snake snake;

	private final int[] x;
	private final int[] y;

	public ViewGame(final Apple apple, final Snake snake) {

		this.apple = apple;
		this.snake = snake;

		x = snake.getTabX();
		y = snake.getTabY();
		
		addKeyListener(new TAdapter());
		setBackground(Color.black);
		setFocusable(true);

		setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
		initGame();
	}

	private void initGame() {

		apple.randomLocation();

		timer = new Timer(DELAY, this);
		timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		doDrawing(g);
	}

	private void doDrawing(Graphics g) {

		if (inGame) {

			g.drawImage(apple.appleImg(), apple.x(), apple.y(), this);

			for (int z = 0; z < snake.size(); z++) {
				if (z == 0) {
					g.drawImage(snake.headImg(), x[z], y[z], this);
				} else {
					g.drawImage(snake.bodyImg(), x[z], y[z], this);
				}
			}

			Toolkit.getDefaultToolkit().sync();

		} else {
			gameOver(g);
		}
	}

	private void gameOver(Graphics g) {

		String msg = "Game Over";
		Font small = new Font("Helvetica", Font.BOLD, 14);
		FontMetrics metr = getFontMetrics(small);

		g.setColor(Color.white);
		g.setFont(small);
		g.drawString(msg, (BOARD_WIDTH - metr.stringWidth(msg)) / 2, BOARD_HEIGHT / 2);
	}

	private void checkApple() {

		if ((x[0] == apple.x()) && (y[0] == apple.y())) {

			snake.expand();
			apple.randomLocation();
		}
	}

	private void move() {

		for (int z = snake.size(); z > 0; z--) {
			x[z] = x[(z - 1)];
			y[z] = y[(z - 1)];
		}

		if (leftDirection) {
			x[0] -= DOT_SIZE;
		}

		if (rightDirection) {
			x[0] += DOT_SIZE;
		}

		if (upDirection) {
			y[0] -= DOT_SIZE;
		}

		if (downDirection) {
			y[0] += DOT_SIZE;
		}
	}

	private void checkCollision() {

		for (int z = snake.size(); z > 0; z--) {

			if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
				inGame = false;
				break;
			}
		}

		if (y[0] >= BOARD_HEIGHT) {
			inGame = false;
		}

		if (y[0] < 0) {
			inGame = false;
		}

		if (x[0] >= BOARD_WIDTH) {
			inGame = false;
		}

		if (x[0] < 0) {
			inGame = false;
		}

		if (!inGame) {
			timer.stop();
		}
	}

	public void actionPerformed(ActionEvent e) {

		if (inGame) {
			checkApple();
			checkCollision();
			move();
		}

		repaint();
	}

	private class TAdapter extends KeyAdapter {

		public void keyPressed(KeyEvent e) {

			int key = e.getKeyCode();

			if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
				leftDirection = true;
				upDirection = false;
				downDirection = false;
			}

			if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
				rightDirection = true;
				upDirection = false;
				downDirection = false;
			}

			if ((key == KeyEvent.VK_UP) && (!downDirection)) {
				upDirection = true;
				rightDirection = false;
				leftDirection = false;
			}

			if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
				downDirection = true;
				rightDirection = false;
				leftDirection = false;
			}
		}
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