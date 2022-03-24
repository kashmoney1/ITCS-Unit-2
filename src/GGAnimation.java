import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GGAnimation extends JPanel {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;

    // required global variables
    private BufferedImage image;
    private Graphics g;
    private int hits = 0;
    private Player player;
    private Laser laser;
    private Alien alien;
    private Timer timer;


    @SuppressWarnings("IntegerDivisionInFloatingPointContext")
    public GGAnimation() {

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = image.getGraphics();

        jumpingBall = new JumpingBall(WIDTH/2, HEIGHT/2, 50 , new Color((int) (Math.random()*255), (int) (Math.random()*255), (int) (Math.random()*255)));
        ball = new Ball(Math.random() * WIDTH, Math.random() * HEIGHT, 100, Color.BLACK);
        ball.setRandomSpeed(10);

        timer = new Timer(10, new TimerListener());
        timer.start();
        addMouseListener(new Mouse());
        addKeyListener(new Keyboard());
        setFocusable(true);
    }

    private class Keyboard implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {

            if(e.getKeyCode() == KeyEvent.VK_W) {
                jumpingBall.setY(jumpingBall.getY()-10);
            }
            if(e.getKeyCode() == KeyEvent.VK_A) {
                jumpingBall.setX(jumpingBall.getX()-10);
            }
            if(e.getKeyCode() == KeyEvent.VK_S) {
                jumpingBall.setY(jumpingBall.getY()+10);
            }
            if(e.getKeyCode() == KeyEvent.VK_D) {
                jumpingBall.setX(jumpingBall.getX() + 10);
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_X) {
                jumpingBall.setLocation(0, 0);
            }
        }
        @Override
        public void keyTyped(KeyEvent e) {

        }
    }

    private class Mouse implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == 1) { // left click
                jumpingBall.setLocation(e.getX(), e.getY());
            } else if (e.getButton() == 3) { // right click
                ball.setLocation(e.getX(), e.getY());
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == 1) { //left click
                jumpingBall.setLocation(WIDTH/2, HEIGHT/2);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(e.getButton() == 1 && e.isShiftDown()) {
                ball.setRandomSpeed(10);
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            ball.setXSpeed(10);
            ball.setYSpeed(10);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ball.setXSpeed(3);
            ball.setYSpeed(3);
        }
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            g.setColor(Color.BLUE);
            g.fillRect(0, 0, WIDTH, HEIGHT);

            ball.move(WIDTH, HEIGHT);
            ball.draw(g);

            jumpingBall.draw(g);

            if(jumpingBall.intersectsWith(ball)) {
                jumpingBall.move(WIDTH, HEIGHT);
                hits++;
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
        JFrame frame = new JFrame("Galactic Goons");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new GGAnimation());
        frame.setVisible(true);
    }

}


