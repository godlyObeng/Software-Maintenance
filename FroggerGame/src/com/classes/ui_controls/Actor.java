package com.classes.ui_controls;

import javafx.scene.image.ImageView;

import java.util.ArrayList;


public abstract class Actor extends ImageView {

    /*This method is for setting the next position or movement of the object based on x and y*/
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }


    public World getWorld() {
        return (World) getParent();
    }

    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<>();

        for (A actor : getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }

    //removed a redundant method from here

    public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<>();
        for (A actor : getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }

    public abstract void act(long now);
}
