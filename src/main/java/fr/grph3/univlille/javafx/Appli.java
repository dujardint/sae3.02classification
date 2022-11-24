package main.java.fr.grph3.univlille.javafx;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Appli extends Application{
    public void start(Stage stage) throws IOException {
        
        BorderPane b = initFxml("fxml/maquette.fxml");

        Scene scene = new Scene(b);
        stage.setScene(scene);
        stage.setTitle("FXML demo");
        stage.show();
    }
    
    public BorderPane initFxml(String path)throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setController(this);
        FileInputStream fxmlStream = new FileInputStream(path);
        return (BorderPane) loader.load(fxmlStream);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}