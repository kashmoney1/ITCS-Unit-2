import java.awt.Color;
import java.awt.Graphics;

public class SantaHat {

    private final int x;
    private final int y;

    public SantaHat(int xPos, int yPos) {

        x = xPos;
        y = yPos;
    }

    public void drawSantaHat(Graphics g) {

        //White base of hat
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 100, 35);

        //Triangle of Hat
        g.setColor(Color.RED);
        int[] xPoints = {x, x + 50, x + 100};
        int[] yPoints = {y, y - 100, y};
        g.fillPolygon(xPoints, yPoints, 3);

        //Tip of Hat
        g.setColor(Color.WHITE);
        g.fillOval(x + 40, y - 110, 20, 20);
    }
}
