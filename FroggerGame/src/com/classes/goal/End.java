package com.classes.goal;

import com.classes.ui_controls.Actor;
import javafx.scene.image.Image;

public class End extends Actor {
    boolean activated = false;

    //this is the default look for the end before the frog fills it
    public End(int x, int y) {
        setX(x);
        setY(y);
        setImage(new Image("file:src/com/resources/End.png", 50, 50, true, true));
    }

    @Override
    public void act(long now) {
    }

    //this shows when the frog has successfully entered the hole
    public void setEnd() {
        setImage(new Image("file:src/com/resources/FrogEnd.png", 50, 50, true, true));
        activated = true;
    }

    //This shows if the hole for the frog is activated or not
    public boolean isActivated() {
        return activated;
    }
}
