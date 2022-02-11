//Akash Patel		ITCS

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Liftoff extends JPanel {

	// TODO: set the initial width and height of your image
	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;

	// required global variables
	private BufferedImage image;
	private Graphics g;
	private Timer timer;
	private Rocket rocket;

	// Constructor required by BufferedImage
	public Liftoff() {
		// set up Buffered Image and Graphics objects
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();

		rocket = new Rocket(300, 400, 2, 75, 300);


		/*
		 * TODO: Code to setup the objects you will animate goes here
		 * All objects declared above should be initialized here
		 * ex. cloud = new Cloud(100, 100, 250, 70, Color.WHITE);
		 * cloud.setXSpeed(2);
		 */

		// set up and start the Timer
		timer = new Timer(10, new TimerListener());
		timer.start();

	}

	// TimerListener class that is called repeatedly by the timer
	private class TimerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			g.setColor(Color.BLUE);
			g.fillRect(0, 0, 600, 600);
			rocket.drawRocket(g);
			rocket.move();
			

			repaint(); // leave this alone, it MUST be the last thing in this method
		}

	}

	// do not modify this
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}

	// main method with standard graphics code
	public static void main(String[] args) {
		JFrame frame = new JFrame("Animation Shell");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Liftoff()); // TODO: Change this to the name of your class!
		frame.setVisible(true);
	}

}
