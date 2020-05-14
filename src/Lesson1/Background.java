package Lesson1;

import java.awt.*;

public class Background extends Color {

    public Background(int r, int g, int b) {
        super(r, g, b);
    }

    public void updateBackground(MainCanvas canvas, float deltaTime) {
        
    }

    public void renderBackground(MainCanvas canvas) {
        Color color = new Color((int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255));
        canvas.setBackground(color);
    }
}