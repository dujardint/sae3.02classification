package fr.grph3.univlille.controllers;

import fr.grph3.univlille.AbstractView;
import fr.grph3.univlille.controllers.PanelView;
import fr.grph3.univlille.models.points.Iris;
import fr.grph3.univlille.models.points.builders.IrisBuilder;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddPointIrisView extends AbstractView {

	@FXML
	private Spinner<Double> sepalLength;
	
	@FXML
	private Spinner<Double> sepalWidth;
	
	@FXML
	private Spinner<Double> petalWidth;
	
	@FXML
	private Spinner<Double> petalLength;

	
	@FXML
	private Label confirmationAdd;
	

	private PanelView panelView;

	public AddPointIrisView(Stage stage, PanelView panelView) {
		super(stage);
		this.panelView = panelView;
	}

    @Override
    public void initialize(URL location, ResourceBundle resources) { //recuperer min, max de la colonne
    	
//    	double a = panelView.getModel().getNormalizableColumns().get(0).getMin();
//    	System.out.println(a);
    	
    	sepalLength.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 10.0, 0.0, 0.1));
    	sepalWidth.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 10.0, 0.0, 0.1));
    	petalWidth.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 10.0, 0.0, 0.1));
    	petalLength.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 10.0, 0.0, 0.1));
    	
    	
    	//System.out.println(panelView.getModel().getNormalizableColumns().get(0).getMax());
    	
    	
    }

	@FXML
	public void onClose() {
		stage.close();
	}

	@FXML
	public void onAddPoint() {
		
			Iris iris = new Iris();
			
			iris.setSepalLength(sepalLength.getValue());
			iris.setSepalWidth(sepalWidth.getValue());
			iris.setPetalLength(petalLength.getValue());
			iris.setPetalWidth(petalLength.getValue());
			
			//	sepalLength.getValue(), sepalWidth.getValue(), petalWidth.getValue(),petalLength.getValue());
			System.out.println("new : " + iris.toString());
			
			confirmationAdd.setText("iris ajouté !");
			
			
			
			//iris.setCategory();
			
			//confirmationAjout.setText("new : " + iris.toString());
			
			//l'iris est ajouté a la liste des points du modele et le modèle se redessine
		panelView.getModel().addPoint(iris);
			
	}

	@Override
	public Parent loadView() {
		return loadView("src/main/resources/views/AddPointIris.fxml");
	}
}

