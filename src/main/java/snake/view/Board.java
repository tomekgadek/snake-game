package snake.view;

import javax.swing.*;

public class Board extends JFrame {

	public Board(final String title, final JPanel view) {

		add(view);
		setTitle(title);
		setLocation(200, 50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		pack();
	}
}
