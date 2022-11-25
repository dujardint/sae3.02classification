package fr.grph3.univlille;

import javafx.scene.Parent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddPointView extends AbstractView {

	public AddPointView(Stage stage) {
		super(stage);
	}

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

	@Override
	public Parent loadView() {
		return loadView("src/main/resources/views/AddPoint.fxml");
	}
}

