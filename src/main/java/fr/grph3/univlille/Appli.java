package fr.grph3.univlille;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Appli extends AbstractView {

	@FXML
	private Button adPoint;

	@FXML
	private Button bCategorisation;

	@FXML
	private ComboBox<?> csv;

	@FXML
	private TextField knn;

	@FXML
	private TextField robustesse;

	@FXML
	private ScatterChart<?, ?> sc;

	@FXML
	private NumberAxis xAxis;

	@FXML
	private ComboBox<?> xColumn;

	@FXML
	private NumberAxis yAxis;

	@FXML
	private ComboBox<?> yColumn;

	public Appli(Stage stage) {
		super(stage);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@Override
	public Parent loadView() {
		return loadView("fxml/maquette.fxml");
	}
}
