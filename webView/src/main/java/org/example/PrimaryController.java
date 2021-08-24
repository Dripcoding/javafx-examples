package org.example;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.AccessibleAction;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

public class PrimaryController implements Initializable {

    @FXML
    private TextField textField;

    @FXML
    private WebView webView;

    private WebEngine webEngine;

    private WebHistory webHistory;

    private String homePage;

    private double zoomLevel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        webEngine = webView.getEngine();
        homePage = "www.google.com";
        textField.setText(homePage);
        zoomLevel = 1; // 100% zoom
        load();
    }

    public void load() {
        webEngine.load("http://" + textField.getText());
    }

    public void refresh() {
        webEngine.reload();
    }

    public void zoomIn() {
        zoomLevel += 0.25;
        webView.setZoom(zoomLevel);
    }

    public void zoomOut() {
        zoomLevel -= 0.25;
        webView.setZoom(zoomLevel);
    }

    public void displayHistory() {
        webHistory = webEngine.getHistory();
        ObservableList<WebHistory.Entry> entries = webHistory.getEntries();

        for(WebHistory.Entry entry : entries) {
            System.out.println(entry.getUrl() + " " + entry.getLastVisitedDate());
        }
    }

    public void goBack() {
        webHistory = webEngine.getHistory();
        ObservableList<WebHistory.Entry> entries = webHistory.getEntries();

        webHistory.go(-1);

        textField.setText(entries.get(webHistory.getCurrentIndex()).getUrl());
    }

    public void goForward() {
        webHistory = webEngine.getHistory();
        ObservableList<WebHistory.Entry> entries = webHistory.getEntries();

        webHistory.go(1);

        textField.setText(entries.get(webHistory.getCurrentIndex()).getUrl());
    }

    public void executeJs() {
        webEngine.executeScript("window.location = \"https://www.youtube.com\";");
        textField.setText(webEngine.executeScript("window.location.href").toString());
    }
}
