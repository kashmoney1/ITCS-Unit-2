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
    private BufferedImage bufferedImage;
    private Graphics g;
    private int hits = 0;
    private Player player;
    private Alien alien;
    private Alien boss;
    private Timer timer;
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

        bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();

        alien = new Alien(WIDTH/4 + WIDTH/2, 100, 50 , 50);
        alienHitboxes.add(new Hitbox(WIDTH/4 + WIDTH/2, 100, 50, 50));
        player = new Player(WIDTH/2, 900);
        playerHitbox = new Hitbox(WIDTH/2, 900, 80, 50);
        boss = new Alien(WIDTH/4, 100, 100, 100);
        alienHitboxes.add(new Hitbox(WIDTH/4, 100, 100, 100));

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
                playerHitbox.move(-20, 0);
            }
            if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                player.setX(player.getX() + 20);
                playerHitbox.move(20, 0);
            }
            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                this.a.getLasers().add(new Laser(player.getX(), player.getY()));
                laserHitboxes.add(new Hitbox(player.getX(), player.getY(), 15, 45));
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

            ImageIcon image = new ImageIcon("Space.png");
            g.drawImage(image.getImage(),WIDTH/4, HEIGHT/4, WIDTH/2, HEIGHT/2, null);

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
        g.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), null);
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


