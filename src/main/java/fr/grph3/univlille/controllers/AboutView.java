package fr.grph3.univlille.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import fr.grph3.univlille.AbstractView;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class AboutView  extends AbstractView{

	/*
	 * CETTE VUE PERMET D'AFFICHER LES INFOS DE L'APPLI
	 * ELLE S'OUVRE VIA LE MENU DE L'APPLICATION "Help" PUIS "About" 
	 * 
	 * ELLE CONTIENT UNE ZONE DE TEXTE ET UN BOUTTON FERMER POUR FERMER LA FENETRE
	 * LE TEXTE EST DEFINI DANS LE FICHIER About.fxml DANS LE DOSSIER SRC/MAIN/RESOURCES/VIEWS
	 */

	public AboutView(Stage stage) {
		super(stage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	@FXML
	public void onClose() {
		stage.close();
	}
	
	@Override
	public Parent loadView() {
		// TODO Auto-generated method stub
		return loadView("src/main/resources/views/About.fxml");
	}

}
