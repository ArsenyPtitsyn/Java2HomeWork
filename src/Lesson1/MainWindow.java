package Lesson1;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private static final int POS_X = 320;
    private static final int POS_Y = 115;
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 450;

    Sprite sprites[] = new Sprite[10];
    Background bg;

    private MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        MainCanvas canvas = new MainCanvas(this);
        initApplication();
        add(canvas);
        setTitle("Circles");
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }

    private void initApplication() {
        for(int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
            bg = new Background(255, 255, 255);
        }
    }

    void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
            bg.updateBackground(canvas, (float) Math.cos(deltaTime));
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
            bg.renderBackground(canvas);
        }
    }

}
