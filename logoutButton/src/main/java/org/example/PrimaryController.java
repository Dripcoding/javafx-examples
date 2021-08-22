package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PrimaryController {

    private Stage stage;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private Button logoutButton;

    public void logout(ActionEvent e) {
        // perform other actions before logging out
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Do you want to save before exiting?");

        // close out only when OK is clicked
        if (ButtonType.OK.equals(alert.showAndWait().get())) {
            // obtain current stage in order to close it
            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("You successfully logged out!");
            stage.close(); // closes the current stage
        }
    }
}
