package fr.grph3.univlille.utils.distances;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.points.IPoint;

import java.util.List;

public class ManhattanDistance<T extends IPoint> implements IDistance<T> {

    private final List<IColumn> columns;

    public ManhattanDistance(List<IColumn> columns) {
        this.columns = columns;
    }

    @Override
    public double distance(T p1, T p2) {
        return 0;
    }
}
