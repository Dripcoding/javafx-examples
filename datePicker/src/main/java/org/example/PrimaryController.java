package org.example;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class PrimaryController {

    @FXML
    private Label dateLabel;

    @FXML
    private DatePicker datePicker;

    public void getDate(ActionEvent e) {
        // get value of date picker
        LocalDate myDate = datePicker.getValue();

        // default formatting is YYYY-MM-DD
        // we can change the default to MM-DD-YYYY
        String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

        dateLabel.setText(myFormattedDate);
    }
}
