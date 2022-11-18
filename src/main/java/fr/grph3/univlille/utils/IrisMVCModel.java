package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.points.Iris;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IrisMVCModel extends MVCModel<Iris> {

    private CSVLoader<Iris> loader;

    private List<Iris> points;

    public IrisMVCModel() {
        this.loader = new CSVLoader<>();
        this.points = new ArrayList<>();
    }

    @Override
    public String getTitle() {
        return "Iris Data";
    }

    @Override
    public int getTotalPoints() {
        return points.size();
    }

    @Override
    public void setPoints(List<Iris> points) {
        this.points = points;
    }

    @Override
    public void addPoint(Iris point) {
        this.points.add(point);
    }

    @Override
    public void addPoints(List<Iris> points) {
        this.points.addAll(points);
    }

    @Override
    public void loadFromFile(String path, Class<Iris> dataType) {

    }

    @Override
    public void loadFromString(String data) {

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
        return 5;
    }

    @Override
    public Iterator<Iris> iterator() {
        return points.iterator();
    }
}
