import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class HailHydra extends JPanel {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;

    //required global variables
    private final BufferedImage image;
    private final Graphics g;
    private final Ball ball;
    ArrayList<JumpingBall> jumpingBalls = new ArrayList<>();

    public HailHydra() {

        image =  new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = image.getGraphics();

        ball = new Ball((Math.random() * (WIDTH - 100) + 50), (Math.random() * (HEIGHT - 100) + 50), 100, Color.BLACK);
        ball.setXSpeed(Math.random() * 5 + 10);
        ball.setYSpeed(Math.random() * 5 + 10);
        ball.draw(g);
        ball.move(WIDTH, HEIGHT);

        for (int i = 0; i < 3; i++) {
            jumpingBalls.add(new JumpingBall((Math.random() * (WIDTH - 100) + 50), (Math.random() * (HEIGHT - 100) + 50), 50, new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255))));
            jumpingBalls.get(i).move(WIDTH, HEIGHT);
            jumpingBalls.get(i).draw(g);
        }

        Timer timer = new Timer(10, new TimerListener());
        timer.start();

    }

    //TimerListener class that is called repeatedly by the timer
    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            g.setColor(Color.BLUE);
            g.fillRect(0, 0, WIDTH, HEIGHT);

            int hits = 0;

            for (int i = 0; i < jumpingBalls.size(); i++) {
                hits += jumpingBalls.get(i).getHits();
                if (jumpingBalls.get(i).intersectsWith(ball)) {
                    jumpingBalls.get(i).setX(5000);
                    jumpingBalls.add(new JumpingBall((Math.random() * (WIDTH - 100) + 50), (Math.random() * (HEIGHT - 100) + 50), jumpingBalls.get(i).getRadius(), jumpingBalls.get(i).getColor()));
                    jumpingBalls.add(new JumpingBall((Math.random() * (WIDTH - 100) + 50), (Math.random() * (HEIGHT - 100) + 50), jumpingBalls.get(i).getRadius(), jumpingBalls.get(i).getColor()));
                }

                if (jumpingBalls.get(i).getDiameter() <= 10) {
                    jumpingBalls.get(i).setX(5000);
                }
            }

            for (JumpingBall jumpingBall : jumpingBalls) {
                if (jumpingBall.getX() != 5000) {
                    jumpingBall.draw(g);
                }
            }

            ball.move(WIDTH, HEIGHT);
            ball.draw(g);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
            g.drawString("Hits: " + hits, 50, 100);
            repaint();
        }

    }

    //do not modify this
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }

    //main method with standard graphics code
    public static void main(String[] args) {
        JFrame frame = new JFrame("HailHydra");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new HailHydra());
        frame.setVisible(true);
    }

}