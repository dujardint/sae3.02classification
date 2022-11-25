package fr.grph3.univlille;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.points.DataType;
import fr.grph3.univlille.models.points.Iris;
import fr.grph3.univlille.utils.CSVModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
	private ComboBox<DataType> csvPicker;

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
	private ComboBox<String> xColumnPicker;

	@FXML
	private ComboBox<String> yColumnPicker;
	
	private CSVModel<Iris> model;

	public Panel(Stage stage) {
		super(stage);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.model = new CSVModel<>(Iris.class, "Iris");
		this.model.loadFromFile("src/main/resources/iris.csv");
		XYChart.Series<Number, Number> x = new XYChart.Series<>();
		XYChart.Series<Number, Number> y = new XYChart.Series<>();
		x.setName("X Axis: " + model.defaultXCol().getName());
		y.setName("Y Axis: " + model.defaultYCol().getName());
		chart.getData().add(x);
		chart.getData().add(y);
		csvPicker.getSelectionModel().select(DataType.IRIS);
		csvPicker.setItems(FXCollections.observableArrayList(DataType.values()));
		xColumnPicker.getSelectionModel().select(model.defaultXCol().getName());
		yColumnPicker.getSelectionModel().select(model.defaultYCol().getName());
		xColumnPicker.setItems(FXCollections.observableList(model.getNormalizableColumns().stream().map(IColumn::getName).collect(Collectors.toList())));
		yColumnPicker.setItems(FXCollections.observableList(model.getNormalizableColumns().stream().map(IColumn::getName).collect(Collectors.toList())));
	}

	@Override
	public Parent loadView() {
		return loadView("src/main/resources/views/Panel.fxml");
	}

	@FXML
	public void onAddPoint() {
		Stage adpStag = new Stage();
		ViewPoint addPointView = new ViewPoint(stage);
		stage.setScene(new Scene(addPointView.loadView()));
		stage.show();
	}
}
