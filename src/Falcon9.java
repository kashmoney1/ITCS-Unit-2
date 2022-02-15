//Akash Patel   ITCS

import java.awt.*;
import javax.swing.*;

public class Falcon9 extends Rocket {

    //Constants
    private double earthMass = 5.98 * (Math.pow(10, 24));
    private double earthRadius = 6.38 * (Math.pow(10, 6));
    private double bigG = 6.67 * (Math.pow(10, -11));
    private double dt = 1;
    private double g = 9.8;
    private double dm;
    private double thrust;

    //Variables
    private double netForce;
    private double rocketMass;
    private double acceleration;
    private double altitude;
    private double time;



    public Falcon9(int xPos, int yPos, int speed, int width, int height) {
        super(xPos, yPos, speed, width, height);
    }
}
