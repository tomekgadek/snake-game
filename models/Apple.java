package models;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Apple {
	private int x;
	private int y;
	private Image apple;
	
	private final int RAND_POS = 29;
	
	private final int DOT_SIZE = 10;
	
	public Apple() {
		final ImageIcon iia = new ImageIcon("snake/files/apple.png");

		this.apple = iia.getImage();
		this.x = 0;
		this.y = 0;
	}
	
	public void randomAppleLocation() {
		int r = (int) (Math.random() * RAND_POS);
		x = ((r * DOT_SIZE));

		r = (int) (Math.random() * RAND_POS);
		y = ((r * DOT_SIZE));
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Image getAppleImage() {
		return apple;
	}
}
