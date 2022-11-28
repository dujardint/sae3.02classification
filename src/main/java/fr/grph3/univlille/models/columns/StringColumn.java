package fr.grph3.univlille.models.columns;

import fr.grph3.univlille.models.IDataSet;

public class StringColumn extends IColumn {

    public StringColumn(String name, IDataSet dataSet) {
        super(name, dataSet);
        this.name = name;
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
        return false;
    }

    @Override
    public String toString() {
        return "StringColumn{" +
                "name='" + name + '\'' +
                '}';
    }
}
