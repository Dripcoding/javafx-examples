package org.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    // assign accelerator to menu item to enable keyboard shortcuts
        // shortcut text appears next to the menu item

    public void handleNew() {
        System.out.println("You selected the New menu item");
    }

    public void handleSave() {
        System.out.println("You selected the Save menu item");
    }

    public void handleAutoSave() {
        System.out.println("You selected the Auto Save menu item");
    }

    public void handleClose() {
        System.out.println("You selected the Close menu item");
        App.closeApplication();
    }
}
