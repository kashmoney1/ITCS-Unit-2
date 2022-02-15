//Akash Patel   ITCS

import java.awt.*;
import javax.swing.*;

public class Falcon9 extends Rocket {

    //Constants
    private final double earthMass = 5.98 * (Math.pow(10, 24));
    private final double earthRadius = 6.38 * (Math.pow(10, 6));
    private final double bigG = 6.67 * (Math.pow(10, -11));
    private final double g = 9.8;
    private double dt = 1;
    private double dm = 2462.35;
    private double thrust = 6806000;

    //Variables
    private double netForce;
    private double rocketMass;
    private double acceleration;
    private double altitude;
    private double time;

    //Constructor
    public Falcon9(int xPos, int yPos, int speed, int width, int height, double mass, double dt, double dm,
                   double thrust, double netForce, double acceleration, double time, double altitude) {
        super(xPos, yPos, speed, width, height);
        this.rocketMass = mass;
        this.dt = dt;
        this.dm = dm;
        this.thrust = thrust;
        this.netForce = netForce;
        this.acceleration = acceleration;
        this.time = time;
        this.altitude = altitude;
    }

    //Getters and Setters

    public double getDt() {
        return dt;
    }

    public void setDt(double dt) {
        this.dt = dt;
    }

    public double getDm() {
        return dm;
    }

    public void setDm(double dm) {
        this.dm = dm;
    }

    public double getThrust() {
        return thrust;
    }

    public void setThrust(double thrust) {
        this.thrust = thrust;
    }

    public double getNetForce() {
        return netForce;
    }

    public void setNetForce(double netForce) {
        this.netForce = netForce;
    }

    public double getRocketMass() {
        return rocketMass;
    }

    public void setRocketMass(double rocketMass) {
        this.rocketMass = rocketMass;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    //Move Method
    public void move(int HEIGHT) {

        rocketMass -= dm;
        netForce = thrust - (((bigG)*(rocketMass)*(earthMass))/Math.pow(earthRadius + altitude, 2));
        acceleration = netForce/rocketMass;
        setYSpeed(((int)getYSpeed() +  (int) acceleration));
        setY((int) (getY() - getYSpeed()));

    }



}
