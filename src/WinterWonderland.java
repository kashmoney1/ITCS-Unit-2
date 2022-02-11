import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GradientPaint; 
import java.awt.Graphics2D; 

import javax.swing.JFrame;

public class WinterWonderland extends JPanel {

	public static final int WIDTH = 1000;
	public static final int HEIGHT = 800;

	public void paintComponent(Graphics g) {
		gradientBackground(g);
		ground(g);
		drawText(g);
		moon(g);
		drawAmongUs(g);
		for (int i = 100; i < 475; i+=125) {
			new SantaHat(i, 280, 150, 125).drawSantaHat(g);
		}

		for (int i = 450; i <= 900; i+=150) {
			new SnowyTree(i, i - 25).drawSnowyTree(g);
		}

		Snowflake[] s = new Snowflake[85];
		for (int i = 0; i < s.length; i++) {
			s[i] = new Snowflake(Color.BLUE);
			s[i].drawSnowflake(g);
		}
	}

	public static void gradientBackground(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		GradientPaint blueTogreen = new GradientPaint(0, 0, new Color(0, 0, 153), 0, 500, new Color(14, 192, 103));

		g2D.setPaint(blueTogreen);
		g2D.fillRect(0, 0, WIDTH, HEIGHT);

	}

	public static void ground(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 500, 1000, 300);
		g.setColor(Color.BLACK);
		g.drawLine(0, 500, 1000, 500);
	}

	public static void drawText(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		g.drawString("Merry Sussmas from the Impostor", 600, 200);
	}

	public static void moon(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(850, 50, 100, 100);
		
	}

	public static void main(String[] args) {

		JFrame frame = new JFrame("Among Us");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocation(100, 50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new WinterWonderland());
		frame.setVisible(true);
	}

	public void drawAmongUs(Graphics g) {

		//Creates THE HEAD OF THE IMPOSTOR
		g.setColor(Color.RED);
		g.fillOval(200, 300, 150, 150);
		g.drawOval(200, 300, 150, 150);

		//Creates THE MAIN BODY OF THE IMPOSTOR
		g.setColor(Color.RED);
		g.fillRect(200, 375, 150, 100);

		//Creates THE EYE OF THE IMPOSTOR
		g.setColor(new Color (110, 115, 191));
		g.fillOval(260, 325, 90, 65);
		g.setColor(new Color (0, 213, 255));
		g.fillOval(275, 330, 70, 50);
		g.setColor(Color.WHITE);
		g.fillOval(300, 335, 40, 20);

		//Creates THE LEGS OF THE IMPOSTOR
		g.setColor(Color.RED);
		
		g.fillRoundRect(200, 435, 63, 100, 100, 50);
		g.fillRoundRect(287, 435, 63, 100, 100, 50);

		//Creates THE BACKPACK OF THE IMPOSTOR
		g.fillRoundRect(175, 350, 60, 115, 40, 100);
	}

}
