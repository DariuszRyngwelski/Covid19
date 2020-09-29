package start;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import start.infoLine.DateTime;
import start.infoLine.InfoLine;
import thread.RefreshApi;

public class Controller {
    @FXML
    private Label myLabelInfoTime;
    @FXML
    private Label myLabelInfoDate;

    public void initialize() {
        infoLineRefreshDateTime();

        RefreshApi.countryList();
    }

    private void infoLineRefreshDateTime() {
        Thread refreshFormDateTime = new Thread(() -> {
            InfoLine info = new DateTime();
            for (;;) {
                if (info.stepSecond()) {
                    refreshTime(info.time());
                    if (info.stepDay()) {
                        refreshDate(info.date());
                    }
                }
                info.refresh();
            }
        });
        refreshFormDateTime.start();
    }

    private void refreshDate(String string) {
        Platform.runLater(() -> myLabelInfoDate.setText(string));
    }

    private void refreshTime(String string) {
        Platform.runLater(() -> myLabelInfoTime.setText(string));
    }
}
