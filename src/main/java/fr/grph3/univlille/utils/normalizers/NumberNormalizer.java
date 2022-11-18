package fr.grph3.univlille.utils.normalizers;

import fr.grph3.univlille.models.columns.NumberColumn;

public class NumberNormalizer implements INormalizer<Number> {
	
	private NumberColumn column;

    public NumberNormalizer(NumberColumn column) {
		this.column = column;
	}

	@Override
    public double normalize(Number value) {
        return (value.doubleValue() - column.getMin()) / (column.getMax() - column.getMin());
    }

    @Override
    public double normalize(Number value, Number reference) {
        return normalize(value);
    }

    @Override
    public Number denormalize(double value) {
        return value * (column.getMax() - column.getMin()) + column.getMin();
    }
}
