package org.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    public void moveUp() {
        System.out.println("MOVING UP");
    }

    public void moveLeft() {
        System.out.println("MOVING LEFT");
    }

    public void moveRight() {
        System.out.println("MOVING RIGHT");
    }

    public void moveDown() {
        System.out.println("MOVING DOWN");
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
