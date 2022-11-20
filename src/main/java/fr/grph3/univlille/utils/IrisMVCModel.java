package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.columns.NumberColumn;
import fr.grph3.univlille.models.columns.StringColumn;
import fr.grph3.univlille.models.points.Iris;

import java.util.List;

public class IrisMVCModel extends MVCModel<Iris> {

    private static final int COLUMNS_COUNT = 5;

    private CSVModel<Iris> loader;

    private NumberColumn sepalLengthColumn;
    private NumberColumn sepalWidthColumn;
    private NumberColumn petalLengthColumn;
    private NumberColumn petallWidthColumn;
    private StringColumn varietyColumn;

    public IrisMVCModel() {
        this.loader = new CSVModel<>();
        this.sepalLengthColumn = new NumberColumn("sepal.length");
        this.sepalWidthColumn = new NumberColumn("sepal.width");
        this.petalLengthColumn = new NumberColumn("petal.length");
        this.petallWidthColumn = new NumberColumn("petal.width");
        this.varietyColumn = new StringColumn("variety");
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
        sepalLengthColumn.push(point.getPetalLength());
        sepalWidthColumn.push(point.getSepalWidth());
        petalLengthColumn.push(point.getPetalLength());
        petallWidthColumn.push(point.getPetalWidth());
        varietyColumn.push(point.getVariety());
        loader.addPoint(point);
    }

    @Override
    public void addPoints(List<Iris> points) {
        points.forEach(this::addPoint);
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
    public List<IColumn> getColumns() {
        return null;
    }

    @Override
    public IColumn defaultXCol() {
        return sepalLengthColumn;
    }

    @Override
    public IColumn defaultYCol() {
        return sepalWidthColumn;
    }

    @Override
    public int nbColumns() {
        return COLUMNS_COUNT;
    }
}
