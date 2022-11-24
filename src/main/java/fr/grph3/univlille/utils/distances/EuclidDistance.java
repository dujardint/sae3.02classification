package fr.grph3.univlille.utils.distances;

import fr.grph3.univlille.models.columns.*;
import fr.grph3.univlille.models.points.IPoint;

import java.util.List;

public class EuclidDistance<T extends IPoint> implements IDistance<T> {

    private final List<IColumn> columns;

    public EuclidDistance(List<IColumn> columns) {
        this.columns = columns;
    }
    @Override
    public double distance(IPoint p1, IPoint p2) {
        if (p1 == null || p2 == null) return 0;
        double distance = 0.0;
        for(IColumn column : columns ) {
            if(column instanceof INormalizableColumn) {
                double value1 = ((INormalizableColumn) column).getNormalizedValue(p1.getValue(column));
                double value2 = ((INormalizableColumn) column).getNormalizedValue(p2.getValue(column));
                distance += Math.pow(value1 - value2, 2);
            } else {
                distance += p1.getValue(column).equals(p2.getValue(column)) ? 0 : 1;
            }

        }
        return Math.sqrt(distance);
    }
}
