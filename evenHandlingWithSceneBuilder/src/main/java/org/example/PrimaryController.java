package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

// use SceneBuilder to lay out primitives and adjust their properties
// use SceneBuilder to connect the controller to the fxml container
// define your event handlers and assign them to their corresponding objects
// inject the objects from the fxml in to the controller with FXML
// assign the object you want to act on with an fxid
// check .fxml file for correct event handler assignment and id assignment

public class PrimaryController {

    // DEPENDENCY DECLARATION

    @FXML  // FXMLLoader class will inject objects in fxml file in the controller
    private Circle myCircle; // represents the fxid of the corresponding object in SceneBuilder
    @FXML
    private AnchorPane myAnchorPane;
    private double x;
    private double y;

    // EVENT HANDLER DEFINITIONS
    public void up(ActionEvent e) {
        System.out.println("UP");
        myCircle.setCenterY(y -= 10);
    }

    public void down(ActionEvent e) {
        System.out.println("DOWN");
        myCircle.setCenterY(y += 10);
    }

    public void upAndRight(ActionEvent e) {
        System.out.println("UP AND RIGHT");
        myCircle.setCenterY(y -= 10);
        myCircle.setCenterX(x += 10);
    }

    public void downAndRight(ActionEvent e) {
        System.out.println("DOWN AND RIGHT");
        myCircle.setCenterY(y += 10);
        myCircle.setCenterX(x += 10);
    }

    public void upAndLeft(ActionEvent e) {
        System.out.println("UP AND LEFT");
        myCircle.setCenterY(y -= 10);
        myCircle.setCenterX(x -= 10);
    }

    public void downAndLeft(ActionEvent e) {
        System.out.println("DOWN AND LEFT");
        myCircle.setCenterY(y += 10);
        myCircle.setCenterX(x -= 10);
    }

    public void left(ActionEvent e) {
        System.out.println("LEFT");
        myCircle.setCenterX(x -= 10);
    }

    public void right(ActionEvent e) {
        System.out.println("RIGHT");
        myCircle.setCenterX(x += 10);
    }
}
