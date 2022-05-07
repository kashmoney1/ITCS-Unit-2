import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class GravityBallAnimation extends JPanel {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final int deltaTime = 10;

    // required global variables
    private final BufferedImage image;
    private final Graphics g;
    private final GravityBall ball;


    public GravityBallAnimation() {
        // set up Buffered Image and Graphics objects
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = image.getGraphics();

        ball = new GravityBall(200, 200, 20, Color.RED);
        ball.setXAcceleration(0.0);
        ball.setYAcceleration(9.8);
        ball.setInitialVelocity(10, 45);


        Timer timer = new Timer(deltaTime, new TimerListener());
        timer.start();

    }

    // TimerListener class that is called repeatedly by the timer
    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            g.setColor(Color.BLUE);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            ball.launch(WIDTH, HEIGHT, deltaTime);
            ball.draw(g);

            double ballXSpeed = ball.getXSpeed();
            double ballYSpeed = ball.getYSpeed();
            double ballX = ball.getX();
            double ballY = ball.getY();

            g.setColor(Color.WHITE);
            g.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
            g.drawString("X Speed: " + ballXSpeed, 75, 100);
            g.drawString("Y Speed: " + ballYSpeed, 75, 130);
            g.drawString("X Coordinate: " + ballX, 75, 160);
            g.drawString("Y Coordinate: " + ballY, 75, 190);

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
