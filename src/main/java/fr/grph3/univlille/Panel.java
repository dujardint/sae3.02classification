package fr.grph3.univlille;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import fr.grph3.univlille.models.points.Iris;
import fr.grph3.univlille.utils.CSVModel;
import fr.grph3.univlille.utils.ResourceUtil;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Panel extends AbstractView {

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
	private ScatterChart<Number, Number> chart;

	@FXML
	private NumberAxis xAxis;

	@FXML
	private NumberAxis yAxis;

	@FXML
	private ComboBox<String> xColumnSelector;

	@FXML
	private ComboBox<String> yColumnSelector;
	
	private CSVModel<Iris> model;

	public Panel(Stage stage) {
		super(stage);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.model = new CSVModel<>(Iris.class, "Iris");
		this.model.loadFromFile("src/main/resources/iris.csv");
	}

	@Override
	public Parent loadView() {
		return loadView("src/main/resources/views/Panel.fxml");
	}
}
