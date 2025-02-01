package snake.model;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Snake {
    private final Image bodyImg;
    private final Image headImg;
    private final List<SnakePoint> snakeBody = new ArrayList<>();
    private SnakePoint snakeHead = null;

    private final static int DOT_SIZE = 20;

    public Snake() {
        ImageIcon iid = new ImageIcon(Objects.requireNonNull(getClass().getResource("/files/dot.png")));
        bodyImg = iid.getImage();

        ImageIcon iih = new ImageIcon(Objects.requireNonNull(getClass().getResource("/files/head.png")));
        headImg = iih.getImage();

        this.initSnake();
    }

    private void initSnake() {
        snakeHead = SnakePoint.createSnakeElement(40, 40);

        snakeBody.add(SnakePoint.createSnakeElement(20, 40));
        snakeBody.add(SnakePoint.createSnakeElement(0, 40));
    }

    public void expand() {
        snakeBody.add(SnakePoint.createSnakeElement(snakeBody.get(snakeBody.size()-1).x(), snakeBody.get(snakeBody.size()-1).y()));
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
        Collections.rotate(snakeBody, 1);
        snakeBody.set(0, SnakePoint.createSnakeElement(snakeHead.x(), snakeHead.y()));

        switch (direction) {
            case LEFT -> updateHeadPosition(head().x() - DOT_SIZE, head().y());
            case RIGHT -> updateHeadPosition(head().x() + DOT_SIZE, head().y());
            case UP -> updateHeadPosition(head().x(), head().y() - DOT_SIZE);
            case DOWN -> updateHeadPosition(head().x(), head().y() + DOT_SIZE);
        }
    }

    public SnakePoint head() {
        return snakeHead;
    }

    public void updateHeadPosition(int x, int y) {
        snakeHead = SnakePoint.createSnakeElement(x, y);
    }

    public List<SnakePoint> body() {
        return snakeBody;
    }
}
