package snake.model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter {

    private boolean leftDirection;
    private boolean rightDirection;
    private boolean upDirection;
    private boolean downDirection;

    public Keyboard() {
        this.leftDirection = false;
        this.rightDirection = true;
        this.upDirection = false;
        this.downDirection = false;
    }

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

    public boolean isLeftDirection() {
        return leftDirection;
    }

    public boolean isRightDirection() {
        return rightDirection;
    }

    public boolean isUpDirection() {
        return upDirection;
    }

    public boolean isDownDirection() {
        return downDirection;
    }
}
