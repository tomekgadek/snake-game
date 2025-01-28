package snake.model;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Snake {
    private final int ALL_DOTS = 900;
    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];
    private Image body;
    private Image head;
    private int dots;

    public Snake() {
        ImageIcon iid = new ImageIcon(Objects.requireNonNull(getClass().getResource("/files/dot.png")));
        body = iid.getImage();

        ImageIcon iih = new ImageIcon(Objects.requireNonNull(getClass().getResource("/files/head.png")));
        head = iih.getImage();

        this.initLocation();
    }

    private void initLocation() {
        this.dots = 3;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }
    }

    public void expand() {
        this.dots += 1;
    }

    public int size() {
        return this.dots;
    }

    public Image headImg() {
        return this.head;
    }

    public Image bodyImg() {
        return this.body;
    }

    // TODO: metody do zmiany !!!
    public int[] getTabX() {
        return this.x;
    }

    public int[] getTabY() {
        return this.y;
    }
}
