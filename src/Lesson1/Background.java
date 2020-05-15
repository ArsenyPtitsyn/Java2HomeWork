package Lesson1;

import java.awt.*;

public class Background extends Color {

    public static final float initRed = 1f;
    public static final float initGreen = 1f;
    public static final float initBlue = 1f;

    private float r;
    private float g;
    private float b;
    private Color bg;

    private float cyclicFrequencyRed = (float) (0.2f + (Math.random() * 0.5f));
    private float cyclicFrequencyGreen = (float) (0.2f + (Math.random() * 0.5f));
    private float cyclicFrequencyBlue = (float) (0.2f + (Math.random() * 0.5f));

    private float phaseRed;
    private float phaseGreen;
    private float phaseBlue;

    public Background(float r, float g, float b) {
        super(r, g, b);
    }

    public void updateBackground(float deltaTime) {
        phaseRed += cyclicFrequencyRed * deltaTime;
        phaseGreen += cyclicFrequencyGreen * deltaTime;
        phaseBlue += cyclicFrequencyBlue * deltaTime;

        r = initRed * (float) (Math.cos(phaseRed) * Math.cos(phaseRed));
        g = initGreen * (float) (Math.cos(phaseGreen) * Math.cos(phaseGreen));
        b = initBlue * (float) (Math.cos(phaseBlue) * Math.cos(phaseBlue));
        bg = new Color(r, g, b);
    }

    public void renderBackground(MainCanvas canvas) {
        canvas.setBackground(bg);
    }
}