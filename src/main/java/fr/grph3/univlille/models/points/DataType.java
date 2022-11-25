package fr.grph3.univlille.models.points;

import fr.grph3.univlille.utils.CSVModel;
import fr.grph3.univlille.utils.MVCModel;

public enum DataType {

    IRIS(new CSVModel<>(Iris.class, "Iris")), TITANIC(new CSVModel<>(Titanic.class, "Titanic"));

    private final MVCModel<? extends IPoint> model;

    DataType(MVCModel<?> model) {
        this.model = model;
    }

    public MVCModel<? extends IPoint> getModel() {
        return model;
    }
}
