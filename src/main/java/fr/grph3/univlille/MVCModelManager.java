package fr.grph3.univlille;

import fr.grph3.univlille.models.points.IPoint;
import fr.grph3.univlille.utils.MVCModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Exalow on 26/11/2022 at 15:26
 */

public class MVCModelManager {

    private List<MVCModel<? extends IPoint>> models;

    private MVCModel<? extends IPoint> currentModel;

    public MVCModelManager() {
        this.models = new ArrayList<>();
    }

    public void switchModel(String title) {
        this.currentModel = findModelByTitle(title);
    }

    public boolean subscribe(String title, MVCModel<? extends IPoint> model, boolean replace) {
        if (findModelByTitle(title) != null && !replace) return false;
        models.add(model);
        return true;
    }

    private MVCModel<? extends IPoint> findModelByTitle(String title) {
        return models.stream()
                .filter(m -> title.equals(m.getTitle()))
                .findFirst()
                .orElse(null);
    }

    public boolean subscribe(String title, MVCModel<? extends IPoint> model) {
        return subscribe(title, model, false);
    }

    public List<MVCModel<? extends IPoint>> getModels() {
        return models;
    }

    public MVCModel<? extends IPoint> getCurrentModel() {
        return currentModel;
    }
}
