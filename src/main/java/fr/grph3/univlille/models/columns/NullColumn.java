package fr.grph3.univlille.models.columns;

public class NullColumn extends INormalizableColumn {

    public NullColumn() {
        super("Null Column", null);
    }

    @Override
    public boolean isNormalizable() {
        return false;
    }

    @Override
    public double getNormalizedValue(Object value) {
        return 0;
    }

    @Override
    public Object getDenormalizedValue(double value) {
        return null;
    }
}
