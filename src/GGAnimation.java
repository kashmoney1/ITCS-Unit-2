import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class GGAnimation extends JPanel {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;

    //variables
    private final BufferedImage image;
    private final Graphics g;
    private int hits = 0;
    private final Player player;

    //arraylist usages
    private final ArrayList<Alien> aliens = new ArrayList<>();
    public ArrayList<Laser> getLasers() {
        return lasers;
    }
    private final ArrayList<Laser> lasers = new ArrayList<>();

    public GGAnimation() {

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = image.getGraphics();

        //5 aliens and one player declared
        aliens.add(new Alien(100, 100, 50, 50));
        aliens.add(new Alien(500, 100, 50, 50));
        aliens.add(new Alien(900, 100, 50, 50));
        aliens.add(new Alien(300, 100, 100, 100));
        aliens.add(new Alien(700, 100, 100, 100));
        player = new Player(WIDTH/2, 900);

        Timer timer = new Timer(10, new TimerListener(this));
        timer.start();
        addKeyListener(new Keyboard(this));
        setFocusable(true);
    }

    private class Keyboard implements KeyListener {
        private final GGAnimation a;

        public Keyboard(GGAnimation a) {
            this.a = a;
        }

        @Override
        public void keyPressed(KeyEvent e) {

            //Move left
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                player.setX(player.getX() - 20);
            }
            //Move right
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                player.setX(player.getX() + 20);
            }
            //Fire lasers
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                this.a.getLasers().add(new Laser(player.getX(), player.getY()));
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            e.getKeyCode();
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }
    }

    private class TimerListener implements ActionListener {
        private final GGAnimation a;

        public TimerListener(GGAnimation a) {
            this.a = a;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            g.setColor(Color.BLUE);
            g.fillRect(0, 0, WIDTH, HEIGHT);

            player.setCenter();
            player.drawPlayer(g);

            //Draw lasers from arraylist
            for (Laser laser : this.a.getLasers()) {
                laser.move();
                laser.draw(g);
            }

            //Draw aliens from arraylist
            for (Alien alien : aliens) {
                alien.drawAlien(g);
            }

            //Intersects with + eliminates aliens when shot
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

            //Data displayed for points player has obtained
            g.setColor(Color.WHITE);
            g.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
            g.drawString("Points: " + hits, 25, 50);

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