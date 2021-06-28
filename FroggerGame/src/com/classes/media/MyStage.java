package com.classes.media;

import com.classes.ui_controls.World;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class MyStage extends World {
    MediaPlayer mediaPlayer;

    //Deleted a redundant constructor from here

    //This method plays the theme song for the game
    public void playMusic() {
        String musicFile = "src/com/resources/themeSong.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public void stopMusic() {
        mediaPlayer.stop();
    }

    @Override
    protected void act(long now) {

    }
}
