package fr.grph3.univlille;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
    	Application.launch(args);
    }
    
    public void start(Stage stage) throws Exception {
        Appli app = new Appli(stage);
        stage.setScene(new Scene(app.loadView()));
    	stage.show();
    }
}
