import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HelloGraphics extends JPanel {
		
	//this method "paints" things onto the panel 
	public void paintComponent (Graphics g)	{
		//start by setting the pen color
		//Draws a red circle
		g.setColor(Color.RED);
		g.fillOval(100, 100, 150, 150);
		paramString();
		//Draw a square of a unique color
		g.setColor(new Color(56, 47, 174)); 
		g.fillRect(700, 200, 100, 100);
		
		//Draw a vertical line across the page
		g.setColor(Color.GREEN);
		g.drawLine(500, 800, 500, 0);
		
		//Draw a horizontal line across the page
		g.setColor(Color.BLUE);
		g.drawLine(1000, 400, 0, 400);
		
		//Sets the font and color, then draws some text on the screen
		g.setFont(new Font("Kartik", Font.BOLD, 50));
		g.setColor(Color.ORANGE);
		g.drawString("FIRST GRAPHICS PROJECT!", 50, 550);

		//Draws three horizontal circles using a loop
		g.setColor(Color.RED);
		for (int i = 600; i < 801; i+=100) {
		g.drawOval(i, 600, 100, 100);
		
		}
		
	}

	//Driver
	public static void main (String[] args) {
		//creates a frame and sets its properties
		JFrame frame = new JFrame("Hello ITCS!!!!!");
		frame.setSize(1000, 800);
		frame.setLocation(0, 0);
		
		//tells the java program to exit when the graphics window is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//put the panel on the frame and make it visible 
		frame.setContentPane(new HelloGraphics());
		frame.setVisible(true);
	}





	

}
