import java.awt.Color;
import java.awt.Graphics;

public class Player {

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    //Variable declaration
    private int x;
    private int y;
    private int WIDTH;
    private int HEIGHT;

    //Constructor (x, y, width, height)
    public Player(int xPos, int yPos, int WIDTH, int HEIGHT) {
        x = xPos;
        y = yPos;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
    }

    //Draw method
    public void drawPlayer(Graphics g) {

        //Base rectangle
        g.setColor(Color.BLACK);
        g.fillRect(x, y, 80, 20);

        //Second layer
        g.fillRect(x + 15, y - 20, 50, 20);

        //Cannon
        g.fillRect(x + 32, y - 50, 15, 40);
    }

}
