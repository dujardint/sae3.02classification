package fr.grph3.univlille;
import java.io.IOException;

import fr.grph3.univlille.models.points.Iris;
import fr.grph3.univlille.utils.CSVModel;
import fr.grph3.univlille.utils.MVCModel;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class Appli extends AbstractView{

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

	public Appli() {
		super();
		this.model = new CSVModel<Iris>(Iris.class, "Iris");
		model.loadFromFile("src/main/resources/iris.csv");
		
		xColumn.get
		BorderPane b;
		try {
			b = initFxml("fxml/maquette.fxml");
			Scene scene = new Scene(b);
			
			adPoint.setOnAction( e -> new ViewPoint());
			
			creerColumn();
			addPoint();
			
			stage.setScene(scene);
			stage.setTitle("FXML demo");
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void creerColumn() {
		//xColumn.addIte

		
	}

	private void addPoint() {
		XYChart.Series series1 = new XYChart.Series();
        series1.setName("Equities");
        series1.getData().add(new XYChart.Data(4.2, 193.2));
        series1.getData().add(new XYChart.Data(2.8, 33.6));
        series1.getData().add(new XYChart.Data(6.2, 24.8));
        series1.getData().add(new XYChart.Data(1, 14));
        series1.getData().add(new XYChart.Data(1.2, 26.4));
        series1.getData().add(new XYChart.Data(4.4, 114.4));
        series1.getData().add(new XYChart.Data(8.5, 323));
        series1.getData().add(new XYChart.Data(6.9, 289.8));
        series1.getData().add(new XYChart.Data(9.9, 287.1));
        series1.getData().add(new XYChart.Data(0.9, -9));
        series1.getData().add(new XYChart.Data(3.2, 150.8));
        series1.getData().add(new XYChart.Data(4.8, 20.8));
        series1.getData().add(new XYChart.Data(7.3, -42.3));
        series1.getData().add(new XYChart.Data(1.8, 81.4));
        series1.getData().add(new XYChart.Data(7.3, 110.3));
        series1.getData().add(new XYChart.Data(2.7, 41.2));
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Mutual funds");
        series2.getData().add(new XYChart.Data(5.2, 229.2));
        series2.getData().add(new XYChart.Data(2.4, 37.6));
        series2.getData().add(new XYChart.Data(3.2, 49.8));
        series2.getData().add(new XYChart.Data(1.8, 134));
        series2.getData().add(new XYChart.Data(3.2, 236.2));
        series2.getData().add(new XYChart.Data(7.4, 114.1));
        series2.getData().add(new XYChart.Data(3.5, 323));
        series2.getData().add(new XYChart.Data(9.3, 29.9));
        series2.getData().add(new XYChart.Data(8.1, 287.4));
 
        sc.getData().addAll(series1, series2);
		
	}

//	public void init() {

//	}

}
