package fr.grph3.univlille.utils.normalizers;

import fr.grph3.univlille.models.columns.NumberColumn;

public class NumberNormalizer implements INormalizer {
	
	private NumberColumn column;

    public NumberNormalizer(NumberColumn column) {
		this.column = column;
	}

	@Override
    public double normalize(Object value) {
        if(value instanceof Double) {
            return (((double) value) - column.getMin()) / (column.getMax() - column.getMin());
        }
        if(value instanceof Integer) {
            return (((int) value) - column.getMin()) / (column.getMax() - column.getMin());
        }
        return 0;
    }

    @Override
    public Object denormalize(double value) {
        return value * (column.getMax() - column.getMin()) + column.getMin();
    }
}
