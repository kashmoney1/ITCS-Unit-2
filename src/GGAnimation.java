import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class GGAnimation extends JPanel {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;

    // required global variables
    private BufferedImage image;
    private Graphics g;
    private int hits = 0;
    private Player player;
    private Alien alien;
    private Alien boss;
    private Timer timer;

    public ArrayList<Laser> getLasers() {
        return lasers;
    }

    private ArrayList<Laser> lasers = new ArrayList<>();

    @SuppressWarnings("IntegerDivisionInFloatingPointContext")
    public GGAnimation() {

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = image.getGraphics();

        alien = new Alien(WIDTH/4 + WIDTH/2, 100, 50 , 50);
        player = new Player(WIDTH/2, 900);
        boss = new Alien(WIDTH/4, 100, 100, 100);

        timer = new Timer(10, new TimerListener(this));
        timer.start();
        addMouseListener(new Mouse());
        addKeyListener(new Keyboard(this));
        setFocusable(true);
    }

    private class Keyboard implements KeyListener {
        private GGAnimation a;

        public Keyboard(GGAnimation a) {
            this.a = a;
        }
        @Override
        public void keyPressed(KeyEvent e) {

            if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                player.setX(player.getX() - 20);
            }
            if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                player.setX(player.getX() + 20);
            }
            if(e.getKeyCode() == KeyEvent.VK_UP) {
                this.a.getLasers().add(new Laser(player.getX(), player.getY()));
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_X) {
            }
        }
        @Override
        public void keyTyped(KeyEvent e) {

        }
    }

    private class Mouse implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private class TimerListener implements ActionListener {
        private GGAnimation a;
        public TimerListener(GGAnimation a) {
            this.a = a;
        }
        @Override
        public void actionPerformed(ActionEvent e) {

            g.setColor(Color.BLUE);
            g.fillRect(0, 0, WIDTH, HEIGHT);

            player.setCenter();
            alien.drawAlien(g);

            for (Laser laser : this.a.getLasers()) {
                laser.move();
                laser.draw(g);
            }
            player.drawPlayer(g);
            boss.drawBoss(g);


            g.setColor(Color.WHITE);
            g.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
            g.drawString("Points: " + hits, 50, 100);

            repaint();
        }

    }

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


