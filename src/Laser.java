import java.awt.Color;
import java.awt.Graphics;

public class Laser {

    private double x;
    private double y;
    private double diameter;
    private double radius;
    private double xSpeed;
    private double ySpeed;

    public Laser() {

        x = 0;
        y = 0;
        diameter = 25;
        xSpeed = 0;
        ySpeed = 0;
        radius = diameter/2.0;
    }

    public Laser(double x, double y, double diameter) {

        this.x = x;
        this.y = y;
        this.diameter = diameter;
        xSpeed = 0;
        ySpeed = 0;
        radius = diameter/2.0;
    }
}
