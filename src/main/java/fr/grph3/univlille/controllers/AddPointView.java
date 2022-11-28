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

public class AddPointView extends AbstractView {

	@FXML
	private Spinner<Double> xPointSpinner;

	@FXML
	private Spinner<Double> yPointSpinner;

	private PanelView panelView;

	public AddPointView(Stage stage, PanelView panelView) {
		super(stage);
		this.panelView = panelView;
	}

	/**
	 * Pour toutes les colonnes passés en parametre, ajouter sois un spinner sois un text field ou une checkbox en définissant
	 * un id avec setId correspondant au nom de la colonne à une
	 * VBox qui est à ajouter sur la vue et ajouté avec @FXML dans le controlleur
	 */

	@Override
    public void initialize(URL location, ResourceBundle resources) {
		xPointSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 1.0, 0.0, 0.1));
		yPointSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 1.0, 0.0, 0.1));
    }

	@FXML
	public void onClose() {
		stage.close();
	}

	/**
	 * Utiliser le String du parser pour chaque enfant de la VBox en récupérant l'id qui s'obtient avec getParser du MVCModel et remplacer chaque
	 * ${id_enfant} par la getValue de cet enfant
	 */

	@FXML
	public void onAddPoint() {
		panelView.addPoint(xPointSpinner.getValue(), yPointSpinner.getValue());
	}

	@Override
	public Parent loadView() {
		return loadView("src/main/resources/views/AddPoint.fxml");
	}
}

