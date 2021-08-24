package org.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class PrimaryController implements Initializable {

    @FXML
    private ImageView imageView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // translate
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(imageView);

        translate.setDuration(Duration.millis(1000)); // total duration of animation
//        translate.setCycleCount(2); // number of animation cycles
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setAutoReverse(true); // animates forwards and backwards
        translate.setByX(250);
        translate.setByY(-250);

//        translate.play(); // triggers the translation

        // rotate
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(imageView);
        rotate.setDuration(Duration.millis(500));
        rotate.setCycleCount(RotateTransition.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setByAngle(360);
//        rotate.setAxis(Rotate.X_AXIS); // rotates on x-axi
//        rotate.setAxis(Rotate.Y_AXIS);
        rotate.setAxis(Rotate.Z_AXIS); // default

//        rotate.play();

        // fade
        FadeTransition fade = new FadeTransition();
        fade.setNode(imageView);
        fade.setDuration(Duration.millis(1000));
        fade.setCycleCount(FadeTransition.INDEFINITE);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(1); // original opacity value
        fade.setToValue(0); // ending opacity value

        fade.play();

        // scale
        ScaleTransition scale = new ScaleTransition();
        scale.setNode(imageView);
        scale.setNode(imageView);
        scale.setDuration(Duration.millis(1000));
        scale.setCycleCount(ScaleTransition.INDEFINITE);
        scale.setInterpolator(Interpolator.LINEAR);
        scale.setByX(2.0); // scales twice on x axis
        scale.setByY(1.5); // scales on y axis

        scale.play();
    }
}
