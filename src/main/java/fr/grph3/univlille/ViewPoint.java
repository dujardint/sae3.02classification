package fr.grph3.univlille;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ViewPoint extends AbstractView{
    
	public ViewPoint() {
		super();

		try {
			BorderPane b = initFxml("fxml/ajouterpoint.fxml");
	        Scene scene = new Scene(b);
	        stage.setScene(scene);
	        stage.setTitle("FXML demo");
	        stage.show();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
    public BorderPane initFxml(String path)throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setController(this);
        FileInputStream fxmlStream = new FileInputStream(path);
        return (BorderPane) loader.load(fxmlStream);
    }

}

