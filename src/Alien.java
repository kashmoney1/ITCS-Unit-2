import java.awt.Color;
import java.awt.Graphics;

public class Alien {

    //Variable declaration
    private int x;
    private int y;
    private int WIDTH;
    private int HEIGHT;

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
        g.setColor(Color.BLACK);
        g.fillRect(x, y + 10, 10, 10);
        g.fillRect(x + 40, y + 10, 10, 10);
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
        g.setColor(Color.BLACK);
        g.fillRect(x, y + 20, 20, 20);
        g.fillRect(x + 80, y + 20, 20, 20);
        g.fillRect(x + 20, y + 60, 60, 20);

        //BOSS SPIKES
        int xPoints [] = {x, x + 100, x + 50};
        int yPoints [] = {y, y, y - 40};
        g.fillPolygon(xPoints, yPoints, 3);
        int y2Points [] = {y + 100, y + 100, y + 140};
        g.fillPolygon(xPoints, y2Points, 3);

    }
}
