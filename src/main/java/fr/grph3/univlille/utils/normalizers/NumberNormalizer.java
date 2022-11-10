package fr.grph3.univlille.utils.normalizers;

import fr.grph3.univlille.models.columns.DoubleColumn;

public class NumberNormalizer implements INormalizer {

    @Override
    public double normalize(Object value) {
        if(value instanceof Double) {
            return (((double) value) - DoubleColumn.getMin()) / (DoubleColumn.getMax() - DoubleColumn.getMin());
        }
        if(value instanceof Integer) {
            return (((int) value) - DoubleColumn.getMin()) / (DoubleColumn.getMax() - DoubleColumn.getMin());
        }
        return 0;
    }

    @Override
    public Object denormalize(double value) {
        return ((double)value)*(DoubleColumn.getMax() - DoubleColumn.getMin()) + DoubleColumn.getMin();
    }
}
