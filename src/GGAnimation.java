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
    private int health = 100;
    private Player player;
    private Alien alien;
    private Alien boss;
    private Timer timer;
    private ArrayList<Alien> aliens = new ArrayList<>();
    private ArrayList<Hitbox> alienHitboxes = new ArrayList<>();
    private ArrayList<Hitbox> laserHitboxes = new ArrayList<>();
    private ArrayList<Hitbox> alienLaserHitboxes = new ArrayList<>();
    private Hitbox playerHitbox;

    public ArrayList<Laser> getLasers() {
        return lasers;
    }

    private ArrayList<Laser> lasers = new ArrayList<>();

    @SuppressWarnings("IntegerDivisionInFloatingPointContext")
    public GGAnimation() {

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = image.getGraphics();

        aliens.add(new Alien(100, 100, 50, 50));
        aliens.add(new Alien(500, 100, 50, 50));
        aliens.add(new Alien(900, 100, 50, 50));
        aliens.add(new Alien(300, 100, 100, 100));
        aliens.add(new Alien(700, 100, 100, 100));
        alienHitboxes.add(new Hitbox(100, 100, 50, 50));
        alienHitboxes.add(new Hitbox(500, 100, 50, 50));
        alienHitboxes.add(new Hitbox(900, 100, 50, 50));
        alienHitboxes.add(new Hitbox(300, 100, 100, 100));
        alienHitboxes.add(new Hitbox(700, 100, 100, 100));
        player = new Player(WIDTH / 2, 900);
        playerHitbox = new Hitbox(WIDTH / 2, 900, 80, 50);

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

            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                player.setX(player.getX() - 20);
                playerHitbox.move(-20, 0);
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                player.setX(player.getX() + 20);
                playerHitbox.move(20, 0);
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                this.a.getLasers().add(new Laser(player.getX(), player.getY()));
                laserHitboxes.add(new Hitbox(player.getX(), player.getY(), 15, 45));
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_X) {
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
            player.drawPlayer(g);

            for (Laser laser : this.a.getLasers()) {
                laser.move();
                laser.draw(g);
            }
            for (Alien alien : aliens) {
                alien.drawAlien(g);
            }

            // akash is a dumbass and couldn't figure this out
            // goon++ supremacy
            for (int i = 0; i < aliens.size(); i++) {
                for (int j = 0; j < lasers.size(); j++) {
                    if (aliens.get(i).intersectsWith(lasers.get(j))) {
                        hits += 20;
                        aliens.remove(i);
                        i--;
                        lasers.remove(j);
                        j--;
                        break;
                    }
                }
            }


            g.setColor(Color.WHITE);
            g.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
            g.drawString("Points: " + hits, 25, 50);
            g.drawString("Health: ", 200, 50);

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