package fr.grph3.univlille.models.columns;

import fr.grph3.univlille.models.IDataSet;

import java.util.ArrayList;
import java.util.List;

public abstract class DoubleColumn implements IColumn {

	List<Double> colonne = new ArrayList<>();
	String nom;
	
	public double min = getMin(colonne);
	public double max = getMax(colonne);


	//static pour que les tests fonctionnent !
	public static double getNormalizedValue(Object value, double min, double max) {
		//X-MIN / MAX-MIN
		return (((double) value) - min) / (max-min);
	}


	public static Object getDenormalizedValue(double value, double min, double max) {
		// X * (MAX - MIN) + MIN 
		return value * (max-min) + min;
	}

	@Override
	public String getName() {
		return this.nom;
	}

	@Override
	public IDataSet<?> getDataset() {
		return null;
	}

	@Override
	public boolean isNormalizable() {
		return true;
	}

	public static double getMin(List<Double> col) {
		double min=col.get(0);
		for(int i=0; i<col.size(); i++) {
			if(min>col.get(i)) {
				min=col.get(i);
			}
		}
		return min;

	}

	public static double getMax(List<Double> col) {
		double max=col.get(0);
		for(int i=0; i<col.size(); i++) {
			if(max<col.get(i)) {
				max=col.get(i);
			}
		}
		return max;
	}
}
