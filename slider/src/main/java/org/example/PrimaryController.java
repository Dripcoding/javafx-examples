package org.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class PrimaryController implements Initializable {

    @FXML
    private Slider verticalSlider;

    @FXML
    private Label label;

    int temperature;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // assign label with a default value
        temperature = (int) verticalSlider.getValue();
        label.setText(Integer.toString(temperature).concat("C"));

        // assign change listener to slider
        verticalSlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                temperature = (int) verticalSlider.getValue();
                label.setText(Integer.toString(temperature).concat("C"));
            }
        });
    }
}
