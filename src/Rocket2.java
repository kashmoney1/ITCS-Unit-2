//Akash Patel		ITCS

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class Rocket2 {

    private double x;
    private double y;
    private final double width;
    private final double height;
    private double ySpeed;

    public Rocket2(int xPos, int yPos, int speed, int width, int height) {
        x = xPos;
        y = yPos;
        this.height = height;
        this.width = width;
        ySpeed = speed;
    }

    public double getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(int speed) {
        ySpeed = speed;
    }

    public double getX() {
        return x;
    }

    public void setX(int xPos) {
        x = xPos;
    }

    public double getY() {
        return y;
    }

    public void setY(double yPos) {
        y = yPos;
    }

    public void drawRocket(Graphics g) {

        int x = (int) this.x;
        int y = (int) this.y;
        int width = (int) this.width;
        int height = (int) this.height;
        int ySpeed = (int) this.ySpeed;

        //Rocket's Main Body
        g.setColor(Color.WHITE);
        g.fillRoundRect(x - width/2, y + (height - 250), width, height - 20, 50, 30);

        //Payload (Top Area)
        g.setColor(Color.WHITE);
        g.fillOval(x - width/2 - 6, y + (height - 275), width + 12, height - 200);

        //Bottom Area
        g.setColor(Color.BLACK);
        g.fillRect(x - width/2, y + (height - 20), width, height - 250);

        //Flames
        g.setColor(new Color(255, 0, 0));
        int xPoints [] = {x - width/2, x - width/2 + 30, x - width/2 + 15};
        int yPoints [] = {y + (height + 30), y + (height + 30), y + (height + (int) (Math.random() * 150 + 100))};
        g.fillPolygon(xPoints, yPoints, 3);
        //Secondary Color Flame
        g.setColor(new Color(255, 154, 0));
        int y2Points [] = {y + (height + 30), y + (height + 30), y + (height + (int) (Math.random() * 125 + 75))};
        g.fillPolygon(xPoints, y2Points, 3);

        //Text and Flag
        g.setColor(Color.BLACK);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        g.drawString("F9", x - width/2 + 6, y + 100);

    }

    public void move() {

        y -= ySpeed;

        if (y + height + 50 == 0) {
            y = 700;
        }
    }
}

