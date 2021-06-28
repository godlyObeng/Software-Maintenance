package com.classes.obstacles;

import javafx.scene.image.Image;

public class Obstacle extends com.classes.ui_controls.Actor {
    private final int speed;

    /*This sets the coordinates for the obstacle image*/
    public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
        setImage(new Image(imageLink, w, h, true, true));
        setX(xpos);
        setY(ypos);
        speed = s;
    }

    @Override
    public void act(long now) {
        move(speed, 0);
        if (getX() > 600 && speed > 0)
            setX(-200);
        if (getX() < -50 && speed < 0)
            setX(600);
    }

}
