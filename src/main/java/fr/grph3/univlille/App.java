package fr.grph3.univlille;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Panel app = new Panel(stage);
        stage.setScene(new Scene(app.loadView()));
        stage.show();
    }
}
