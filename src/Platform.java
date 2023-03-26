import javax.swing.*;
import java.awt.*;

public class Platform {
    private Image image = new ImageIcon("").getImage();
    private int x, y;
    Rectangle body = new Rectangle();

    public Platform(Image image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
        body.setRect(x, y, image.getWidth(null), image.getWidth(null));
    }

    public void update(Hero hero) {
        checkHorizontalCollision(hero);
        checkVerticalCollision(hero);
    }

    private void checkVerticalCollision(Hero hero) {
        if (body.intersects(hero.getLegs())) {
            hero.setJump(false);
            hero.setSpeedY(0);
            hero.setY(y - hero.getImage().getHeight(null) + 5);
        }
        if (body.intersects(hero.getHead())) {
            hero.setSpeedY(-hero.getJUMP_SPEED());
            hero.setY(y + image.getHeight(null));
        }
    }

    private void checkHorizontalCollision(Hero hero) {
        if (body.intersects(hero.getLeft())) {
            hero.setX(x + body.width);
            hero.setSpeedX(0);
        }
        if (body.intersects(hero.getRight())) {
            hero.setX(x - body.width);
            hero.setSpeedX(0);//
        }
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rectangle getBody() {
        return body;
    }

    public void setBody(Rectangle body) {
        this.body = body;
    }
}
