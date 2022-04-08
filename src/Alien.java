import java.awt.Color;
import java.awt.Graphics;

public class Alien {

    //Variable declaration
    private int x;
    private int y;
    private int WIDTH;
    private int HEIGHT;
    private int xPos;
    private int yPos;
    // yogesh is amazing
    private int radius = 50;

    public int getXPos() {
        return xPos;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }


    //Constructor (x, y, width, height)
    public Alien(int xPos, int yPos, int WIDTH, int HEIGHT) {
        x = xPos;
        y = yPos;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
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
        int xPoints [] = {x, x + 50, x + 25};
        int yPoints [] = {y, y, y - 20};
        g.fillPolygon(xPoints, yPoints, 3);
        int y2Points [] = {y + 50, y + 50, y + 70};
        g.fillPolygon(xPoints, y2Points, 3);
    }

    //Boss draw method
    public void drawBoss(Graphics g) {

        //Boss body
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 100, 100);

        //Boss eyes and boss mouth
        g.setColor(Color.RED);
        g.fillRect(x, y + 20, 20, 20);
        g.fillRect(x + 80, y + 20, 20, 20);
        g.setColor(Color.BLACK);
        g.fillRect(x + 20, y + 60, 60, 20);

        //BOSS SPIKES
        int xPoints [] = {x, x + 100, x + 50};
        int yPoints [] = {y, y, y - 40};
        g.fillPolygon(xPoints, yPoints, 3);
        int y2Points [] = {y + 100, y + 100, y + 140};
        g.fillPolygon(xPoints, y2Points, 3);

    }

    /**
     * @author Yogesh Thambidurai
     */
    public double findDistanceFrom(double x, double y) {
        double a = Math.abs(x - this.x);
        double b = Math.abs(y - this.y);
        return Math.sqrt((Math.pow(a, 2) + (Math.pow(b, 2))));
    }

    /**
     * @author Yogesh Thambidurai
     */
    public boolean intersectsWith (Laser otherBall) {
        boolean intersect = findDistanceFrom(otherBall.getX(), otherBall.getY()) <= (radius + otherBall.getHeight());
        return intersect;
    }
}
