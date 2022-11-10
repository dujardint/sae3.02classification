package fr.grph3.univlille.utils.distances;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.points.IPoint;

import java.util.List;

public class EuclidDistance<T extends IPoint> implements IDistance<T> {

    private final List<IColumn> columns;

    public EuclidDistance(List<IColumn> columns) {
        this.columns = columns;
    }

    @Override
    public double distance(IPoint p1, IPoint p2) {
        return 0;
    }
}
