package fr.grph3.univlille;

import fr.grph3.univlille.models.points.Iris;
import fr.grph3.univlille.utils.CSVModel;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) {
    	Application.launch(args);
    }
    
    public void start(Stage stage) throws Exception{
    	new Appli();
    }
}
