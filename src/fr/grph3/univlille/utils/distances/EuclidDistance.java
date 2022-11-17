package fr.grph3.univlille.utils.distances;

import java.util.List;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.points.IPoint;

public class EuclidDistance<T extends IPoint> implements IDistance<T> {

    private final List<IColumn> columns;

    public EuclidDistance(List<IColumn> columns) {
        this.columns = columns;
    }


	@Override
	public double distance(T p1, T p2, List<IColumn> columns) {
		double somme = 0;
		for(IColumn column : columns) {
			somme += Math.pow(1.0*p1.getNormalizedValue(column)-p2.getNormalizedValue(column), 2);
		}
		return Math.sqrt(somme);
	}


}
