package fr.grph3.univlille;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;

public abstract class AbstractView implements Initializable {
	
	protected Stage stage;

	protected Parent node;

	public AbstractView(Stage stage) {
		this.stage = stage;
	}

	public abstract Parent loadView();

	protected Parent loadView(String path) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
			loader.setController(this);
			return loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Parent getNode() {
		return node;
	}

	public Stage getStage() {
		return stage;
	}
}
