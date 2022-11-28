package fr.grph3.univlille.utils.normalizers;

public class BooleanNormalizer implements INormalizer {

    @Override
    public double normalize(Object value) {
        return ((Boolean) value) ? 0 : 1;
    }

    @Override
    public Boolean denormalize(double value) {
        return value == 0;
    }
}
