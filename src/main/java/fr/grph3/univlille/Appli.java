package fr.grph3.univlille;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fr.grph3.univlille.models.points.Iris;
import fr.grph3.univlille.utils.CSVModel;
import fr.grph3.univlille.utils.MVCModel;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
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
	private ComboBox<String> csv;

	@FXML
	private TextField knn;

	@FXML
	private TextField robustesse;

	@FXML
	private ScatterChart<?, ?> sc;

	@FXML
	private NumberAxis xAxis;

	@FXML
	private ComboBox<String> xColumn;

	@FXML
	private NumberAxis yAxis;

	@FXML
	private ComboBox<String> yColumn;
	
	private CSVModel<Iris> model;

	public Appli(Stage stage) {
		super(stage);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@Override
	public Parent loadView() {
		return loadView("src/main/resources/views/maquette.fxml");
	}
}
