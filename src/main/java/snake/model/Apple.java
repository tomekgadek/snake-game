package snake.model;

import java.awt.*;
import java.util.Objects;
import java.util.Random;

import javax.swing.ImageIcon;

public class Apple {
	private int x;
	private int y;
	private final Image apple;
	private final static int RAND_HORIZONTAL_POS = 40;
	private final static int RAND_VERTICAL_POS = 30;
	private final static int DOT_SIZE = 20;

	private final Random randomPosition;
	
	public Apple() {
		final ImageIcon appleImg = new ImageIcon(Objects.requireNonNull(getClass().getResource("/files/apple.png")));
		this.randomPosition = new Random();

		this.apple = appleImg.getImage();
		this.x = 0;
		this.y = 0;
	}
	
	public void randomLocation() {
		int randomHorizontalLocation = randomPosition.nextInt(RAND_HORIZONTAL_POS);
		this.x = randomHorizontalLocation * DOT_SIZE;

		int randomVerticalLocation = randomPosition.nextInt(RAND_VERTICAL_POS);
		this.y = randomVerticalLocation * DOT_SIZE;
	}

	public int x() {
		return this.x;
	}
	
	public int y() {
		return this.y;
	}
	
	public Image appleImg() {
		return this.apple;
	}
}
