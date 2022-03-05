//Akash Patel   ITCS

import java.awt.*;

public class JumpingBall extends Ball {

    boolean collided = false;

    public JumpingBall (double x, double y, double diameter, Color color) {
        super (x, y, diameter, color);
    }

    public double findDistanceFrom(double x, double y) {
        double a = Math.abs(x - getX());
        double b = Math.abs(y - getY());
        return Math.sqrt((Math.pow(a, 2) + (Math.pow(b, 2))));
    }

    public boolean intersectsWith (Ball otherBall) {
        boolean intersect = findDistanceFrom(otherBall.getX(), otherBall.getY()) <= (getRadius() + otherBall.getRadius());
        if (intersect) {
            collided = !collided;
            if (collided) {
                setColor(Color.RED);
            } else {
                setColor(Color.GREEN);
            }
        }
        return intersect;
    }

    public void move(int rightEdge, int bottomEdge) {
        setX((int) (Math.random() * (rightEdge - getDiameter()) + getRadius()));
        setY((int) (Math.random() * (bottomEdge - getDiameter()) + getRadius()));
    }


}
