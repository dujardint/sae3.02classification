package fr.grph3.univlille.controllers;

import fr.grph3.univlille.AbstractView;
import fr.grph3.univlille.controllers.PanelView;
import fr.grph3.univlille.models.points.Titanic;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddPointTitanicView extends AbstractView {


	@FXML
	private Spinner<Double> passengerId;

	@FXML
	private Spinner<Double> survived;

	@FXML
	private Spinner<Double> pClass;

	@FXML
	private TextField name;

	@FXML
	private TextField sex;

	@FXML
	private Spinner<Double> age;

	@FXML
	private Spinner<Double> sibSp;

	@FXML
	private Spinner<Double> parch;

	@FXML
	private TextField ticket;

	@FXML
	private Spinner<Double> fare;

	@FXML
	private TextField cabin;

	@FXML
	private Label confirmationAdd;

	private PanelView panelView;

	public AddPointTitanicView(Stage stage, PanelView panelView) {
		super(stage);
		this.panelView = panelView;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		passengerId.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 1000.0, 0.0, 1.0));
		survived.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 1.0, 0.0, 1.0));
		pClass.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 3.0, 0.0, 3.0));


		age.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(1.0, 100.0, 0.0, 1.0));
		sibSp.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 10.0, 0.0, 1.0));
		parch.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 10.0, 0.0, 1.0));


		fare.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 1000.0, 0.0, 0.1));
	}

	@FXML
	public void onClose() {
		stage.close();
	}

	@FXML
	public void onAddPoint() {
		//panelView.addPoint(xPointSpinner.getValue(), yPointSpinner.getValue());
		
		Titanic titanic = new Titanic();
		titanic.setPassengerId(passengerId.getValue());
		titanic.setSurvived(survived.getValue());
		titanic.setPClass(pClass.getValue());
		titanic.setName(name.getText());
		titanic.setSex(sex.getText());
		titanic.setAge(age.getValue());
		titanic.setSibSp(sibSp.getValue());
		titanic.setParch(parch.getValue());
		titanic.setTicket(ticket.getText());
		titanic.setFare(fare.getValue());
		titanic.setCabin(cabin.getText());
		
		
		System.out.println("new : " + titanic.toString());
		
		confirmationAdd.setText("passagé ajouté !");
		
		//titanic est ajouté a la liste des points du modele et le modèle se redessine
	panelView.getModel().addPoint(titanic);
		
		
	}

	@Override
	public Parent loadView() {
		return loadView("src/main/resources/views/AddPointTitanic.fxml");
	}
}

