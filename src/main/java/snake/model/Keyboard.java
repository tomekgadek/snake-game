package snake.model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter {

    private boolean leftDirection;
    private boolean rightDirection;
    private boolean upDirection;
    private boolean downDirection;
    private Direction key;

    public Keyboard() {
        this.leftDirection = false;
        this.rightDirection = true;
        this.upDirection = false;
        this.downDirection = false;
        this.key = Direction.RIGHT;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
            leftDirection = true;
            upDirection = false;
            downDirection = false;
            this.key = Direction.LEFT;
        }

        if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
            rightDirection = true;
            upDirection = false;
            downDirection = false;
            this.key = Direction.RIGHT;
        }

        if ((key == KeyEvent.VK_UP) && (!downDirection)) {
            upDirection = true;
            rightDirection = false;
            leftDirection = false;
            this.key = Direction.UP;
        }

        if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
            downDirection = true;
            rightDirection = false;
            leftDirection = false;
            this.key = Direction.DOWN;
        }
    }

    public Direction keySign() {
        return this.key;
    }
}
