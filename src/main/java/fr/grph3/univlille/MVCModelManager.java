package fr.grph3.univlille;

import fr.grph3.univlille.utils.AbstractMVCModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Exalow on 26/11/2022 at 15:26
 */

public class MVCModelManager {

    private List<AbstractMVCModel> models;

    private AbstractMVCModel currentModel;

    public MVCModelManager() {
        this.models = new ArrayList<>();
    }

    public AbstractMVCModel switchModel(String title) {
        return this.currentModel = findModelByTitle(title);
    }

    public boolean subscribe(AbstractMVCModel model, String path, boolean replace) {
        if (findModelByTitle(model.getTitle()) != null && !replace) return false;
        model.loadFromFile(path);
        models.add(model);
        return true;
    }

    public boolean subscribe(AbstractMVCModel model, String path) {
        return subscribe(model, path, false);
    }

    public AbstractMVCModel findModelByTitle(String title) {
        return models.stream()
                .filter(m -> title.equals(m.getTitle()))
                .findFirst()
                .orElse(null);
    }

    public List<String> names() {
        return models.stream()
                .map(AbstractMVCModel::getTitle)
                .collect(Collectors.toList());
    }

    public AbstractMVCModel getCurrentModel() {
        return currentModel;
    }

    public List<AbstractMVCModel> getModels() {
        return models;
    }
}
