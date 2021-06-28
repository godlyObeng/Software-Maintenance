package com.classes.ui_controls;

import com.classes.goal.End;
import com.classes.obstacles.Log;
import com.classes.obstacles.Obstacle;
import com.classes.obstacles.Turtle;
import com.classes.obstacles.WetTurtle;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class Animal extends Actor {
    final Image frogUp;
    final Image frogLeft;
    final Image frogDown;
    final Image frogRight;
    final Image frogUpJump;
    final Image frogLeftJump;
    final Image frogDownJump;
    final Image frogRightJump;
    final double movement = 30;
    final double movementX = 25;
    final int imgSize = 40;
    int points = 0;
    int end = 0;
    boolean noMove = false;
    boolean carDeath = false;
    boolean waterDeath = false;
    boolean changeScore = false;
    int carD = 0;
    double w = 800;
    ArrayList<End> inter = new ArrayList<>();
    private boolean second = false;

    public Animal(String imageLink) {
        setImage(new Image(imageLink, imgSize, imgSize, true, true));
        setX(300);
        setY(700 + movement);
        frogUp = new Image("file:src/com/resources/froggerUp.png", imgSize, imgSize, true, true);
        frogLeft = new Image("file:src/com/resources/froggerLeft.png", imgSize, imgSize, true, true);
        frogDown = new Image("file:src/com/resources/froggerDown.png", imgSize, imgSize, true, true);
        frogRight = new Image("file:src/com/resources/froggerRight.png", imgSize, imgSize, true, true);
        frogUpJump = new Image("file:src/com/resources/froggerUpJump.png", imgSize, imgSize, true, true);
        frogLeftJump = new Image("file:src/com/resources/froggerLeftJump.png", imgSize, imgSize, true, true);
        frogDownJump = new Image("file:src/com/resources/froggerDownJump.png", imgSize, imgSize, true, true);
        frogRightJump = new Image("file:src/com/resources/froggerRightJump.png", imgSize, imgSize, true, true);

        /*The following code is used to register keyboard events and change the image accordingly*/
        //changed the code here based on recommendation by the IDE
        setOnKeyPressed(event -> {
                    // noinspection StatementWithEmptyBody
                    if (noMove) {
                    } else {
                        if (second) {
                            if (event.getCode() == KeyCode.UP) {
                                move(0, -movement);
                                changeScore = false;
                                setImage(frogUp);
                                second = false;
                            } else if (event.getCode() == KeyCode.LEFT) {
                                move(-movementX, 0);
                                setImage(frogLeft);
                                second = false;
                            } else if (event.getCode() == KeyCode.DOWN) {
                                move(0, movement);
                                setImage(frogDown);
                                second = false;
                            } else if (event.getCode() == KeyCode.RIGHT) {
                                move(movementX, 0);
                                setImage(frogRight);
                                second = false;
                            }
                        } else if (event.getCode() == KeyCode.UP) {
                            move(0, -movement);
                            setImage(frogUpJump);
                            second = true;
                        } else if (event.getCode() == KeyCode.LEFT) {
                            move(-movementX, 0);
                            setImage(frogLeftJump);
                            second = true;
                        } else if (event.getCode() == KeyCode.DOWN) {
                            move(0, movement);
                            setImage(frogDownJump);
                            second = true;
                        } else if (event.getCode() == KeyCode.RIGHT) {
                            move(movementX, 0);
                            setImage(frogRightJump);
                            second = true;
                        }
                    }
                }
        );

        /*The following code is used to register keyboard events and change the image and score accordingly*/
        //changed the code here based on recommendation by the IDE
        setOnKeyReleased(event -> {
            if (noMove) {
            } else {
                if (event.getCode() == KeyCode.UP) {
                    if (getY() < w) {
                        changeScore = true;
                        w = getY();
                        points += 10; //This increases the points when there's a successful move forward
                    }

                    move(0, -movement);
                    setImage(frogUp);
                    second = false;
                }

                else if (event.getCode() == KeyCode.LEFT) {
                    move(-movementX, 0);
                    setImage(frogLeft);
                    second = false;
                }

                else if (event.getCode() == KeyCode.DOWN) {
                    move(0, movement);
                    setImage(frogDown);
                    second = false;
                }

                else if (event.getCode() == KeyCode.RIGHT) {
                    move(movementX, 0);
                    setImage(frogRight);
                    second = false;
                }
            }
        });
    }

    @Override
    public void act(long now) {
        //removed redundant variable "bounds"
        if (getY() < 0 || getY() > 734) {
            setX(300);
            setY(700 + movement);
        }
        if (getX() < 0) {
            move(movement * 2, 0);
        }
        if (carDeath) {
            noMove = true;
            if ((now) % 11 == 0) {
                carD++;
            }
            if (carD == 1) {
                setImage(new Image("file:src/com/resources/cardeath1.png", imgSize, imgSize, true, true));
            }
            if (carD == 2) {
                setImage(new Image("file:src/com/resources/cardeath2.png", imgSize, imgSize, true, true));
            }
            if (carD == 3) {
                setImage(new Image("file:src/com/resources/cardeath3.png", imgSize, imgSize, true, true));
            }
            if (carD == 4) {
                setX(300);
                setY(700 + movement);
                carDeath = false;
                carD = 0;
                setImage(new Image("file:src/com/resources/froggerUp.png", imgSize, imgSize, true, true));
                noMove = false;
            }
            /*There was a bug that was only subtracting points when carD is 5.
             * I moved this if condition here so anytime there is death, it subtracts*/
            if (points > 50) {
                points -= 50; //This subtracts 50 from points anytime there is a car death
                changeScore = true;
            }
        }
        if (waterDeath) {
            noMove = true;
            if ((now) % 11 == 0) {
                carD++;
            }
            if (carD == 1) {
                setImage(new Image("file:src/com/resources/waterdeath1.png", imgSize, imgSize, true, true));
            }
            if (carD == 2) {
                setImage(new Image("file:src/com/resources/waterdeath2.png", imgSize, imgSize, true, true));
            }
            if (carD == 3) {
                setImage(new Image("file:src/com/resources/waterdeath3.png", imgSize, imgSize, true, true));
            }
            if (carD == 4) {
                setImage(new Image("file:src/com/resources/waterdeath4.png", imgSize, imgSize, true, true));
            }
            if (carD == 5) {
                setX(300);
                setY(700 + movement);
                waterDeath = false;
                carD = 0;
                setImage(new Image("file:src/com/resources/froggerUp.png", imgSize, imgSize, true, true));
                noMove = false;
            }
            /*There was a bug that was only subtracting points when carD is 5.
             * I moved this if condition here so anytime there is death, it subtracts*/
            if (points > 50) {
                points -= 50; //This subtracts 50 from points anytime there is a water death
                changeScore = true;
            }
        }

        if (getX() > 600) {
            move(-movement * 2, 0);
        }

        if (getIntersectingObjects(Obstacle.class).size() >= 1) {
            carDeath = true;
        }

        //removed redundant if condition from here

        if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
            if (getIntersectingObjects(Log.class).get(0).getLeft())
                move(-2, 0);
            else
                move(.75, 0);

        }

        else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
            move(-1, 0);
        }

        else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
            if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
                waterDeath = true;
            }

            else {
                move(-1, 0);
            }
        }

        else if (getIntersectingObjects(End.class).size() >= 1) {
            inter = (ArrayList<End>) getIntersectingObjects(End.class);

            if (getIntersectingObjects(End.class).get(0).isActivated()) {
                end--;
                points -= 50;
            }

            points += 50;
            changeScore = true;
            w = 800;
            getIntersectingObjects(End.class).get(0).setEnd();
            end++;
            setX(300);
            setY(700 + movement);
        }
        else if (getY() < 340) {
            waterDeath = true;
        }
    }

    public boolean getStop() {
        return end == 5;
    }

    public int getPoints() {
        return points;
    }

    public boolean changeScore() {
        if (changeScore) {
            changeScore = false;
            return true;
        }
        return false;
    }
}
