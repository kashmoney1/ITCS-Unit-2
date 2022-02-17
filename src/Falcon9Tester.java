//Akash Patel

public class Falcon9Tester{

    public static void main(String[] args) {

        Falcon9 rocket = new Falcon9(300, 400, 10, 75, 300, 0.5);
        while (rocket.getTime() < 162) {
            rocket.move(1000);
            System.out.println("Time: " + rocket.getTime() + ", Mass: " + rocket.getRocketMass() + ", Net Force: " + rocket.getNetForce() +
                    ", Acceleration: " + rocket.getAcceleration() + ", Velocity: " + rocket.getVelocity() + ", Altitude: " + rocket.getAltitude());
        }


        // Step 2:
        // Using a while loop, print out your rocket data until time <= burnTime.
        // Use your getters to access your data.  Don't forget to move your rocket in the loop as well!
        // To make the data usable in google sheets, each time step should be printed on a single line, with the data separated by commas
        // time, mass, net Force, y-Acceleration, y-velocity, altitude
        // For example:
        // 0.5,540068.8271604938,1513325.4938271604,2.8020974692868936,1.4010487346434468,0.7005243673217234





    }

}
