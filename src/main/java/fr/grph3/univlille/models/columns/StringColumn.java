package fr.grph3.univlille.models.columns;

import fr.grph3.univlille.models.IDataSet;

public class StringColumn extends IColumn {

    public StringColumn(String name, IDataSet dataSet) {
        super(name, dataSet);
    }

    @Override
    public boolean isNormalizable() {
        return false;
    }
}
