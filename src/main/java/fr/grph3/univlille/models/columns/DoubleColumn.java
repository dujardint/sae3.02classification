package fr.grph3.univlille.models.columns;

import fr.grph3.univlille.models.IDataSet;

import java.util.ArrayList;
import java.util.List;

public class DoubleColumn implements IColumn {

	List<Double> colonne = new ArrayList<>();

	@Override
	public double getNormalizedValue(Object value) {
		return 0;
	}

	@Override
	public Object getDenormalizedValue(double value) {
		return null;
	}

	@Override
	public String getName() {
		return null;
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
