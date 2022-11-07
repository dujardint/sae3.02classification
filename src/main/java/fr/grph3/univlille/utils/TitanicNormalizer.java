package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.Titanic;

public class TitanicNormalizer implements ValueNormalizer {

	private KnnMethod<Titanic> knn;

    public TitanicNormalizer(KnnMethod<Titanic> knn) {
    	this.knn = knn;
    }

	@Override
    public double normalize(Object value) {

        //Formule pour normalizer : valeur - Min() / max() - Min()
		if(value instanceof Double) {
			return (((double) value) - knn.getMin()) / (knn.getMax() - knn.getMin());
		}
		if(value instanceof Integer) {
			return (((int) value) - knn.getMin()) / (knn.getMax() - knn.getMin());
		}
		return 0;
		
    	
    }

    @Override
    public Object denormalize(double value) {
        return null;
    }
}
