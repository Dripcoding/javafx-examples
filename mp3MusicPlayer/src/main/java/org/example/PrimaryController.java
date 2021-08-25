package org.example;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PrimaryController implements Initializable {

    @FXML private AnchorPane anchorPane;
    @FXML private Label songLabel;
    @FXML private ProgressBar songProgressBar;
    @FXML private Button playButton;
    @FXML private Button resetButton;
    @FXML private Button pauseButton;
    @FXML private Button previousButton;
    @FXML private Button nextButton;
    @FXML private ComboBox<String> speedComboBox;
    @FXML private Slider volumeSlider;

    private Media media;
    private MediaPlayer mediaPlayer;
    private File directory;
    private File[] files;
    private ArrayList<File> songs;
    private int songNumber;
    private int[] speeds = {25, 50, 75, 100, 125, 175, 200};
    private Timer timer;
    private TimerTask task;
    private boolean running;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        songs = new ArrayList<File>();
        directory = new File("./src/main/resources/org/example/music");
        files = directory.listFiles(); // gets all files in a given dir

        // load songs
        if (files != null) {
            for (File file : files) {
                songs.add(file);
            }
        }

        // load media objects
        media  = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);

        songLabel.setText(songs.get(songNumber).getName());

        // initialize speed selection
        for (int i = 0; i < speeds.length; i++) {
            speedComboBox.getItems().add(speeds[i] + "%");
        }

        speedComboBox.setOnAction(this::switchSpeed);

        // initialize volume slider
        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
            }
        });

        // initialize progress bar
        songProgressBar.setStyle("-fx-accent: #00FF00;");
  }

    public void play() {
        beginTimer();
        switchSpeed(null);
        mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
        mediaPlayer.play();
    }

    public void pause() {
        cancelTimer();
        mediaPlayer.pause();
    }

    public void reset() {
        songProgressBar.setProgress(0);
        mediaPlayer.stop();
    }

    public void previous() {
        if (songNumber > 0) {
            songNumber--;
            mediaPlayer.stop();

            if (running) {
                cancelTimer();
            }

        } else {
            songNumber = songs.size() - 1;

            if (running) {
                cancelTimer();
            }
        }
        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        songLabel.setText(songs.get(songNumber).getName());

        play();
    }

    public void next() {
        if (songNumber < songs.size() - 1) {
            songNumber ++;
            mediaPlayer.stop();

            if (running) {
                cancelTimer();
            }
        } else {
            songNumber = 0;

            if (running) {
                cancelTimer();
            }
        }
        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        songLabel.setText(songs.get(songNumber).getName());

        play();
    }

    public void switchSpeed(ActionEvent event) {
        if (speedComboBox.getValue() == null) {
            mediaPlayer.setRate(1);
        } else {
            mediaPlayer.setRate(Integer.parseInt(
                speedComboBox.getValue().substring(0, speedComboBox.getValue().length() - 1)) * 0.01);
        }
    }

    public void beginTimer() {
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                running = true;
                double current = mediaPlayer.getCurrentTime().toSeconds();
                double end = media.getDuration().toSeconds();
                songProgressBar.setProgress(current / end);

                if (current / end == 1) {
                    cancelTimer();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    public void cancelTimer() {
        running = false;
        timer.cancel();
    }
}
