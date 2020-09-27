package start;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import start.infoLine.DateTime;
import start.infoLine.InfoLine;

public class Controller {
    @FXML
    private Label myLabelInfoTime;
    @FXML
    private Label myLabelInfoDate;

    public void initialize() {
        infoLineRefreshDateTime();
    }

    private void infoLineRefreshDateTime() {
        Thread refreshFormDateTime = new Thread(() -> {
            InfoLine info = new DateTime();
            while (true) {
                if (info.stepSecond()) {
                    Platform.runLater(() -> myLabelInfoTime.setText(info.time()));
                    if (info.stepDay()) {
                        Platform.runLater(() -> myLabelInfoDate.setText(info.date()));
                    }
                }
                info.refresh();
            }
        });
        refreshFormDateTime.start();
    }
}
