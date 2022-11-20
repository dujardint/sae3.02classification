package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.columns.NumberColumn;
import fr.grph3.univlille.models.points.Titanic;

import java.util.Arrays;
import java.util.List;

public class TitanicMVCModel extends MVCModel<Titanic> {

    private CSVModel<Titanic> loader;

    private List<Titanic> points;

    public TitanicMVCModel() {
        this.loader = new CSVModel<>();
    }

    @Override
    public String getTitle() {
        return loader.getTitle();
    }

    @Override
    public int getTotalPoints() {
        return loader.getTotalPoints();
    }

    @Override
    public void setPoints(List<Titanic> points) {
        loader.setPoints(points);
    }

    @Override
    public void addPoint(Titanic point) {
        loader.addPoint(point);
    }

    @Override
    public void addPoints(List<Titanic> points) {
        loader.addPoints(points);
    }

    @Override
    public void loadFromFile(String location, Class<Titanic> dataType) {
        loader.loadFromFile(location, dataType);
    }

    @Override
    public void loadFromString(String data) {
        loader.loadFromString(data);
    }

    @Override
    public List<IColumn> getColumns() {
        return Arrays.asList();
    }

    @Override
    public IColumn defaultXCol() {
        return null;
    }

    @Override
    public IColumn defaultYCol() {
        return null;
    }

    @Override
    public int nbColumns() {
        return 0;
    }
}
