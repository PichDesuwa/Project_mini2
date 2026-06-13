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
        int correctCount = 0;
        
        // Check each answer
        if (cb1.getValue() != null && cb1.getValue().equals("static")) {
            correctCount++;
        }
        if (cb2.getValue() != null && cb2.getValue().equals("String[]")) {
            correctCount++;
        }
        if (cb3.getValue() != null && cb3.getValue().equals("System")) {
            correctCount++;
        }
        
        // Display result
        label_result.setText(correctCount + "/3 correct");
    }

    @FXML
    void initialize() {
        cb1.getItems().addAll("static", "String[]", "System");
        cb2.getItems().addAll("static", "String[]", "System");
        cb3.getItems().addAll("static", "String[]", "System");

        startCountdown();
    }

    private void startCountdown() {
        timeLeft = 120;
        
        timer = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            timeLeft--;
            clock.setText(timeLeft + "s");
            
            if (timeLeft <= 0) {
                timer.stop();
                on_button(null);
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

}
