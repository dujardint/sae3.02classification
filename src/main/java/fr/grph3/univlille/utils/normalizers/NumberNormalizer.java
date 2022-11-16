package fr.grph3.univlille.utils.normalizers;

import fr.grph3.univlille.models.columns.NumberColumn;

public class NumberNormalizer implements INormalizer {
	
	private NumberColumn colonne;
	

    public NumberNormalizer(NumberColumn colonne) {
		this.colonne = colonne;
	}

	@Override
    public double normalize(Object value) {
        if(value instanceof Double) {
            return (((double) value) - colonne.getMin()) / (colonne.getMax() - colonne.getMin());
        }
        if(value instanceof Integer) {
            return (((int) value) - colonne.getMin()) / (colonne.getMax() - colonne.getMin());
        }
        return 0;
    }

    @Override
    public Object denormalize(double value) {
        return ((double)value)*(colonne.getMax() - colonne.getMin()) + colonne.getMin();
    }
}
