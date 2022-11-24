package fr.grph3.univlille;

import java.io.FileInputStream;
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
		FileInputStream fxmlStream = null;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setController(this);
			fxmlStream = new FileInputStream(path);
			return loader.load(fxmlStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public Parent getNode() {
		return node;
	}

	public Stage getStage() {
		return stage;
	}
}
