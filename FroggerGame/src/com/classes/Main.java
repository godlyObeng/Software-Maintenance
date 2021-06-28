package com.classes;

import com.classes.goal.Digit;
import com.classes.goal.End;
import com.classes.media.MyStage;
import com.classes.obstacles.Log;
import com.classes.obstacles.Obstacle;
import com.classes.obstacles.Turtle;
import com.classes.obstacles.WetTurtle;
import com.classes.ui_controls.Animal;
import com.classes.ui_controls.BackgroundImage;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.stage.Stage;


public class Main extends Application {
    AnimationTimer timer;
    MyStage background;
    MyStage startBackg;
    MyStage howToPlayStage;
    MyStage scoreB;
    Animal animal;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        background = new MyStage();
        startBackg = new MyStage();
        howToPlayStage = new MyStage();
        scoreB = new MyStage();
        Scene startScene = new Scene(startBackg, 600, 780);
        Scene gameScene = new Scene(background, 600, 780);
        Scene howToPlay = new Scene(howToPlayStage, 600, 780);
        Scene scoreBoard = new Scene(scoreB, 600, 780);


        Button button = new Button("PLAY");
        button.setOnAction(e -> primaryStage.setScene(gameScene));
        button.setMinHeight(80);
        button.setMinWidth(200);
        button.setStyle("-fx-font-size: 2em;");
        button.setLayoutX(200);
        button.setLayoutY(440);

        Button button1 = new Button("HOW TO PLAY");
        button1.setOnAction(e -> primaryStage.setScene(howToPlay));
        button1.setMinHeight(80);
        button1.setMinWidth(200);
        button1.setStyle("-fx-font-size: 2em;");
        button1.setLayoutX(200);
        button1.setLayoutY(550);

        Button button2 = new Button("SCORE RANKING");
        button2.setOnAction(e -> primaryStage.setScene(scoreBoard));
        button2.setMinHeight(80);
        button2.setMinWidth(200);
        button2.setStyle("-fx-font-size: 2em;");
        button2.setLayoutX(200);
        button2.setLayoutY(660);

        Button button4 = new Button("HOME");
        button4.setOnAction(e -> primaryStage.setScene(startScene));
        button4.setMinHeight(50);
        button4.setMinWidth(100);
        button4.setStyle("-fx-font-size: 2em; -fx-background-color: transparent;");
        button4.setLayoutX(30);
        button4.setLayoutY(730);
        howToPlayStage.start();

        Button button5 = new Button("HOME");
        button5.setOnAction(e -> primaryStage.setScene(startScene));
        button5.setMinHeight(50);
        button5.setMinWidth(100);
        button5.setStyle("-fx-font-size: 2em; -fx-background-color: transparent;");
        button5.setLayoutX(30);
        button5.setLayoutY(730);
        scoreB.start();

        BackgroundImage froggerback = new BackgroundImage("file:src/com/resources/background.png");
        BackgroundImage back1 = new BackgroundImage("file:src/com/resources/controls_background.png");
        BackgroundImage back2 = new BackgroundImage("file:src/com/resources/background.png");
        BackgroundImage backG = new BackgroundImage("file:src/com/resources/arcade.png", "start");

        howToPlayStage.add(back1);
        howToPlayStage.getChildren().add(button4);

        scoreB.add(back2);
        scoreB.getChildren().add(button5);

        startBackg.add(backG);
        startBackg.getChildren().addAll(button, button1, button2);

        background.add(froggerback);
        background.add(new Log("file:src/com/resources/log3.png", 150, 0, 80, 0.75));
        background.add(new Log("file:src/com/resources/log3.png", 150, 220, 80, 0.75));
        background.add(new Log("file:src/com/resources/log3.png", 150, 440, 80, 0.75));
        background.add(new Log("file:src/com/resources/logs.png", 300, 0, 200, -2));
        background.add(new Log("file:src/com/resources/logs.png", 300, 400, 200, -2));

