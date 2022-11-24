package main.java.fr.grph3.univlille.utils.normalizers;

public class BooleanNormalizer implements INormalizer<Boolean> {

    @Override
    public double normalize(Boolean value) {
    	return value.equals(true) ? 1.0 : 0.0;
    }

    @Override
    public Boolean denormalize(double value) {
    	return value == 1.0 ? true : false;
    }
}
