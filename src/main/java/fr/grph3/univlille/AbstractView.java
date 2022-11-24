package fr.grph3.univlille;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public abstract class AbstractView extends Stage{
	
	protected Stage stage ;
	
	public AbstractView() {
		stage = new Stage();
	}
	
	
	public BorderPane initFxml(String path)throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setController(this);
		FileInputStream fxmlStream = new FileInputStream(path);
		return (BorderPane) loader.load(fxmlStream);
	}
}
