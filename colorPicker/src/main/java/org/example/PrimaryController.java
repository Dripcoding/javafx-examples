package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class PrimaryController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ColorPicker colorPicker;

    public void changeColor(ActionEvent e) {
        Color color = colorPicker.getValue();
        System.out.println(color);
        anchorPane.setBackground(new Background(new BackgroundFill(color, null, null)));
    }
}
