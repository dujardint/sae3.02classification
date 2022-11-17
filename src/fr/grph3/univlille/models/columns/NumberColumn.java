package fr.grph3.univlille.models.columns;

import java.util.ArrayList;
import java.util.List;

import fr.grph3.univlille.models.IDataSet;


public class NumberColumn implements IColumn{

	private List<Double> values;
	private List<Double> columnNormalized;
	protected Number max;
	protected Number min;

	private String name;

	public NumberColumn(String name, List<Double> colonne) {
		this.values = colonne;
		this.name = name;
		max = Double.MIN_VALUE;
		min = Double.MAX_VALUE;
		normaliseColonne();
	}

	public NumberColumn(String name) {
		this.values = new ArrayList<>();
	}

	public void normaliseColonne(){
		columnNormalized = new ArrayList<>();
		for(int i = 0; i<this.values.size(); i++) {
			columnNormalized.add(getNormalizedValue((this.values.get(i))));
		}
	}

	@Override
	public double getNormalizedValue(Object value) {
		Number val = (Number)value;
		return (val.doubleValue()-min.doubleValue())/(max.doubleValue()-min.doubleValue());
	}

	@Override
	public Object getDenormalizedValue(double value) {
		// X * (MAX - MIN) + MIN
		return value*(max.doubleValue()-min.doubleValue())+min.doubleValue();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public IDataSet<?> getDataset() {
		return null;
	}

	@Override
	public boolean isNormalizable() {
		return true;
	}

	public double getMin() {
		double min = this.values.get(0);
		for (Double value : this.values) {
			if (min > value) {
				min = value;
			}
		}
		return min;

	}

	public double getMax() {
		double max = this.values.get(0);
		for (Double value : this.values) {
			if (max < value) {
				max = value;
			}
		}
		return max;
	}

	@Override
	public String toString() {
		return ""+ values;
	}


	public String toStringNormalised() {
		return " " + columnNormalized;
	}

}
