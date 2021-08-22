package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class PrimaryController {

    @FXML
    private Label foodLabel;

    @FXML
    private RadioButton radioButton1;

    @FXML
    private RadioButton radioButton2;

    @FXML
    private RadioButton radioButton3;

    public void getFood(ActionEvent e) {
        // check which button selected
        if (radioButton1.isSelected()) {
            foodLabel.setText(radioButton1.getText());
        } else if (radioButton2.isSelected()) {
            foodLabel.setText(radioButton2.getText());
        } else {
            foodLabel.setText(radioButton3.getText());
        }
    }
}
