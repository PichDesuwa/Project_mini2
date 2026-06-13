import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

public class controller {

    @FXML
    private Button bt1;

    @FXML
    private ChoiceBox<String> cb1;

    @FXML
    private ChoiceBox<String> cb2;

    @FXML
    private ChoiceBox<String> cb3;

    @FXML
    private Label clock;

    @FXML
    private Label label_result;

    private int timeLeft = 120;
    private Timeline timer;

    @FXML
    void on_button(ActionEvent event) {
        // Check if cb1 = static, cb2 = String[], cb3 = System
        if (cb1.getValue() != null && cb2.getValue() != null && cb3.getValue() != null) {
            if (cb1.getValue().equals("static") && 
                cb2.getValue().equals("String[]") && 
                cb3.getValue().equals("System")) {
                label_result.setText("Correct");
            } else {
                label_result.setText("Incorrect");
            }
        }
    }

    @FXML
    void initialize() {
        // Initialize comboboxes with choices
        cb1.getItems().addAll("static", "String[]", "System");
        cb2.getItems().addAll("static", "String[]", "System");
        cb3.getItems().addAll("static", "String[]", "System");

        // Initialize countdown timer
        startCountdown();
    }

    private void startCountdown() {
        timeLeft = 120;
        if (timer != null) {
            timer.stop();
        }
        
        timer = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            timeLeft--;
            clock.setText(timeLeft + "s");
            
            // Auto submit when time reaches 0
            if (timeLeft <= 0) {
                timer.stop();
                on_button(null);
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

}
