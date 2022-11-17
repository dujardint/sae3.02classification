package fr.grph3.univlille.models.columns;

import java.util.ArrayList;
import java.util.List;

import fr.grph3.univlille.models.IDataSet;

public abstract class DoubleColumn implements IColumn {
	
	public Number max;
	public Number min;
	public String name;
	
	public DoubleColumn(String name) {
		this.name = name;
		max = Double.MIN_VALUE;
		min = Double.MAX_VALUE;
	}

	
	
	public double getNormalizedValue(Object value) {
		Number val = (Number)value;
		return (val.doubleValue()-min.doubleValue())/(max.doubleValue()-min.doubleValue());
	}
	
	public Object getDenormalizedValue(double value) {
		return value*(max.doubleValue()-min.doubleValue())+min.doubleValue();
	}
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public IDataSet<?> getDataset() {
		return this.getDataset();
	}

	@Override
	public boolean isNormalizable() {
		return true;
	}
	
	/*

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
	
	*/
	
	//List<Double> colonne = new ArrayList<>();
		//String nom;
		
		
		//static pour que les tests fonctionnent !
		//public static double getNormalizedValue(Object value, double min, double max) {
			//X-MIN / MAX-MIN
			//return (((double) value) - min) / (max-min);
		//}
	

	//public static Object DenormalizedValue(double value) {
		// X * (MAX - MIN) + MIN 
		//return value*(max.doubleValue()-min.doubleValue())+min.doubleValue();
	//}
}
