import java.awt.*;

public class GravityBall extends Ball {

    private double xAcceleration;
    private double yAcceleration;

    //Getters and Setters

    public double getXAcceleration() {
        return this.xAcceleration;
    }

    public void setXAcceleration(double xAcceleration) {
        this.xAcceleration = xAcceleration;
    }

    public double getYAcceleration() {
        return this.yAcceleration;
    }

    public void setYAcceleration(double yAcceleration) {
        this.yAcceleration = yAcceleration;
    }

    public GravityBall(int x, int y, int diameter, Color color) {

        super(x, y, diameter, color);
        xAcceleration = 0.0;
        yAcceleration = 0.0;
    }


    public void setInitialVelocity(int speed, int angle) {

        setXSpeed(speed*Math.cos(Math.toRadians(angle)));
        setYSpeed(speed*Math.sin(Math.toRadians(angle)));
    }

    public void launch(int rightEdge, int bottomEdge, double deltaTime) {

        double x = getX();
        double xSpeed = getXSpeed();
        double radius = getRadius();
        double y = getY();
        double ySpeed = getYSpeed();

        xSpeed = xSpeed + xAcceleration * deltaTime;
        ySpeed = ySpeed + yAcceleration * deltaTime;

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
