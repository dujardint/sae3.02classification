package fr.grph3.univlille.utils.distances;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.points.IPoint;
import fr.grph3.univlille.utils.normalizers.INormalizer;
import fr.grph3.univlille.utils.normalizers.NumberNormalizer;

import java.util.List;

public class EuclidDistance<T extends IPoint> implements IDistance<T> {

    private final List<IColumn> columns;

    public EuclidDistance(List<IColumn> columns) {
        this.columns = columns;
    }

    @Override
    public double distance(IPoint p1, IPoint p2) {
        double distance = 0.0;
        for(IColumn col : columns ) {
           if((Object)col.getClass().getSimpleName() == "Double"){
               distance += Math.abs((double) p1.getValue(col) - (double) p2.getValue(col));
           }
           if ((Object)col.getClass().getSimpleName() == "String" || (Object)col.getClass().getSimpleName() == "Boolean") {
               if (p1.getValue(col).equals(p2.getValue(col))) {
                   distance += 0;
               } else {
                   distance += 1;
               }
           }
        }
        return distance;
    }
}
