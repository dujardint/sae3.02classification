package fr.grph3.univlille.models.columns;

import fr.grph3.univlille.models.IDataSet;
import fr.grph3.univlille.utils.normalizers.NumberNormalizer;

import java.util.ArrayList;
import java.util.List;

public class NumberColumn implements IColumn {

	private NumberNormalizer normalizer;
	private List<Double> values;
	private List<Double> columnNormalized;

	private String name;

	public NumberColumn(String name, List<Double> colonne) {
		this.values = colonne;
		this.name = name;
		this.normalizer = new NumberNormalizer(this);
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
		//X-MIN / MAX-MIN
		return normalizer.normalize(value);
	}

	@Override
	public Object getDenormalizedValue(double value) {
		// X * (MAX - MIN) + MIN
		return normalizer.denormalize(value);
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
