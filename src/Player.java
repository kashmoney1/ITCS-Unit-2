import java.awt.Color;
import java.awt.Graphics;

public class Player {

    private int x;
    private int y;
    private int WIDTH;
    private int HEIGHT;

    public Player(int xPos, int yPos, int WIDTH, int HEIGHT) {
        x = xPos;
        y = yPos;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
    }

    public void drawPlayer(Graphics g) {

        //Base rectangle
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 60, 20);

        //Second layer
        g.fillRect(x, y, 30, 20);

        //Cannon
        g.fillRect(x, y, 20, 40);
    }
}
