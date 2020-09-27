package start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        stage.setScene(getScene());
        stage.show();
    }

    private Scene getScene() throws IOException {
        return new Scene(getFxmlLoader().load());
    }

    private FXMLLoader getFxmlLoader() {
        String mainScene = "view";
        return new FXMLLoader(getClass().getResource("/" + mainScene + ".fxml"));
    }

    public static void main(String[] args) {
        launch();
    }
}
