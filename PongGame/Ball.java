import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Ball extends Rectangle {

    Random random;
    int xVelocity; //how fast is move
    int yVelocity;
    int speed = 2;

    Ball(int x, int y, int width, int height) {
        super(x, y, width, height);
        random = new Random();

        int randomXDirection = random.nextInt(2);
        if (randomXDirection == 0)
            randomXDirection--;
        setXDirection(randomXDirection * speed);

        int randomYDirection = random.nextInt(2);
        if (randomYDirection == 0)
            randomYDirection--;
        setYDirection(randomYDirection * speed);


    }

    //Ball moving
    public void setXDirection(int randomXDirection) {
        xVelocity = randomXDirection;
    }

    public void setYDirection(int randomYDirection) {
        yVelocity = randomYDirection;
    }

    public void move() {
        x += xVelocity;
        y += yVelocity;
    }

    //Ball sets color and when he drop
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x, y, height, width);
    }


}
