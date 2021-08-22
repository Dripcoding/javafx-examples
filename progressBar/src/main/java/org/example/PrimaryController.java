package org.example;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class PrimaryController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Button button;

    // BigDecimal gives us complete control over rounding behavior
    BigDecimal progressValue = new BigDecimal(String.format("%.2f", 0.0));

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        progressBar.setStyle("-fx-accent: red;"); // pass in css properties as string
    }

    public void increaseProgress(ActionEvent e) {

        if (progressValue.doubleValue() < 1) {
            progressValue = new BigDecimal(String.format("%.2f", progressValue.doubleValue() + 0.1));
            System.out.println(progressValue.doubleValue());
            progressBar.setProgress(progressValue.doubleValue());
            label.setText(Integer.toString((int) Math.round(progressValue.doubleValue() * 100)).concat("%"));
        }
    }
}
