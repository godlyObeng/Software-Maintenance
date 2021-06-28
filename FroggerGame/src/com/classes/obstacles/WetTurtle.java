package com.classes.obstacles;

import com.classes.ui_controls.Actor;
import javafx.scene.image.Image;

public class WetTurtle extends Actor {
    final Image turtle1;
    final Image turtle2;
    final Image turtle3;
    final Image turtle4;
    private final int speed;
    boolean sunk = false;

    public WetTurtle(int xpos, int ypos, int s, int w, int h) {
        turtle1 = new Image("file:src/com/resources/TurtleAnimation1.png", w, h, true, true);
        turtle2 = new Image("file:src/com/resources/TurtleAnimation2Wet.png", w, h, true, true);
        turtle3 = new Image("file:src/com/resources/TurtleAnimation3Wet.png", w, h, true, true);
        turtle4 = new Image("file:src/com/resources/TurtleAnimation4Wet.png", w, h, true, true);
        setX(xpos);
        setY(ypos);
        speed = s;
        setImage(turtle2);
    }

    @Override
    public void act(long now) {

        if (now / 900000000 % 4 == 0) {
            setImage(turtle2);
            sunk = false;

        } else if (now / 900000000 % 4 == 1) {
            setImage(turtle1);
            sunk = false;
        } else if (now / 900000000 % 4 == 2) {
            setImage(turtle3);
            sunk = false;
        } else if (now / 900000000 % 4 == 3) {
            setImage(turtle4);
            sunk = true;
        }

        move(speed, 0);
        if (getX() > 600 && speed > 0)
            setX(-200);
        if (getX() < -75 && speed < 0)
            setX(600);
    }

    public boolean isSunk() {
        return sunk;
    }
}
