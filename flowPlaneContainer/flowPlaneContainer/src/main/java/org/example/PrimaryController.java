package org.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    // flow planes are analgous to flex-containers
        // can be oriented horizontally and vertically using the Alignment property in SceneBuilder
        // add spacing between nodes using Hgap and Vgap in Layout

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
