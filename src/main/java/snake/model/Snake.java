package snake.model;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Snake {
    private final int ALL_DOTS = 900;
    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];
    private final Image bodyImg;
    private final Image headImg;
    private int dots;

    private final List<SnakePoint> snakeBody = new ArrayList<>();

    private SnakePoint snakeHead = SnakePoint.init(50, 50);

    private final static int DOT_SIZE = 10;

    public enum Direction { LEFT, RIGHT, UP, DOWN }

    public Snake() {
        ImageIcon iid = new ImageIcon(Objects.requireNonNull(getClass().getResource("/files/dot.png")));
        bodyImg = iid.getImage();

        ImageIcon iih = new ImageIcon(Objects.requireNonNull(getClass().getResource("/files/head.png")));
        headImg = iih.getImage();

        this.initLocation();
    }

    private void initLocation() {
        //this.dots = 3;

        snakeBody.add(SnakePoint.init(40, 50));
        snakeBody.add(SnakePoint.init(30, 50));
    }

    public void expand() {
        snakeBody.add(SnakePoint.init(snakeBody.get(snakeBody.size()-1).x(), snakeBody.get(snakeBody.size()-1).y()));
    }

    public int bodySize() {
        return snakeBody.size();
    }

    public int size() {
        return bodySize() + 1;
    }

    public Image headImg() {
        return this.headImg;
    }

    public Image bodyImg() {
        return this.bodyImg;
    }

    public void move(final Direction direction) {

        /*for (int z = size(); z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }*/
        Collections.rotate(snakeBody, 1);
        snakeBody.set(0, SnakePoint.init(snakeHead.x(), snakeHead.y()));

        if (direction == Direction.LEFT) {
            //x[0] -= DOT_SIZE;
            updateHeadPosition(head().x() - DOT_SIZE, head().y());
        } else if (direction == Direction.RIGHT) {
            updateHeadPosition(head().x() + DOT_SIZE, head().y());
            //x[0] += DOT_SIZE;
        } else if (direction == Direction.UP) {
            updateHeadPosition(head().x(), head().y() - DOT_SIZE);
            //y[0] -= DOT_SIZE;
        } else if (direction == Direction.DOWN) {
            updateHeadPosition(head().x(), head().y() + DOT_SIZE);
            //y[0] += DOT_SIZE;
        }
    }

    public SnakePoint head() {

        return snakeHead;
    }

    public void updateHeadPosition(int x, int y) {

        snakeHead = SnakePoint.init(x, y);
    }

    public List<SnakePoint> body() {
        return snakeBody;
    }
}
