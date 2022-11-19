package main.java.fr.grph3.univlille.utils;

import main.java.fr.grph3.univlille.models.columns.IColumn;
import main.java.fr.grph3.univlille.models.columns.NumberColumn;
import main.java.fr.grph3.univlille.models.columns.StringColumn;
import main.java.fr.grph3.univlille.models.points.Iris;

import java.util.List;

public class IrisMVCModel extends MVCModel<Iris> {

    private CSVModel<Iris> loader;

    public IrisMVCModel() {
        this.loader = new CSVModel<>();
    }

    @Override
    public void init() {
        columns.add(new NumberColumn("sepalLength"));
        columns.add(new NumberColumn("sepalWidth"));
        columns.add(new NumberColumn("petalLength"));
        columns.add(new NumberColumn("petalWidth"));
        columns.add(new StringColumn("variety"));
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
    public void setPoints(List<Iris> points) {
        loader.setPoints(points);
    }

    @Override
    public void addPoint(Iris point) {
        loader.addPoint(point);
    }

    @Override
    public void addPoints(List<Iris> points) {
        loader.addPoints(points);
    }

    @Override
    public void loadFromFile(String location, Class<Iris> dataType) {
        loader.loadFromFile(location, dataType);
    }

    @Override
    public void loadFromString(String data) {
        loader.loadFromString(data);
    }

    @Override
    public IColumn defaultXCol() {
        return getColumnByName("sepalLength");
    }

    @Override
    public IColumn defaultYCol() {
        return getColumnByName("sepalLength");
    }

    @Override
    public int nbColumns() {
        return columns.size();
    }
}
