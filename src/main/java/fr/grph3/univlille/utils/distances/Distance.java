package main.java.fr.grph3.univlille.utils.distances;

import java.util.List;

import main.java.fr.grph3.univlille.models.columns.IColumn;
import main.java.fr.grph3.univlille.models.points.IPoint;


public interface  Distance {

	public double distance(IPoint p1, IPoint p2, List<IColumn> columns);
}
