//Akash Patel		ITCS

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Liftoff extends JPanel {

	private static final int WIDTH = 1000;
	private static final int HEIGHT = 1000;

	// required global variables
	private BufferedImage image;
	private Graphics g;
	private Timer timer;
	private Rocket rocket;

	public Liftoff() {

		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();

		rocket = new Rocket(300, 400, 2, 30, 300);

		timer = new Timer(10, new TimerListener());
		timer.start();

	}

	private class TimerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			g.setColor(Color.BLUE);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			rocket.drawRocket(g);
			rocket.move();

			repaint();
		}
	}

	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Liftoff");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Liftoff());
		frame.setVisible(true);
	}
}
