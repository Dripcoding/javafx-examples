package org.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class PrimaryController implements Initializable {

    @FXML
    private TreeView<String> treeView;

    // treeView is useful for showing hierarchical data (tree items)
    // order of items matters!

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // root
        TreeItem<String> rootItem = new TreeItem<>("Files");
//        TreeItem<String> rootItem = new TreeItem<>("Files", new ImageView(new Image()));

        // branches
        TreeItem<String> branchItem1 = new TreeItem<>("Pictures");
        TreeItem<String> branchItem2 = new TreeItem<>("Videos");
        TreeItem<String> branchItem3 = new TreeItem<>("Music");

        // leaves of branches
        TreeItem<String> leafItem1 = new TreeItem<>("picture1");
        TreeItem<String> leafItem2 = new TreeItem<>("picture2");
        TreeItem<String> leafItem3 = new TreeItem<>("video1");
        TreeItem<String> leafItem4 = new TreeItem<>("video2");
        TreeItem<String> leafItem5 = new TreeItem<>("music1");
        TreeItem<String> leafItem6 = new TreeItem<>("music2");

        // add leaves to branches
        branchItem1.getChildren().addAll(leafItem1, leafItem2);
        branchItem2.getChildren().addAll(leafItem4, leafItem3);
        branchItem3.getChildren().addAll(leafItem5, leafItem6);

        // add children to root
        rootItem.getChildren().addAll(branchItem1, branchItem2, branchItem3);

        treeView.setShowRoot(false); // hides the root item and just shows the children
        treeView.setRoot(rootItem);
    }

    // invoked when clicking arrows which causes NPE - we don't want these as items
    public void selectItem() {
        TreeItem<String> currentItem = treeView.getSelectionModel().getSelectedItem();

        if (currentItem != null) {
            System.out.println(currentItem.getValue());
        }

    }
}
