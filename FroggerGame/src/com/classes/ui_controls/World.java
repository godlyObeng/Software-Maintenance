package com.classes.ui_controls;


import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public abstract class World extends Pane {
    private AnimationTimer timer;

    public World() {
        sceneProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                newValue.setOnKeyReleased(event -> {
                    if (getOnKeyReleased() != null)
                        getOnKeyReleased().handle(event);
                    List<Actor> myActors = getObjects(Actor.class);
                    for (Actor anActor : myActors) {
                        if (anActor.getOnKeyReleased() != null) {
                            anActor.getOnKeyReleased().handle(event);
                        }
                    }
                });

                newValue.setOnKeyPressed(event -> {
                    if (getOnKeyPressed() != null)
                        getOnKeyPressed().handle(event);
                    List<Actor> myActors = getObjects(Actor.class);
                    for (Actor anActor : myActors) {
                        if (anActor.getOnKeyPressed() != null) {
                            anActor.getOnKeyPressed().handle(event);
                        }
                    }
                });
            }

        });
    }

    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                List<Actor> actors = getObjects(Actor.class);

                for (Actor anActor : actors) {
                    anActor.act(now);
                }

            }
        };
    }

    protected abstract void act(long now);

    public void start() {
        createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void add(Actor actor) {
        getChildren().add(actor);
    }

// --Commented out by Inspection START (05/12/2019 16:17):
//    public void remove(Actor actor) {
//        getChildren().remove(actor);
//    }
// --Commented out by Inspection STOP (05/12/2019 16:17)

    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<>();
        for (Node n : getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A) n);
            }
        }
        return someArray;
    }

}
