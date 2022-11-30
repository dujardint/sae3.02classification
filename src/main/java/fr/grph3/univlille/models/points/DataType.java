package fr.grph3.univlille.models.points;

import fr.grph3.univlille.utils.CSVModel;
import fr.grph3.univlille.utils.parsers.IIrisParser;
import fr.grph3.univlille.utils.parsers.ITitanicParser;

public enum DataType {

    IRIS(new CSVModel(Iris.class, "Iris", new IIrisParser())), TITANIC(new CSVModel(Titanic.class, "Titanic", new ITitanicParser()));

    private final CSVModel model;

    DataType(CSVModel model) {
        this.model = model;
    }

    public CSVModel getModel() {
        return model;
    }
}
