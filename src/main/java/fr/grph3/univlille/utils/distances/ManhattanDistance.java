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
        double distance = 0.0;
        for(IColumn col : columns ) {
            if((Object)col.getClass().getSimpleName() == "Double"){
                distance += Math.pow((double) p1.getValue(col) - (double) p2.getValue(col),2);
            }
            if ((Object)col.getClass().getSimpleName() == "String" || (Object)col.getClass().getSimpleName() == "Boolean") {
                if (p1.getValue(col).equals(p2.getValue(col))) {
                    distance += 0;
                } else {
                    distance += 1;
                }
            }
        }
        return Math.sqrt(distance);
    }
}
