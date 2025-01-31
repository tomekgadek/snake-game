package snake.model;

public class SnakePoint {

    private final int x;
    private final int y;

    public static SnakePoint createSnakeElement(int x, int y) {

        return new SnakePoint(x, y);
    }

    private SnakePoint() {
        this(0, 0);
    }
    private SnakePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
}
