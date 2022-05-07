public class FalconHeavy extends Rocket {

    //Constants
    private final double earthMass = 5.98 * (Math.pow(10, 24));
    private final double earthRadius = 6.38 * (Math.pow(10, 6));
    private final double bigG = 6.67 * (Math.pow(10, -11));
    private final double dt;

    //Variables
    private double netForce;
    private double rocketMass;
    private double acceleration;
    private double altitude;
    private double time;
    private double velocity;

    //Constructor
    public FalconHeavy(int xPos, int yPos, int speed, int width, int height, double dt) {
        super(xPos, yPos, speed, width, height);
        this.dt = dt;
        rocketMass = 1420788;

    }

    //Getters and Setters

    public double getNetForce() {
        return netForce;
    }

    public double getRocketMass() {
        return rocketMass;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public double getAltitude() {
        return altitude;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getVelocity() {return velocity;}

    //Move Method
    public void move(int HEIGHT) {

        double dm = 8438.584 * dt;
        rocketMass = rocketMass - dm;
        double thrust = 22820000;
        netForce = thrust - (((bigG)*(rocketMass)*(earthMass))/Math.pow(earthRadius + altitude, 2));
        acceleration = netForce/rocketMass;
        velocity = velocity + acceleration * dt;
        altitude = altitude + velocity * dt;
        setY(getY() - getYSpeed() *dt);
        time += dt;


        setY(HEIGHT * (1 - altitude/ 300000) - 300);
    }
}


