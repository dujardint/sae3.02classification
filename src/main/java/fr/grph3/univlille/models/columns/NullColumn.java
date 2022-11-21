package fr.grph3.univlille.models.columns;

import fr.grph3.univlille.models.IDataSet;

public class NullColumn implements IColumn {

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
}
