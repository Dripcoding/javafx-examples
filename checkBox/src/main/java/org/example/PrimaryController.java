package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrimaryController {

    @FXML
    private CheckBox checkbox;

    @FXML
    private ImageView imageView;

    @FXML
    private Label mainLabel;

    Image image1 = new Image(getClass().getResourceAsStream("/org/example/lightbulb-off.png"));
    Image image2 = new Image(getClass().getResourceAsStream("/org/example/lightbulb-on.png"));

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    public void toggleCheckbox(ActionEvent e) {
        if(checkbox.isSelected()) {
            mainLabel.setText("ON");
            imageView.setImage(image2);
        } else {
            mainLabel.setText("OFF");
            imageView.setImage(image1);
        }
    }
}
