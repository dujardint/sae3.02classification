package fr.grph3.univlille;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
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

	public Appli() {
		super();
		
		BorderPane b;
		try {
			b = initFxml("fxml/maquette.fxml");
			Scene scene = new Scene(b);
			
			adPoint.setOnAction( e -> new ViewPoint());
		
			stage.setScene(scene);
			stage.setTitle("FXML demo");
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public void init() {

//	}

}
