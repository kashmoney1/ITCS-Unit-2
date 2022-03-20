public class FalconHeavyTester {

    public static void main(String[] args) {

        FalconHeavy rocket = new FalconHeavy(300, 400, 10, 75, 300, 0.5);
        while (rocket.getTime() < 162) {
            rocket.move(1000);
            System.out.println(rocket.getTime() + "," + rocket.getRocketMass() +
                    "," + rocket.getNetForce() + "," + rocket.getAcceleration() +
                    "," + rocket.getVelocity() + "," + rocket.getAltitude());
        }
    }
}