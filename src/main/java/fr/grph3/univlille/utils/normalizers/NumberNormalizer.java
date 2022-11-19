package main.java.fr.grph3.univlille.utils.normalizers;

import main.java.fr.grph3.univlille.models.columns.NumberColumn;

public class NumberNormalizer implements INormalizer<Number> {
	
	private NumberColumn column;

    public NumberNormalizer(NumberColumn column) {
		this.column = column;
	}

	@Override
    public double normalize(Number value) {
        return (double)Math.round((value.doubleValue() - column.getMin()) / (column.getMax() - column.getMin()) * 1000) /1000;
    }

    @Override
    public Number denormalize(double value) {
        return (double) Math.round((value * (column.getMax() - column.getMin()) + column.getMin())*1000)/1000;
    }
    
    
}
