package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.columns.INormalizableColumn;
import fr.grph3.univlille.models.columns.NullColumn;
import fr.grph3.univlille.models.points.IPoint;

import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CSVModel extends MVCModel {

    private Class<? extends IPoint> dataType;

    private ColumnFactory factory;

    public CSVModel(Class<? extends IPoint> dataType,  String title) {
        super(title);
        this.dataType = dataType;
        this.factory = new ColumnFactory();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getTotalPoints() {
        return points.size();
    }

    public IPoint getPoint(int index) {
        return points.get(index);
    }

    public List<IPoint> getPoints() {
        return points;
    }

    @Override
    public void setPoints(List<IPoint> points) {
        this.points = points;
    }

    @Override
    public void addPoint(IPoint point) {
        this.points.add(point);
    }

    @Override
    public void addPoints(List<IPoint> points) {
        this.points.addAll(points);
    }

    @Override
    public void loadFromFile(String path) {
        this.setPoints(CSVUtil.loadCSVAsFile(Path.of(path), (Class<IPoint>) dataType));
        this.columns = factory.generate(dataType, this);
        this.normalizableColumns = getColumns().stream()
                .filter(IColumn::isNormalizable)
                .map(column -> (INormalizableColumn) column)
                .collect(Collectors.toList());
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
    public List<IColumn> getColumns() {
        return columns;
    }

    @Override
    public int nbColumns() {
        return columns.size();
    }

    @Override
    public Iterator<IPoint> iterator() {
        return points.iterator();
    }
}
