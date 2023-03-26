import javax.swing.*;
import java.awt.*;

public class Hero {
    final private int JUMP_SPEED = -15;
    private int x, y;
    private Image image = new ImageIcon("").getImage();
    private Rectangle body = new Rectangle();
    private Rectangle head = new Rectangle();
    private Rectangle legs = new Rectangle();
    private Rectangle right = new Rectangle();
    private Rectangle left = new Rectangle();
    private int speedX = 0;
    private int speedY = 0;
    private boolean isJump = false;

    public Hero(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
        body.setRect(x, y,
                image.getWidth(null),
                image.getHeight(null));
        head.setRect(x + 5, y,
                image.getWidth(null) - 10,
                10);
        legs.setRect(x + 5, y + 70,
                image.getWidth(null) - 10,
                10);
        left.setRect(x, y + 5,
                10,
                image.getHeight(null) - 10);
        right.setRect(x + 30, y + 5,
                10,
                image.getHeight(null) - 10);

    }
    public void move() {
        x += speedX;
        body.setRect(x, y,
                image.getWidth(null),
                image.getHeight(null));
    }

    public void jump() {
        if (!isJump) {
            speedY = JUMP_SPEED;
            isJump = true;
        }
    }

    public void update() {
        y += speedY;
        speedY++;
        if (speedY > 3) {
            isJump = true;
        }
        body.setRect(x, y,
                image.getWidth(null),
                image.getHeight(null));
        head.setRect(x + 5, y,
                image.getWidth(null) - 10,
                10);
        legs.setRect(x + 5, y + 70,
                image.getWidth(null) - 10,
                10);
        left.setRect(x, y + 5,
                10,
                image.getHeight(null) - 10);
        right.setRect(x + 30, y + 5,
                10,
                image.getHeight(null) - 10);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public Rectangle getBody() {
        return body;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public boolean isJump() {
        return isJump;
    }

    public void setJump(boolean jump) {
        isJump = jump;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rectangle getHead() {
        return head;
    }

    public Rectangle getLegs() {
        return legs;
    }

    public Rectangle getRight() {
        return right;
    }

    public Rectangle getLeft() {
        return left;
    }

    public int getJUMP_SPEED() {
        return JUMP_SPEED;
    }
}
