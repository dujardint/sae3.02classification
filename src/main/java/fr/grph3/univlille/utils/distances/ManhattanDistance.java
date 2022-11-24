package fr.grph3.univlille.utils.distances;

import fr.grph3.univlille.models.columns.BooleanColumn;
import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.columns.INormalizableColumn;
import fr.grph3.univlille.models.columns.NumberColumn;
import fr.grph3.univlille.models.columns.StringColumn;
import fr.grph3.univlille.models.points.IPoint;
import fr.grph3.univlille.utils.normalizers.BooleanNormalizer;
import fr.grph3.univlille.utils.normalizers.NumberNormalizer;

import java.util.List;

public class ManhattanDistance<T extends IPoint> implements IDistance<T> {

    private final List<INormalizableColumn> columns;

    public ManhattanDistance(List<INormalizableColumn> columns) {
        this.columns = columns;
    }
    @Override
    public double distance(IPoint p1, IPoint p2) {
        if (p1 == null || p2 == null) return 0;
        double distance = 0.0;
        for(INormalizableColumn column : columns ) {
            if(column instanceof NumberColumn)  {
                double value1 = column.getNormalizedValue(p1.getValue(column));
                double value2 = column.getNormalizedValue(p2.getValue(column));
                distance += Math.abs(value1 - value2);

            }
            if (column instanceof BooleanColumn) {
                double value1 = column.getNormalizedValue(p1.getValue(column));
                double value2 = column.getNormalizedValue(p2.getValue(column));
                distance += Math.abs(value1 - value2);

            }
            if (column instanceof StringColumn) {
                String value1 = (String) p1.getValue(column);
                String value2 = (String) p2.getValue(column);
                distance += value1.equals(value2) ? 0 : 1;
            }
        }
        return Math.sqrt(distance);
    }
}
