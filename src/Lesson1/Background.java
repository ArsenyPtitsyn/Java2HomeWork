package Lesson1;

import java.awt.*;

public class Background extends Color {

    Color color = new Color((int) (Math.random() * 255),
            (int) (Math.random() * 255),
            (int) (Math.random() * 255));

    public Background(int r, int g, int b) {
        super(r, g, b);
    }

    public void renderBackground(MainCanvas canvas, Graphics g) {
        canvas.setBackground(color);
    }
}