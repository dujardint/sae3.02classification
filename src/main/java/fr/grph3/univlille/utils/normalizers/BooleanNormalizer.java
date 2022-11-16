package fr.grph3.univlille.utils.normalizers;

import fr.grph3.univlille.models.columns.BooleanColumn;

public class BooleanNormalizer implements INormalizer {

    private BooleanColumn column;

    public BooleanNormalizer(BooleanColumn column) {
        this.column = column;
    }

    @Override
    public double normalize(Object value) {
        if (!(value instanceof Boolean)) return 1;
        if((boolean) value) return 0;
        return 1;
    }

    @Override
    public Object denormalize(double value) {
        return value == 0;
    }
}
