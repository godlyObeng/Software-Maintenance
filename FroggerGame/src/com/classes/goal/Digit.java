package com.classes.goal;

import com.classes.ui_controls.Actor;
import javafx.scene.image.Image;

public class Digit extends Actor {
    final Image im1;

    /*This sets the coordinates for the digit*/
    public Digit(int n, int dim, int x, int y) {
        im1 = new Image("file:src/com/resources/" + n + ".png", dim, dim, true, true);
        setImage(im1);
        setX(x);
        setY(y);
    }

    @Override
    public void act(long now) {
    }

}
