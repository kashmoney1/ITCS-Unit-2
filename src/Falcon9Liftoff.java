//Akash Patel		ITCS

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class Falcon9Liftoff extends JPanel {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;

    // required global variables
    private BufferedImage image;
    private Graphics g;
    private Timer timer;
    private Falcon9 falcon9;



    public Falcon9Liftoff() {

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = image.getGraphics();

        falcon9 = new Falcon9(WIDTH/2, HEIGHT, 10, 75, 300, 0.05);

        timer = new Timer(1, new TimerListener());
        timer.start();

    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            g.setColor(Color.BLUE);
            g.fillRect(0, 0, WIDTH, HEIGHT);

            falcon9.drawRocket(g);

            if (falcon9.getTime() < 162) {
                falcon9.move(HEIGHT);
            }

            g.setColor(Color.BLACK);
            g.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
            g.drawString("Altitude: " + falcon9.getAltitude(), 40, 50);
            g.drawString("Time: " + falcon9.getTime(), 40, 100);
            g.drawString("Velocity: " + falcon9.getVelocity(), 40, 150);


            repaint();
        }
    }

    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Falcon 9 Liftoff");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Falcon9Liftoff());
        frame.setVisible(true);
    }
}

