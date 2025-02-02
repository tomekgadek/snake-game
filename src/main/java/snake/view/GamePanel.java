package snake.view;

import snake.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class GamePanel extends JPanel implements ActionListener {

	private final int BOARD_WIDTH = 800;
	private final int BOARD_HEIGHT = 600;

	//private Timer timer;
	private final Apple apple;
	private final Snake snake;
	private final Keyboard keyboard;
	private final Image backgroundImage;

	public GamePanel(final Apple apple, final Snake snake, final Keyboard keyboard) {

		this.apple = apple;
		this.snake = snake;
		this.keyboard = keyboard;

		addKeyListener(keyboard);
		setBackground(Color.black);
		setFocusable(true);

		setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));

		final ImageIcon backgroundImg = new ImageIcon(Objects.requireNonNull(getClass().getResource("/files/background.jpg")));
		backgroundImage = backgroundImg.getImage();

		initGame();
	}

	private void initGame() {

		apple.randomLocation();

		//timer = new Timer(DELAY, this);
		//timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		renderGame(g);
	}

	private void renderGame(Graphics g) {

		if (isCollision()) {
			endGame(g);
			return ;
		}

		loopGame(g);
	}

	private void loopGame(Graphics g) {

		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

		g.drawImage(apple.appleImg(), apple.x(), apple.y(), this);
		g.drawImage(snake.headImg(), snake.head().x(), snake.head().y(), this);

		for(SnakePoint body: snake.body()) {
			g.drawImage(snake.bodyImg(), body.x(), body.y(), this);
		}

		Toolkit.getDefaultToolkit().sync();
	}

	private void endGame(Graphics g) {
		//timer.stop();

		String msg = "Game Over";
		Font small = new Font("Helvetica", Font.BOLD, 14);
		FontMetrics metr = getFontMetrics(small);

		g.setColor(Color.white);
		g.setFont(small);
		g.drawString(msg, (BOARD_WIDTH - metr.stringWidth(msg)) / 2, BOARD_HEIGHT / 2);
		g.drawString(String.format("Score: %d pt.", snake.size()), (BOARD_WIDTH - metr.stringWidth(msg)) / 2, BOARD_HEIGHT / 2 + 14);
	}

	private boolean isAppleEaten() {
		return (snake.head().x() == apple.x()) && (snake.head().y() == apple.y());
	}

	private boolean isCollision() {

		for(SnakePoint body: snake.body()) {
			if(snake.size() > 4 && snake.head().x() == body.x() && snake.head().y() == body.y()) {
				return true;
			}
		}

		if (snake.head().y() >= BOARD_HEIGHT) {
			return true;
		}

		if (snake.head().y() < 0) {
			return true;
		}

		if (snake.head().x() >= BOARD_WIDTH) {
			return true;
		}

		return snake.head().x() < 0;
	}

	public void actionPerformed(ActionEvent e) {

		if (isCollision()) {
			return ;
		}

		if(isAppleEaten()) {
			snake.expand();
			apple.randomLocation();
		}

		snake.move(keyboard.keySign());
		repaint();
	}
}
