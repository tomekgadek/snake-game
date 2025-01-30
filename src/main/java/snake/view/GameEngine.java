package snake.view;

import snake.model.Apple;
import snake.model.Keyboard;
import snake.model.Snake;
import snake.model.SnakePoint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameEngine extends JPanel implements ActionListener {

	private final int BOARD_WIDTH = 600;
	private final int BOARD_HEIGHT = 600;
	private final static int DELAY = 80;

	private boolean inGame = true;
	private Timer timer;
	
	private final Apple apple;
	private final Snake snake;

	private final Keyboard keyboard;

	public GameEngine(final Apple apple, final Snake snake, final Keyboard keyboard) {

		this.apple = apple;
		this.snake = snake;
		this.keyboard = keyboard;
		
		addKeyListener(keyboard);
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

		renderGame(g);
	}

	private void renderGame(Graphics g) {

		if (inGame) {

			g.drawImage(apple.appleImg(), apple.x(), apple.y(), this);

			g.drawImage(snake.headImg(), snake.head().x(), snake.head().y(), this);

			for(SnakePoint body: snake.body()) {

				g.drawImage(snake.bodyImg(), body.x(), body.y(), this);
			}

			Toolkit.getDefaultToolkit().sync();

		} else {
			endGame(g);
		}
	}

	private void endGame(Graphics g) {

		String msg = "Game Over";
		Font small = new Font("Helvetica", Font.BOLD, 14);
		FontMetrics metr = getFontMetrics(small);

		g.setColor(Color.white);
		g.setFont(small);
		g.drawString(msg, (BOARD_WIDTH - metr.stringWidth(msg)) / 2, BOARD_HEIGHT / 2);
	}

	private void checkApple() {

		if ((snake.head().x() == apple.x()) && (snake.head().y() == apple.y())) {

			snake.expand();
			apple.randomLocation();
		}
	}

	private void checkCollision() {

		// czy kolizja z cialem
		for(SnakePoint body: snake.body()) {
			if(snake.size() > 4 && snake.head().x() == body.x() && snake.head().y() == body.y()) {
				inGame = false;
				break;
			}
		}

		// czy kolizja ze sciana
		if (snake.head().y() >= BOARD_HEIGHT) {
			inGame = false;
		}

		if (snake.head().y() < 0) {
			inGame = false;
		}

		if (snake.head().x() >= BOARD_WIDTH) {
			inGame = false;
		}

		if (snake.head().x() < 0) {
			inGame = false;
		}

		// czy koniec
		if (!inGame) {
			timer.stop();
		}
	}

	public void actionPerformed(ActionEvent e) {

		if (inGame) {
			checkApple();
			checkCollision();

			if(keyboard.isLeftDirection()) {
				snake.move(Snake.Direction.LEFT);
			}

			if(keyboard.isRightDirection()) {
				snake.move(Snake.Direction.RIGHT);
			}

			if(keyboard.isDownDirection()) {
				snake.move(Snake.Direction.DOWN);
			}

			if(keyboard.isUpDirection()) {
				snake.move(Snake.Direction.UP);
			}
		}

		repaint();
	}
}
