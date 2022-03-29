import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class JumpingBallAnimation extends JPanel {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;
    private static final int deltaTime = 10;

    // required global variables
    private BufferedImage image;
    private Graphics g;
    private ArrayList<JumpingBall> jumpingBalls = new ArrayList<>();
    private ArrayList<Ball> balls = new ArrayList<>();
    private int hits = 0;


    @SuppressWarnings("IntegerDivisionInFloatingPointContext")
    public JumpingBallAnimation() {

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = image.getGraphics();

        for (int i = 0; i < 5; i++) {
            jumpingBalls.add(new JumpingBall(WIDTH/2, HEIGHT/2, 50 , new Color((int) (Math.random()*255), (int) (Math.random()*255), (int) (Math.random()*255))));
        }
        for (int i = 0; i < 2; i++) {
            Ball ball = new Ball(Math.random() * WIDTH, Math.random() * HEIGHT, 100, Color.BLACK);
            ball.setRandomSpeed(10);
            balls.add(ball);
        }

        for (int i = 0; i < jumpingBalls.size(); i++) {
            for (int j = 0; j < balls.size(); j++) {
                jumpingBalls.get(i).intersectsWith(balls.get(j));
            }
        }

        Timer timer = new Timer(deltaTime, new TimerListener());
        timer.start();

    }

    // TimerListener class that is called repeatedly by the timer
    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            g.setColor(Color.BLUE);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            for (int i = 0; i < balls.size(); i++) {
                balls.get(i).move(WIDTH, HEIGHT);
                balls.get(i).draw(g);
            }
            for (int i = 0; i < jumpingBalls.size(); i++) {
                jumpingBalls.get(i).draw(g);
            }
            for (int i = 0; i < jumpingBalls.size(); i++) {
                for (int j = 0; j < balls.size(); j++) {
                    if (jumpingBalls.get(i).intersectsWith(balls.get(j))) {
                        jumpingBalls.get(i).move(WIDTH, HEIGHT);
                        hits++;
                    }
                }
            }

            g.setColor(Color.WHITE);
            g.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
            g.drawString("Hits: " + hits, 50, 100);

            repaint();
        }

    }

    // do not modify this
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }

    // main method with standard graphics code
    public static void main(String[] args) {
        JFrame frame = new JFrame("Jumping Ball Animation");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new JumpingBallAnimation());
        frame.setVisible(true);
    }

}
