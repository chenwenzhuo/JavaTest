package bouncingBall;

import javax.swing.*;
import java.awt.*;
public class BallComponent extends JComponent{
    private final int START_X = 0;
    private final int START_Y = 20;
    private int currentX;
    private int currentY;
    private int frameWidth;
    private int frameHeight;
    private int parabolaSpan;
    private Color color;

    public BallComponent(int frameWidth, int frameHeight, Color color) {
        this.currentX = START_X;
        this.currentY = START_Y;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.parabolaSpan = calculateSpan();
        this.color = color;
    }

    public void paintComponent(Graphics g) {
        g.drawOval(currentX, currentY, 10, 10);
        g.setColor(color);
    }

    private void changePosition() {
        currentX++;
        currentY = currentX * currentX * 2;
    }

    private int calculateSpan(){
        return (int)(2 * Math.sqrt((frameHeight - START_Y) / 2));
    }
}