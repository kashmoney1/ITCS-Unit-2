import java.awt.Color;
import java.awt.Graphics;

public class Snowflake {

    private final Color color;

    public Snowflake(Color c) {
        color = c;
    }

    public void drawSnowflake(Graphics g) {

        int x = (int)(Math.random() * 1001);
        int y = (int)(Math.random() * 801);

        g.setColor(color);

        g.fillOval(x, y, 20, 20);
        g.fillRect(x, y-15, 5, 30);
        g.fillRect(x-5, y, 30, 5);
    }
}
