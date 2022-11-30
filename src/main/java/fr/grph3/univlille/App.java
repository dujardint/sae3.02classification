package fr.grph3.univlille;

import fr.grph3.univlille.controllers.PanelView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        PanelView app = new PanelView(stage);
        stage.setTitle("Classification");
        stage.getIcons().add(new Image("img/app-icon.png"));
        stage.setScene(new Scene(app.loadView()));
        stage.show();
    }
}
