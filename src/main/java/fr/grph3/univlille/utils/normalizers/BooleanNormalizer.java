package main.java.fr.grph3.univlille.utils.normalizers;

public class BooleanNormalizer implements INormalizer<Boolean> {

    @Override
    public double normalize(Boolean value) {
        return value ? 0 : 1;
    }

    @Override
    public Boolean denormalize(double value) {
        return value == 0;
    }
}