        //made changes to the following logs to accommodate the changes of the turtles
        background.add(new Log("file:src/com/resources/log3.png", 150, 50, 315, 0.75));
        background.add(new Log("file:src/com/resources/log3.png", 150, 270, 315, 0.75));
        background.add(new Log("file:src/com/resources/log3.png", 150, 490, 315, 0.75));


        //made changes to the position of the turtles and also added more turtles to make the first level less challenging
        background.add(new Turtle(500, 100, -1, 130, 130));
        background.add(new Turtle(300, 100, -1, 130, 130));
        background.add(new Turtle(600, 100, -1, 130, 130));
        background.add(new Turtle(300, 100, -1, 130, 130));

        background.add(new WetTurtle(700, 250, -1, 130, 130));
        background.add(new WetTurtle(400, 250, -1, 130, 130));
        background.add(new WetTurtle(600, 130, -1, 130, 130));
        background.add(new WetTurtle(400, 130, -1, 130, 130));
        background.add(new WetTurtle(200, 130, -1, 130, 130));

        background.add(new End(13, 10));
        background.add(new End(141, 10));
        background.add(new End(269, 10)); //removed unnecessary calculation from here
        background.add(new End(398, 10)); //removed unnecessary calculation from here
        background.add(new End(528, 10)); //removed unnecessary calculation from here

        animal = new Animal("file:src/com/resources/froggerUp.png");
        background.add(animal);
        background.add(new Obstacle("file:src/com/resources/truck1" + "Right.png", 0, 680, 1, 120, 120));
        background.add(new Obstacle("file:src/com/resources/truck1" + "Right.png", 300, 680, 1, 120, 120));
        background.add(new Obstacle("file:src/com/resources/truck1" + "Right.png", 600, 680, 1, 120, 120));
        background.add(new Obstacle("file:src/com/resources/car1Left.png", 100, 620, -1, 50, 50));
        background.add(new Obstacle("file:src/com/resources/car1Left.png", 250, 620, -1, 50, 50));
        background.add(new Obstacle("file:src/com/resources/car1Left.png", 400, 620, -1, 50, 50));
        background.add(new Obstacle("file:src/com/resources/car1Left.png", 550, 620, -1, 50, 50));
        background.add(new Obstacle("file:src/com/resources/truck2Right.png", 0, 560, 1, 200, 200));
        background.add(new Obstacle("file:src/com/resources/truck2Right.png", 500, 560, 1, 200, 200));
        background.add(new Obstacle("file:src/com/resources/car1Left.png", 500, 435, -5, 50, 50));
        background.add(new Obstacle("file:src/com/resources/car1Left.png", 500, 500, -1, 50, 50));
        background.add(new Digit(0, 30, 520, 745));

        Button button3 = new Button("HOME");
        button3.setOnAction(e -> primaryStage.setScene(startScene));
        button3.setMinHeight(50);
        button3.setMinWidth(100);
        button3.setStyle("-fx-font-size: 2em; -fx-background-color: transparent;");
        button3.setLayoutX(30);
        button3.setLayoutY(730);
        background.getChildren().add(button3);
        background.start();

        primaryStage.setTitle("FROGGER GAME");
        primaryStage.setResizable(false);
        primaryStage.setScene(startScene);
        primaryStage.show();
        start();
    }

    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (animal.changeScore()) {
                    setNumber(animal.getPoints());
                }
                if (animal.getStop()) {
                    background.stopMusic();
                    stop();
                    background.stop();
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("You Have Won The Game!");
                    alert.setHeaderText("Your High Score: " + animal.getPoints() + "!");
                    alert.setContentText("Highest Possible Score: 800");
                    alert.show();
                }
            }
        };
    }

    public void start() {
        background.playMusic();
        createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    //For calculating the game score when in play
    public void setNumber(int n) {
        int shift = 0;
        while (n > 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            background.add(new Digit(k, 30, 520 - shift, 745));
            shift += 30;
        }
    }
}
