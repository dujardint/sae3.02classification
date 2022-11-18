package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.columns.NumberColumn;
import fr.grph3.univlille.models.points.Titanic;

import java.util.List;

public class TitanicMVCModel extends MVCModel<Titanic> {

    private CSVModel<Titanic> loader;

    private List<Titanic> points;

    public TitanicMVCModel() {
        this.loader = new CSVModel<>();
    }

    @Override
    public void init() {
        columns.add(new NumberColumn("survived"));
        columns.add(new NumberColumn("Pclass"));
        columns.add(new NumberColumn("sibSp"));
        columns.add(new NumberColumn("parch"));
        columns.add(new NumberColumn("fare"));
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
    public IColumn defaultXCol() {
        return getColumnByName("survived");
    }

    @Override
    public IColumn defaultYCol() {
        return getColumnByName("Pclass");
    }

    @Override
    public int nbColumns() {
        return columns.size();
    }
}
