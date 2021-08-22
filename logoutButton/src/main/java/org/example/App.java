package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();

        // clicking the application's X button circumvents the OK and Cancel buttons
        // handle clicking on the X button
        // ALT + F4 will also trigger this handler
        stage.setOnCloseRequest(event -> {
            // stops further event propagation
            event.consume(); // prevents app from closing when pressing Cancel on Alert
            logout(stage);
        });
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    public void logout(Stage stage) {
        // perform other actions before logging out
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Do you want to save before exiting?");

        // close out only when OK is clicked
        if (ButtonType.OK.equals(alert.showAndWait().get())) {
            // obtain current stage in order to close it
            System.out.println("You successfully logged out!");
            stage.close(); // closes the current stage
        }
    }
}
