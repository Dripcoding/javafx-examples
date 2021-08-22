package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrimaryController {

    // Image - image you want to show
    // ImageView - container for the Image object, node for painting images

    @FXML
    private ImageView scene1ImageView;

    @FXML
    private Button scene2Button;

    private Image image = new Image(getClass().getResourceAsStream("/org/example/cat2.png"));
    private Image image2 = new Image(getClass().getResourceAsStream("/org/example/cat1.png"));

    public void switchToScene2(ActionEvent e) {
        displayImage1();
    }

    public void displayImage1() {
        scene1ImageView.setImage(image);
    }

    public void displayImage2() {
        scene1ImageView.setImage(image2);
    }
}
