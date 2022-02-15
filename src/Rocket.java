//Akash Patel		ITCS

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class Rocket {

	private double x;
	private double y;
	private double width;
	private double height;
	private double ySpeed;

	public Rocket(int xPos, int yPos, int speed, int width, int height) {
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

	public void setY(int yPos) {
		y = yPos;
	}

	public void drawRocket(Graphics g) {

		int x = (int) this.x;
		int y = (int) this.y;
		int width = (int) this.width;
		int height = (int) this.height;
		int ySpeed = (int) this.ySpeed;

		//Body of the rocket
		g.setColor(Color.GRAY);
		g.fillRect(x - width/2, y + (height - 250), width, height - 60);

		//Top of the rocket
		g.setColor(Color.BLACK);
		int xPoints [] = {x, x - width/2, x + width/2};
		int yPoints [] = {y, y + (height - 250), y + (height - 250)};
		g.fillPolygon(xPoints, yPoints, 3);

		//Sides of the rocket
		g.setColor(Color.BLACK);
		int x2Points [] = {x + width/2, x + width, x + width/2};
		int y2Points [] = {y + height - 80, y + height - 10, y + height -10};
		g.fillPolygon(x2Points, y2Points, 3);

		int x3Points [] = {x - width/2, x - width, x - width/2};
		g.fillPolygon(x3Points, y2Points, 3);

		//Text
		g.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		g.drawString("Patel 9", x - 20, y + 150);
	}

	public void move() {

		y -= ySpeed;

		if (y + height + 50 == 0) {
			y = 700;
		}
	}
}
