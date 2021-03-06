import java.awt.Color;
import java.awt.Graphics;

public class Laser{

    //variables
    private int x;
    private int y;
    private int width;
    private int height;

    public Laser(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //getters and setters
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

    public void move() {
        this.y -= 7;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    //Draw laser
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(this.x, this.y, 15, 45);
    }

}
