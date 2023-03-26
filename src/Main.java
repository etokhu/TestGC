import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends JPanel implements KeyListener, Runnable {
    static Main state = new Main();
    Image imageHero = new ImageIcon("character/right/0.png").getImage();
    private Image earth = new ImageIcon("background/images/earth.png").getImage();//
    Hero hero = new Hero(100, 100, imageHero);
    private ArrayList<Background> backgrounds = new ArrayList<>();
    private ArrayList<Platform> platforms = new ArrayList<>();
    static Image background = new ImageIcon("background/background.jpg").getImage();

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(background.getWidth(null), background.getHeight(null));
        frame.setLocation(100, 100);
        frame.add(state);
        frame.addKeyListener(state);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        try{
            state.start();
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
    }
////
    private void loadMap(String filename) throws IOException {

        ArrayList lines = new ArrayList();
        int width = 0;
        int height = 0;

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                reader.close();
                break;
            }

            if (!line.startsWith("!")) {
                lines.add(line);
                width = Math.max(width, line.length());
            }
        }
        height = lines.size();

        for (int j = 0; j < height; j++) {
            String line = (String) lines.get(j);
            for (int i = 0; i < width; i++) {

                if (i < line.length()) {
                    char ch = line.charAt(i);
                    backgrounds.add(new Background(i, j, ch));
                    if(ch == '2'){
                        platforms.add(new Platform(earth, i * 40, j * 40));
                    }
                }
            }
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, 0, 0, null);
        for (Background background : backgrounds) {
            g.drawImage(background.getImage(), background.getX(), background.getY(), null);
        }
        g.drawImage(hero.getImage(), hero.getX(), hero.getY(), null);
        g.drawRect(hero.getHead().x, hero.getHead().y,
                hero.getHead().width, hero.getHead().height);
        g.drawRect(hero.getLegs().x, hero.getLegs().y,
                hero.getLegs().width, hero.getLegs().height);
        g.drawRect(hero.getLeft().x, hero.getLeft().y,
                hero.getLeft().width, hero.getLeft().height);
        g.drawRect(hero.getRight().x, hero.getRight().y,
                hero.getRight().width, hero.getRight().height);
    }
    private void update(){//
        hero.update();
        hero.move();
        for (Platform pl: platforms) {
            pl.update(hero);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case (KeyEvent.VK_ESCAPE):
                System.exit(0);
                break;
            case (KeyEvent.VK_A):
                hero.setSpeedX(-5);
                break;
            case (KeyEvent.VK_D):
                hero.setSpeedX(5);
                break;
            case (KeyEvent.VK_SPACE):
                hero.jump();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case (KeyEvent.VK_A):
            case (KeyEvent.VK_D):
                hero.setSpeedX(0);
                break;
        }
    }

    @Override
    public void run() {
        while (true) {
            update();
            repaint();
            try {
                Thread.sleep(40);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        try {
            loadMap("background/map.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread thread = new Thread(this);///
        thread.start();

    }
}
