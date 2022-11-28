package fr.grph3.univlille;

import fr.grph3.univlille.utils.MVCModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Exalow on 26/11/2022 at 15:26
 */

public class MVCModelManager {

    private List<MVCModel> models;

    private MVCModel currentModel;

    public MVCModelManager() {
        this.models = new ArrayList<>();
    }

    public MVCModel switchModel(String title) {
        return this.currentModel = findModelByTitle(title);
    }

    public boolean subscribe(MVCModel model, String path, boolean replace) {
        if (findModelByTitle(model.getTitle()) != null && !replace) return false;
        model.loadFromFile(path);
        models.add(model);
        return true;
    }

    public boolean subscribe(MVCModel model, String path) {
        return subscribe(model, path, false);
    }

    private MVCModel findModelByTitle(String title) {
        return models.stream()
                .filter(m -> title.equals(m.getTitle()))
                .findFirst()
                .orElse(null);
    }

    public List<String> names() {
        return models.stream()
                .map(MVCModel::getTitle)
                .collect(Collectors.toList());
    }

    public MVCModel getCurrentModel() {
        return currentModel;
    }

    public List<MVCModel> getModels() {
        return models;
    }
}
