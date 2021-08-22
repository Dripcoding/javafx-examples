package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private Label welcomeLabel;

    @FXML
    private TextField ageInputField;

    @FXML
    private Button submitButton;

    private int age;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    public void submit(ActionEvent e) {
        try {

            int age = Integer.parseInt(ageInputField.getText());
            System.out.println("Age is " + age);

            if (age >= 18) {
                welcomeLabel.setText("You are now signed up");
            } else {
                welcomeLabel.setText("You must be 18+");
            }

        } catch (NumberFormatException numberFormatException) {
            System.out.println("Enter numbers only");
            welcomeLabel.setText("Enter numbers only please");
        } catch (Exception exception) {
            exception.printStackTrace();
            welcomeLabel.setText("Error");
        }
    }
}
