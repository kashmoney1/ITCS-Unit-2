import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class GravityBallAnimation extends JPanel {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    // required global variables
    private BufferedImage image;
    private Graphics g;
    private Timer timer;
    private GravityBall ball;

    public GravityBallAnimation() {
        // set up Buffered Image and Graphics objects
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = image.getGraphics();

        ball = new GravityBall(200, 200, 20, Color.RED);
        ball.setXAcceleration(0.0);
        ball.setYAcceleration(9.8);
        ball.setInitialVelocity(30, 45);


        timer = new Timer(10, new TimerListener());
        timer.start();

    }

    // TimerListener class that is called repeatedly by the timer
    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            g.setColor(Color.BLUE);
            g.fillRect(0, 0, WIDTH, HEIGHT);

            repaint();
        }

    }

    // do not modify this
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }

    // main method with standard graphics code
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gravity Ball Animation");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new GravityBallAnimation());
        frame.setVisible(true);
    }

}
