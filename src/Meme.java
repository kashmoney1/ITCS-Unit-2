//regular graphics imports
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

//new required import statements
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class Meme extends JPanel {

	private static final int WIDTH = 1000;
	private static final int HEIGHT = 800;

	private BufferedImage bufferedImage;

	public Meme() {
		bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics g = bufferedImage.getGraphics();

		//Draw Background
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		ImageIcon image = new ImageIcon("Garfield.png");
		g.drawImage(image.getImage(),WIDTH/4, HEIGHT/4, WIDTH/2, HEIGHT/2, null);
		g.setFont(new Font("comic sans ms", Font.BOLD, 50));
		g.setColor(Color.WHITE);
		g.drawString("When you realize", 290, 175);
		g.drawString("Its Monday Again", 290, 650);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), null);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Mondays Meme");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocation(300, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Meme());
		frame.setVisible(true);


	}

}
