import java.awt.Color;
import java.awt.Graphics;

public class Alien {

    //Variable declaration
    private final int x;
    private final int y;


    //Constructor (x, y, width, height)
    public Alien(int xPos, int yPos) {
        x = xPos;
        y = yPos;
    }

    //Draw method
    public void drawAlien(Graphics g) {

        //Body
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 50, 50);

        //Eyes and mouth
        g.setColor(Color.RED);
        g.fillRect(x, y + 10, 10, 10);
        g.fillRect(x + 40, y + 10, 10, 10);
        g.setColor(Color.BLACK);
        g.fillRect(x + 10, y + 30, 30, 10);

        //Spikes
        int[] xPoints = {x, x + 50, x + 25};
        int[] yPoints = {y, y, y - 20};
        g.fillPolygon(xPoints, yPoints, 3);
        int[] y2Points = {y + 50, y + 50, y + 70};
        g.fillPolygon(xPoints, y2Points, 3);
    }

    //find distance from object (alien and laser)
    public double findDistanceFrom(double x, double y) {
        double a = Math.abs(x - this.x);
        double b = Math.abs(y - this.y);
        return Math.sqrt((Math.pow(a, 2) + (Math.pow(b, 2))));
    }

    //intersecting with alien (used for removing aliens when hit)
    public boolean intersectsWith (Laser otherBall) {
        int radius = 50;
        return findDistanceFrom(otherBall.getX(), otherBall.getY()) <= (radius + otherBall.getHeight());
    }
}
