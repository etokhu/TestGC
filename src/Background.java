import javax.swing.*;
import java.awt.*;

public class Background {//
    private Image earth = new ImageIcon("background/images/earth.png").getImage();
    private Image platform = new ImageIcon("background/images/platform.png").getImage();//!!!!
    private Image tree = new ImageIcon("background/images/tree.png").getImage();
    private Image barrel = new ImageIcon("background/images/barrel.png").getImage();
    private Image bridge = new ImageIcon("background/images/bridge.png").getImage();//!!!!
    private Image image;
    private int x, y;
    private char type;///

    public Background(int x, int y, char type) {
        this.x = x * 40;
        this.y = y * 40;
        this.type = type;///////
        switch (type) {
            case ('2'):
                image = earth;
                break;
            case ('3'):
                image = platform;
                break;
            case ('4'):
                image = tree;
                break;
            case ('5'):
                image = barrel;
                break;
            case ('6'):
                image = bridge;
                break;
            default:
                this.type = '0';
                break;
        }
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
//