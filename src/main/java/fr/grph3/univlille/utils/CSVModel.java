package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.columns.INormalizableColumn;
import fr.grph3.univlille.models.columns.NullColumn;
import fr.grph3.univlille.models.points.IPoint;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CSVModel<T extends IPoint> extends MVCModel<T> {

    private Class<T> dataType;

    public String title;

    public CSVModel(Class<T> dataType,  String title) {
        super(title);
        this.dataType = dataType;
        this.title = title;
        this.columns = new ArrayList<>();
        this.points = new ArrayList<>();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getTotalPoints() {
        return points.size();
    }

    public T getPoint(int index) {
        return points.get(index);
    }

    public List<T> getPoints() {
        return points;
    }

    @Override
    public void setPoints(List<T> points) {
        this.points = points;
    }

    @Override
    public void addPoint(T point) {
        this.points.add(point);
    }

    @Override
    public void addPoints(List<T> points) {
        this.points.addAll(points);
    }

    @Override
    public void loadFromFile(String path) {
        ColumnFactory factory = new ColumnFactory();
        this.points = CSVUtil.loadCSVAsFile(Path.of(path), dataType);
        this.columns = factory.generate(dataType, points);
    }

    @Override
    public void loadFromString(String data) {

    }

    @Override
    public INormalizableColumn defaultXCol() {
        IColumn defX = columns.get(0);
        return (defX == null || !defX.isNormalizable()) ? new NullColumn() : (INormalizableColumn) defX;
    }

    @Override
    public INormalizableColumn defaultYCol() {
        IColumn defY = columns.get(1);
        return (defY == null || !defY.isNormalizable()) ? new NullColumn() : (INormalizableColumn) defY;
    }

    @Override
    public List<INormalizableColumn> getNormalizableColumns() {
        return columns.stream()
                .filter(IColumn::isNormalizable)
                .map(column -> (INormalizableColumn) column)
                .collect(Collectors.toList());
    }

    @Override
    public List<IColumn> getColumns() {
        return columns;
    }

    @Override
    public int nbColumns() {
        return columns.size();
    }

    @Override
    public Iterator<T> iterator() {
        return points.iterator();
    }
}
