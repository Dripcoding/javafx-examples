package org.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class PrimaryController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private ChoiceBox<String> choiceBox;

    private String[] choices = {"pizza", "sushi", "ramen"};

    // scene builder doesn't allow you to set data in choicebox and set onAction method

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // this method invoked behind the scenes to intialize the controller after its root node has been added
        // add data for our choice box
        choiceBox.getItems().addAll(choices);
        // assign event handler for our choice box
        choiceBox.setOnAction(this::getFood);
    }

    public void getFood(ActionEvent e) {
        String food = choiceBox.getValue();
        label.setText(food);
    }
}
