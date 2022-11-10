package fr.grph3.univlille.models.columns;

import fr.grph3.univlille.models.IDataSet;

public class StringColumn implements IColumn {
    @Override
    public double getNormalizedValue(Object value) {
        return 0;
    }

    @Override
    public Object getDenormalizedValue(double value) {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public IDataSet<?> getDataset() {
        return null;
    }

    @Override
    public boolean isNormalizable() {
        return false;
    }
}
