//Akash Patel ITCS

public class Falcon9Tester{

    public static void main(String[] args) {

        Falcon9 rocket = new Falcon9(300, 400, 10, 75, 300, 0.5);
        while (rocket.getTime() < 162) {
            rocket.move(1000);
            System.out.println(rocket.getTime() + "," + rocket.getRocketMass() +
                    "," + rocket.getNetForce() + "," + rocket.getAcceleration() +
                    "," + rocket.getVelocity() + "," + rocket.getAltitude());
        }
    }
}
