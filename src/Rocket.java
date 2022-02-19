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
		g.fillRoundRect(x - width/2, y + (height - 250), width, height - 60, 50, 30);

		//Payload (Top Area)
		g.setColor(Color.WHITE);
		g.fillRoundRect(x - width/2 - 7, y + height - 275, width + 14, height - 225, 100, 100);

		//Side Boosters
		g.setColor(Color.BLACK);
		g.fillRoundRect(x - width/2 + 20, y + (height - 200), width, height - 100, 50, 30);
		g.fillRoundRect(x - width/2 - 20, y + (height - 200), width, height - 100, 50, 30);

		//int x3Points [] = {x - width/2, x - width, x - width/2};
		//g.fillPolygon(x3Points, y2Points, 3);

		//flame of the rocket
		//g.setColor(Color.RED);
		//int y3Points [] = {y + 400, y + (height - 10), y + (height - 10)};
		//int y4Points [] = {y + 350, y + (height - 10), y + (height - 10)};
		//g.fillPolygon(xPoints, y3Points, 3);
		//g.setColor(Color.ORANGE);
		//g.fillPolygon(xPoints, y4Points, 3);

		//Text
		//g.setColor(Color.BLACK);
		//g.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		//g.drawString("Falcon H", x - 20, y + 150);
	}

	public void move() {

		y -= ySpeed;

		if (y + height + 50 == 0) {
			y = 700;
		}
	}
}
