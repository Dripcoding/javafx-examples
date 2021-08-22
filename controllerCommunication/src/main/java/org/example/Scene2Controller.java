package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Scene2Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Label userNameValueLabel;

    public void switchToScene1(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/Scene1.fxml"));
        Parent root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void displayName(String username) {
        userNameValueLabel.setText("Hello: " + username);
    }
}
