package fr.grph3.univlille.models.columns;

import fr.grph3.univlille.models.IDataSet;

import java.util.ArrayList;
import java.util.List;

public class DoubleColumn implements IColumn {

	List<Double> colonne;
	String nom;
	private double min;
	private double max;

	public DoubleColumn() {
		this.colonne = new ArrayList<>();		
	}
	

	public DoubleColumn(List<Double> colonne, String nom, double min, double max) {
		this.colonne = colonne;
		this.nom = nom;
		this.min = min;
		this.max = max;
	}
	

	public DoubleColumn(List<Double> colonne, String nom) {
		this.colonne = colonne;
		this.nom = nom;
		this.min=getMin(colonne);
		this.max = getMax(colonne);
	}
	
	
	public double getNormalizedValue(Object value, double min, double max) {
		//X-MIN / MAX-MIN
		return (((double) value) - min) / (max-min);
	}


	public Object getDenormalizedValue(double value, double min, double max) {
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

	public double getMin(List<Double> col) {
		double min=col.get(0);
		for(int i=0; i<col.size(); i++) {
			if(min>col.get(i)) {
				min=col.get(i);
			}
		}
		return min;

	}

	public double getMax(List<Double> col) {
		double max=col.get(0);
		for(int i=0; i<col.size(); i++) {
			if(max<col.get(i)) {
				max=col.get(i);
			}
		}
		return max;
	}


	@Override
	public Object getDenormalizedValue(double value) {
		// TODO Auto-generated method stub
		return null;
	}
}
