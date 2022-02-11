import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	//Declaration of Variables
	private double x;
    private double y;
    private double diameter;
    private double radius;
    private Color color;
    private double xSpeed;
    private double ySpeed;

	//Default Constructor
	public Ball() {

        color = Color.RED;
        x = 0;
        y = 0;
        diameter = 25;
        xSpeed = 0;
        ySpeed = 0;
        radius = diameter/2.0;
	}

	//Constructor (x, y, diameter, color)
    public Ball(double x, int y, int diameter, Color color) {

        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.color = color;
        xSpeed = 0;
        ySpeed = 0;
        radius = diameter/2.0;
    }

	//Getters and Setters

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getDiameter() {
        return this.diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
        radius = diameter/2.0;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        diameter = radius*2;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getXSpeed() {
        return this.xSpeed;
    }

    public void setXSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getYSpeed() {
        return this.ySpeed;
    }

    public void setYSpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    //Draw Method
	public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int) (x - radius), (int) (y -  radius), (int) (diameter), (int) (diameter));

	}

    //Set Location of Ball
	public void setLocation(double x, double y) {

		this.x = x;
        this.y = y;
	}

    //Set Random Speed (x and y cannot be the same)
	public void setRandomSpeed(double maxSpeed) {

		xSpeed = (Math.random() * 2 * maxSpeed) - maxSpeed;
        ySpeed = (Math.random() * 2 * maxSpeed) - maxSpeed;

        if (xSpeed == ySpeed) {
            ySpeed = (Math.random() * 2 * maxSpeed) - maxSpeed;
        }
	}

    //Move method (edge detection)
	public void move(int rightEdge, int bottomEdge) {

		x += xSpeed;
        y += ySpeed;

        if (x - radius <= 0) {
            xSpeed *= -1;
            x = 0 + radius;
        }

        if (x + radius >= rightEdge) {
            xSpeed *= -1;
            x = rightEdge - radius;
        }

        if (y - radius <= 0) {
            ySpeed *= -1;
            y = 0 + radius;
        }

        if (y + radius >= bottomEdge) {
            ySpeed *= -1;
            y = bottomEdge - radius;
        }
	}
}