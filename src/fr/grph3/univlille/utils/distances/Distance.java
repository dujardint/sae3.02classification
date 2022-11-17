package fr.grph3.univlille.utils.distances;

import java.util.List;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.points.IPoint;


public interface  Distance {

	public double distance(IPoint p1, IPoint p2, List<IColumn> columns);
}
