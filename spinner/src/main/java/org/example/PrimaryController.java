package org.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.SetChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class PrimaryController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private Spinner<Integer> spinner;

    private int currentValue;

    // textfield that allows a user to enter an ordered value that is part of a sequence
    // you can step through elements of a sequence

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // spinner value factory handles all aspect of spinner (state, changing value, converting text input, convert objects to readable string)
        SpinnerValueFactory<Integer> factory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);

        factory.setValue(1); // set default value
        spinner.setValueFactory(factory);

        currentValue = spinner.getValue();
        label.setText(Integer.toString(currentValue)); // set default

        spinner.valueProperty().addListener(new ChangeListener<Integer>() {

            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                currentValue = spinner.getValue();
                label.setText(Integer.toString(currentValue));
            }
        });
    }
}
