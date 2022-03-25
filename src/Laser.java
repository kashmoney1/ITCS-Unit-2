import java.awt.Color;
import java.awt.Graphics;

public class Laser extends Ball {

    //Variable declaration
    private double x;
    private double y;
    private double diameter;
    private double radius;
    private double xSpeed;
    private double ySpeed;
    private int hits = 0;
    boolean collided = false;

    //Default constructor
    public Laser() {
        x = 0;
        y = 0;
        diameter = 25;
        xSpeed = 0;
        ySpeed = 0;
        radius = diameter/2.0;
    }

    //Constructor (x, y, diameter)
    public Laser(double x, double y, double diameter) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        xSpeed = 0;
        ySpeed = 0;
        radius = diameter/2.0;
    }

    //Distance from object
    public double findDistanceFrom(double x, double y) {
        double a = Math.abs(x - getX());
        double b = Math.abs(y - getY());
        return Math.sqrt((Math.pow(a, 2) + (Math.pow(b, 2))));
    }

    //Intersects with method
    public boolean intersectsWith (Ball otherBall) {
        boolean intersect = findDistanceFrom(otherBall.getX(), otherBall.getY()) <= (getRadius() + otherBall.getRadius());
        if (intersect) {
            hits ++;
            collided = !collided;
        }
        return intersect;
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
    public void drawLaser(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect((int) x, (int) y, 15, 30);
    }

    //Set laser location
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
