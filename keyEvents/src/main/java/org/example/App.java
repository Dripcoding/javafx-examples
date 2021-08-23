package org.example;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/primary.fxml"));
        Parent root = loader.load(); // loads primary.fxml hierarchy

        PrimaryController primaryController = loader.getController(); // access properties and methods in controller class

        scene = new Scene(root, 640, 480);

        // add key event handler to the primary scene
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch(event.getCode()) {
                    case W:
                        primaryController.moveUp();
                        break;
                    case S:
                        primaryController.moveDown();
                        break;
                    case D:
                        primaryController.moveRight();
                        break;
                    case A:
                        primaryController.moveLeft();
                        break;
                    default:
                        System.out.println(event.getCode());
                        break;
                }
            }
        });

        stage.setScene(scene);
        stage.show();
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

}
