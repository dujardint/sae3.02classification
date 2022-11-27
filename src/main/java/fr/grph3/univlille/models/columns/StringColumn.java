package fr.grph3.univlille.models.columns;

import fr.grph3.univlille.models.IDataSet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringColumn implements IColumn {

    private String name;

    private List<Object> values;

    public StringColumn(String name) {
        this.name = name;
        this.values = new ArrayList<>();
    }

    @Override
    public boolean push(Object value) {
        if (!(value instanceof String)) return false;
        return values.add((String) value);
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
    public Iterator<Object> iterator() {
        return values.iterator();
    }

    @Override
    public boolean isNormalizable() {
        return false;
    }

    @Override
    public String toString() {
        return "StringColumn{" +
                "name='" + name + '\'' +
                ", values=" + values +
                '}';
    }
}
