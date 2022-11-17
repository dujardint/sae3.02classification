package fr.grph3.univlille.utils.distances;

import java.util.List;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.points.IPoint;

public interface IDistance<T extends IPoint> {

    double distance(T p1, T p2, List<IColumn> columns);
}
