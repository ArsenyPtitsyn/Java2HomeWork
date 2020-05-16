package lesson1.teacher.bricks;

import lesson1.teacher.common.GameObject;
import lesson1.teacher.common.MainCanvas;

import java.awt.*;

public class Background implements GameObject {

    @Override
    public void update(MainCanvas canvas, float deltaTime) {

    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {
        canvas.setBackground(Color.BLACK);
    }
}