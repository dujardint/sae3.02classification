package fr.grph3.univlille.models.columns;

import fr.grph3.univlille.models.IDataSet;
import fr.grph3.univlille.utils.normalizers.NumberNormalizer;

import java.util.ArrayList;
import java.util.List;

public class NumberColumn implements IColumn {

	private NumberNormalizer normalizer;
	private List<Double> column;
	private List<Double> columnNormalized;

	private String name;

	public NumberColumn() {
		this.column = new ArrayList<>();		
	}

	public NumberColumn(List<Double> colonne, String nom) {
		this.column = colonne;
		this.name = nom;
		this.normalizer = new NumberNormalizer(this);
		normaliseColonne();
	}


	public void normaliseColonne(){
		columnNormalized = new ArrayList<>();
		for(int i=0; i<this.column.size(); i++) {
			columnNormalized.add(getNormalizedValue((this.column.get(i))));
		}
	}

	@Override
	public double getNormalizedValue(Object value) {
		//X-MIN / MAX-MIN
		return normalizer.normalize(value);
	}


	public Object getDenormalizedValue(double value, double min, double max) {
		// X * (MAX - MIN) + MIN 
		return value * (max-min) + min;
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
		double min = this.column.get(0);
		for(int i=0; i<this.column.size(); i++) {
			if(min > this.column.get(i)) {
				min = this.column.get(i);
			}
		}
		return min;

	}

	public double getMax() {
		double max = this.column.get(0);
		for(int i=0; i<this.column.size(); i++) {
			if(max < this.column.get(i)) {
				max = this.column.get(i);
			}
		}
		return max;
	}


	@Override
	public Object getDenormalizedValue(double value) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String toString() {
		return ""+column;
	}


	public String toStringNormalised() {
		return ""+columnNormalized;
	}

}
