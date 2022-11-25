package fr.grph3.univlille;

import javafx.scene.Parent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewPoint extends AbstractView {

	public ViewPoint(Stage stage) {
		super(stage);
	}

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

	@Override
	public Parent loadView() {
		return loadView("views/AddPoint.fxml");
	}
}

