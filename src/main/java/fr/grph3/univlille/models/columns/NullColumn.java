package fr.grph3.univlille.models.columns;

import fr.grph3.univlille.models.IDataSet;
import fr.grph3.univlille.utils.normalizers.INormalizer;

public class NullColumn implements INormalizableColumn {

    @Override
    public boolean push(Object value) {
        return false;
    }

    @Override
    public String getName() {
        return "Null Column";
    }

    @Override
    public IDataSet<?> getDataset() {
        return null;
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

    @Override
    public INormalizer<?> getNormalizer() {
        return null;
    }
}
