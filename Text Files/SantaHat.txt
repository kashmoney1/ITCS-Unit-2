import java.awt.Color;
import java.awt.Graphics;

public class SantaHat {

    private int x;
    private int y;
    private int width;
    private int height;

    public SantaHat(int xPos, int yPos, int width, int height) {

        x = xPos;
        y = yPos;
        this.width = width;
        this.height = height;
    }

    public void drawSantaHat(Graphics g) {

        //White base of hat
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 100, 35);

        //Triangle of Hat
        g.setColor(Color.RED);
        int xPoints [] = {x, x + 50, x + 100};
        int yPoints [] = {y, y - 100, y};
        g.fillPolygon(xPoints, yPoints, 3);

        //Tip of Hat
        g.setColor(Color.WHITE);
        g.fillOval(x + 40, y - 110, 20, 20);
    }
}
