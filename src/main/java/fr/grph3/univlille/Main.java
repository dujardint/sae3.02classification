package fr.grph3.univlille;

import fr.grph3.univlille.models.points.Iris;
import fr.grph3.univlille.utils.CSVModel;

public class Main {

    public static void main(String[] args) {
        CSVModel<Iris> model = new CSVModel<>(Iris.class, "Iris");
        model.loadFromFile("src/main/resources/iris.csv");
        System.out.println(model.getColumns().toString());
        System.out.println(model.getPoints().toString());
    	System.out.println("Salut");
    }
}
