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
		double somme = 0.0;
		for(IColumn col : columns ) {
	           if((Object)col.getClass().getSimpleName() == "Double"){
	        	   somme += Math.abs((double) p1.getValue(col) - (double) p2.getValue(col));
	           }
	           if ((Object)col.getClass().getSimpleName() == "String" || (Object)col.getClass().getSimpleName() == "Boolean") {
	               if (p1.getValue(col).equals(p2.getValue(col))) {
	            	   somme += 0;
	               } else {
	            	   somme += 1;
	               }
	           }
	        }
	        return somme;
	}
}
