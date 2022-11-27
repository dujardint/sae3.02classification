package fr.grph3.univlille.controllers;

import fr.grph3.univlille.AbstractView;
import fr.grph3.univlille.controllers.PanelView;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddPointTitanicView extends AbstractView {

	@FXML
	private Spinner<Double> xPointSpinner;

	@FXML
	private Spinner<Double> yPointSpinner;

	private PanelView panelView;

	public AddPointTitanicView(Stage stage, PanelView panelView) {
		super(stage);
		this.panelView = panelView;
	}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
		xPointSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 1.0, 0.0, 0.1));
		yPointSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 1.0, 0.0, 0.1));
    }

	@FXML
	public void onClose() {
		stage.close();
	}

	@FXML
	public void onAddPoint() {
		panelView.addPoint(xPointSpinner.getValue(), yPointSpinner.getValue());
	}

	@Override
	public Parent loadView() {
		return loadView("src/main/resources/views/AddPointIris.fxml");
	}
}

