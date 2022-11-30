package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.columns.INormalizableColumn;
import fr.grph3.univlille.models.columns.NullColumn;
import fr.grph3.univlille.models.points.IPoint;
import fr.grph3.univlille.utils.parsers.IPointParser;

import java.nio.file.Path;
import java.util.stream.Collectors;

public class CSVModel extends AbstractMVCModel {

    private Class<? extends IPoint> dataType;

    private ColumnFactory factory;

    public CSVModel(Class<? extends IPoint> dataType, String title, IPointParser parser) {
        super(title, parser);
        this.dataType = dataType;
        this.factory = new ColumnFactory();
    }

    @Override
    public void loadFromFile(String path) {
        this.setPoints(CSVUtil.loadCSVAsFile(Path.of(path), (Class<IPoint>) dataType));
        this.columns = factory.generate(dataType, this);
        this.normalizableColumns = getColumns().stream()
                .filter(IColumn::isNormalizable)
                .map(column -> (INormalizableColumn) column)
                .collect(Collectors.toList());
        classify(points);
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
}
