import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BouncingBall extends JPanel {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;

    //required global variables
    private final BufferedImage image;
    private final Graphics g;
    private final Ball[] balls;

    //Constructor required by BufferedImage
    public BouncingBall() {
        //set up Buffered Image and Graphics objects
        image =  new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = image.getGraphics();

        // Make 50 balls
        balls = new Ball[50];
        for (int i = 0; i < balls.length; i++) {
            balls[i] = new Ball(200, 200, 50, new Color((int) (Math.random()*255), (int) (Math.random()*255), (int) (Math.random()*255)));
            balls[i].setRandomSpeed(10);
        }


        //set up and start the Timer
        Timer timer = new Timer(10, new TimerListener());
        timer.start();

    }

    //TimerListener class that is called repeatedly by the timer
    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            g.setColor(Color.CYAN);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            for (Ball ball : balls) {
                ball.move(WIDTH, HEIGHT);
                ball.draw(g);
            }

            repaint();
        }
    }

    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BouncingBall");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new BouncingBall());
        frame.setVisible(true);
    }

}
