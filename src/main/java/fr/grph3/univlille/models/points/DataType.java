package fr.grph3.univlille.models.points;

import fr.grph3.univlille.utils.CSVModel;

public enum DataType {

    IRIS(new CSVModel(Iris.class, "Iris")), TITANIC(new CSVModel(Titanic.class, "Titanic"));

    private final CSVModel model;

    DataType(CSVModel model) {
        this.model = model;
    }

    public CSVModel getModel() {
        return model;
    }
}
