//Akash Patel		ITCS

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;

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

        falcon9 = new Falcon9(WIDTH/2, HEIGHT, 10, 30, 300, 0.05);

        timer = new Timer(1, new TimerListener());
        timer.start();

    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            Graphics2D g2D = (Graphics2D) g;
            GradientPaint blackToBlue = new GradientPaint(0, 0, new Color(0, 0, 0), 0, 500, new Color(0, 10, 255));
            g2D.setPaint(blackToBlue);
            g2D.fillRect(0, 0, WIDTH, HEIGHT);

            falcon9.drawRocket(g);

            if (falcon9.getTime() < 162) {
                falcon9.move(HEIGHT);
            }

            g.setColor(Color.WHITE);
            g.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
            g.drawString("Falcon 9 Stage 1: ", 40, 100);
            g.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
            g.drawString("Altitude: " + falcon9.getAltitude() + " meters", 40, 150);
            g.drawString("Time: " + falcon9.getTime() + " seconds", 40, 200);
            g.drawString("Velocity: " + falcon9.getVelocity() + " m/s", 40, 250);


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

