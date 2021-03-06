package com.classes.obstacles;

import javafx.scene.image.Image;

public class Log extends com.classes.ui_controls.Actor {

    private final double speed;

    //This sets the log image, the position and speed of the log
    public Log(String imageLink, int size, int xpos, int ypos, double s) {
        setImage(new Image(imageLink, size, size, true, true));
        setX(xpos);
        setY(ypos);
        speed = s;

    }

    @Override
    public void act(long now) {
        move(speed, 0);
        if (getX() > 600 && speed > 0)
            setX(-180);
        if (getX() < -300 && speed < 0)
            setX(700);
    }

    public boolean getLeft() {
        return speed < 0;
    }
}
