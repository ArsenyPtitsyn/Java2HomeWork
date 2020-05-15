package Lesson1;

import java.awt.*;

public class Background extends Color {

    public static final int initRed = 255;
    public static final int initGreen = 255;
    public static final int initBlue = 255;

    private int r;
    private int g;
    private int b;
    private Color bg;

    private float cyclicFrequencyRed = (float) (0.2f + (Math.random() * 0.5f));
    private float cyclicFrequencyGreen = (float) (0.2f + (Math.random() * 0.5f));
    private float cyclicFrequencyBlue = (float) (0.2f + (Math.random() * 0.5f));

    private float phaseRed;
    private float phaseGreen;
    private float phaseBlue;

    public Background(int r, int g, int b) {
        super(r, g, b);
    }

    public void updateBackground(float deltaTime) {
        float currentTime = System.nanoTime() * 0.000000001f;
        phaseRed = cyclicFrequencyRed * currentTime;
        phaseGreen = cyclicFrequencyGreen * currentTime;
        phaseBlue = cyclicFrequencyBlue * currentTime;

        r = initRed * (int) (Math.cos(phaseRed) * Math.cos(phaseRed));
        g = initGreen * (int) (Math.cos(phaseGreen) * Math.cos(phaseGreen));
        b = initBlue * (int) (Math.cos(phaseBlue) * Math.cos(phaseBlue));
        bg = new Color(r, g, b);
    }

    public void renderBackground(MainCanvas canvas) {
        canvas.setBackground(bg);
    }
}