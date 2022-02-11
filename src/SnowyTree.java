import java.awt.Color;
import java.awt.Graphics;

public class SnowyTree {

    private int x;
    private int basePoint;

    public SnowyTree(int xPos, int basePointPos) {

        x = xPos;
        basePoint = basePointPos;
    }

    public void drawSnowyTree(Graphics g) {

        //Base of Tree
        g.setColor(new Color (117, 75, 34));
        g.fillRect(basePoint, 430, 50, 100);

        //Top of tree
        g.setColor(Color.WHITE);
        int xPoints [] = {x - 50, x, x + 50};
        int yPoints [] = {430, 360, 430};
        g.fillPolygon(xPoints, yPoints, 3);
    }

}
