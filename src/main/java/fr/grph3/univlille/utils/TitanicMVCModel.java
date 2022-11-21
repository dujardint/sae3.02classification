package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.columns.NumberColumn;
import fr.grph3.univlille.models.points.Titanic;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class TitanicMVCModel extends MVCModel<Titanic> {

    private NumberColumn survivedColumn;

    private NumberColumn pClassColumn;

    private NumberColumn ageColumn;

    private NumberColumn sibSpColumn;

    private NumberColumn parchColumn;

    private NumberColumn fare;

    public TitanicMVCModel() {

    }

    @Override
    public String getTitle() {
        return "Titanic";
    }

    @Override
    public void addPoint(Titanic point) {
        super.addPoint(point);
    }

    @Override
    public void loadFromFile(String path) {
        CSVUtil.loadCSVAsFile(Path.of(path), Titanic.class);
    }

    @Override
    public void loadFromString(String data) {

    }

    @Override
    public List<IColumn> getColumns() {
        return Arrays.asList();
    }

    @Override
    public IColumn defaultXCol() {
        return ageColumn;
    }

    @Override
    public IColumn defaultYCol() {
        return survivedColumn;
    }

    @Override
    public int nbColumns() {
        return 6;
    }
}
