import java.awt.*;

public class GravityBall extends Ball {

    private double xAcceleration;
    private double yAcceleration;

    //Getters and Setters

    public void setXAcceleration(double xAcceleration) {
        this.xAcceleration = xAcceleration;
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

        double radius = getRadius();
        deltaTime /= 1000;

        setXSpeed(getXSpeed() + xAcceleration * deltaTime);
        setYSpeed(getYSpeed() + yAcceleration * deltaTime);

        setX(getX() + getXSpeed());
        setY(getY() + getYSpeed());

        if (getX() - radius <= 0) {
            setXSpeed(getXSpeed() * -1);
            setX(0 + radius);
        }

        if (getX() + radius >= rightEdge) {
            setXSpeed(getXSpeed() * -1);
            setX(rightEdge - radius);
        }

        if (getY() - radius <= 0) {
            setYSpeed(getYSpeed() * -1);
            setY(0 + radius);
        }

        if (getY() + radius >= bottomEdge) {
            setYSpeed(getYSpeed() * -1);
            setY(bottomEdge - radius);
        }
    }




}
