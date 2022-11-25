package fr.grph3.univlille;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        PanelView app = new PanelView(stage);
        stage.setScene(new Scene(app.loadView()));
        stage.show();
    }
}
