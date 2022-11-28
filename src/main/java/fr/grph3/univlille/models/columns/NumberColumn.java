package fr.grph3.univlille.models.columns;

import fr.grph3.univlille.models.IDataSet;
import fr.grph3.univlille.utils.normalizers.INormalizer;
import fr.grph3.univlille.utils.normalizers.NumberNormalizer;

public class NumberColumn extends INormalizableColumn {

    private INormalizer normalizer;

    public NumberColumn(String name, IDataSet dataSet) {
        super(name, dataSet);
        this.normalizer = new NumberNormalizer(this);
    }

    @Override
    public double getNormalizedValue(Object value) {
        return normalizer.normalize((Number) value);
    }

    @Override
    public Object getDenormalizedValue(double value) {
        return normalizer.denormalize(value);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IDataSet getDataset() {
        return null;
    }

    @Override
    public boolean isNormalizable() {
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
}
