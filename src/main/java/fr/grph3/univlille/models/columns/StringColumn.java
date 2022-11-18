package fr.grph3.univlille.models.columns;

import fr.grph3.univlille.models.IDataSet;

import java.util.ArrayList;
import java.util.List;

public class StringColumn implements IColumn {

    private String name;

    private List<String> values;

    public StringColumn(String name) {
        this.values = new ArrayList<>();
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
    public String getName() {
        return name;
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
