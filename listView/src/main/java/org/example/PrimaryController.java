package org.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class PrimaryController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private ListView<String> listView;

    private String[] food = {"pizza", "sushi", "ramen"};

    private String currentFood;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.getItems().addAll(food);

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                currentFood = listView.getSelectionModel().getSelectedItem();

                label.setText(currentFood);
            }
        });
    }

}
