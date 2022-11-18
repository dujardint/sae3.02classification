package fr.grph3.univlille.utils.distances;

import fr.grph3.univlille.models.columns.BooleanColumn;
import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.columns.NumberColumn;
import fr.grph3.univlille.models.columns.StringColumn;
import fr.grph3.univlille.models.points.IPoint;
import fr.grph3.univlille.utils.normalizers.BooleanNormalizer;
import fr.grph3.univlille.utils.normalizers.INormalizer;
import fr.grph3.univlille.utils.normalizers.NumberNormalizer;

import java.util.List;

public class EuclidDistance<T extends IPoint> implements IDistance<T> {

    private final List<IColumn> columns;
    private final BooleanNormalizer booleanNormalizer;
    private final NumberNormalizer numberNormalizer;

    public EuclidDistance(NumberNormalizer numberNormalizer, BooleanNormalizer booleanNormalizer, List<IColumn> columns) {
        this.numberNormalizer = numberNormalizer;
        this.booleanNormalizer = booleanNormalizer;
        this.columns = columns;
    }
    @Override
    public double distance(IPoint p1, IPoint p2) {
        if (p1 == null || p2 == null) return 0;
        double distance = 0.0;
        for(IColumn column : columns ) {
            if(column instanceof NumberColumn)  {
                double value1 = numberNormalizer.normalize(p1.getValue(column));
                double value2 = numberNormalizer.normalize(p2.getValue(column));
                distance += Math.abs(value1 - value2);
            }
            if (column instanceof BooleanColumn) {
                double value1 = booleanNormalizer.normalize(p1.getValue(column));
                double value2 = booleanNormalizer.normalize(p2.getValue(column));
                distance += Math.abs(value1 - value2);
            }
            if (column instanceof StringColumn) {
                String value1 = p1.getValue(column);
                String value2 = p2.getValue(column);
                distance += value1.equals(value2) ? 0 : 1;
            }
        }
        return Math.sqrt(distance);
    }
}
