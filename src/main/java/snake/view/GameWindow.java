package snake.view;

import snake.model.Keyboard;

import javax.swing.*;

public class GameWindow extends JFrame {

	private final GamePanel gamePanel;


	public GameWindow(final String title, final GamePanel gamePanel) {

		this.gamePanel = gamePanel;

		add(this.gamePanel);
		setTitle(title);
		setLocation(200, 50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		pack();
	}

	public void addKeyListener(Keyboard keyboard) {
		this.gamePanel.addKeyListener(keyboard);
	}

	public GamePanel gamePanel() {
		return this.gamePanel;
	}
}
