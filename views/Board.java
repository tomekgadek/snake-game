package views;

import javax.swing.JFrame;

public class Board extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private ViewGame view;

	public Board(final String title, final ViewGame view) {

		this.view = view;
		
		add(this.view);
		setTitle(title);
		setLocation(50, 50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
	}
	
	public JFrame getBoard() {
		return this;
	}
}
