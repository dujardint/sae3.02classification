package fr.grph3.univlille.utils.normalizers;

public class StringNormalizer implements INormalizer<String> {

    private INormalizer<String> normalizer;

    public StringNormalizer(INormalizer<String> normalizer) {
        this.normalizer = normalizer;
    }

    @Override
    public double normalize(String value) {
        //throw new UnsupportedOperationException("Cannot normalize string value without a reference");
        return normalize(value, "");
    }

    @Override
    public double normalize(String value, String reference) {
        return (value.equals(reference)) ? 0 : 1;
    }

    @Override
    public String denormalize(double value) {
        throw new UnsupportedOperationException("Cannot denormalize double to a string value");
    }
}
