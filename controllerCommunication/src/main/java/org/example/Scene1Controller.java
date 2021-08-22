package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Scene1Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    TextField userNameInput; // injects the userNameInput object

    public void switchToScene2(ActionEvent event) throws IOException {
        String userName = userNameInput.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/Scene2.fxml"));
        Parent root = loader.load();

        Scene2Controller scene2Controller = loader.getController();
        scene2Controller.displayName(userName);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
