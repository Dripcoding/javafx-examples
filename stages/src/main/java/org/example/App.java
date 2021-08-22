package org.example;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class App extends Application {

    public static void main(String[] args) {
        launch(args); // static method that invokes the start() method
    }

    @Override
    public void start(Stage stage) throws Exception {
        // invoked behind the scenes
            // you can create your own stage to use
//        Stage customStage = new Stage();

        // to construct a scene, a root node must be passed
            // a root node influences how individual nodes are arranged
        Group root = new Group(); // create a root node
        Scene scene = new Scene(root, Color.BLACK); // set scene with root node

        try {
            Image stageIcon = new Image("file:smallBananaIcon.png"); // must be in current working directory
            // setting various stage options
            stage.getIcons().add(stageIcon);
            stage.setScene(scene); // set the scene for the stage
            stage.setTitle("Stage Demo Program");
            stage.setWidth(400);
            stage.setHeight(400);
            stage.setResizable(false);
            stage.setX(50); // stage is set in middle of screen by default
            stage.setY(50);
            stage.setFullScreen(true);
            stage.setFullScreenExitHint("Press q to ESCAPE");
            stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));

            // end of start method
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
