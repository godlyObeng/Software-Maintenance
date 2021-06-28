package com.classes.ui_controls;

import javafx.scene.image.Image;

public class BackgroundImage extends Actor {

    /*This sets the coordinates for the background image*/
    public BackgroundImage(String imageLink) {
        setImage(new Image(imageLink, 600, 800, true, true));
    }

    //added new constructor to help with the start page image dimensions
    public BackgroundImage(String imageLink, String imageType) {
        setImage(new Image(imageLink, 600, 780, true, true));
    }

    @Override
    public void act(long now) {
    }
}
