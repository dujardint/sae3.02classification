package fr.grph3.univlille.models.columns;

import fr.grph3.univlille.models.IDataSet;
import fr.grph3.univlille.utils.normalizers.INormalizer;
import fr.grph3.univlille.utils.normalizers.NumberNormalizer;

import java.util.ArrayList;
import java.util.List;

public class NumberColumn implements IColumn {

    private String name;

    private INormalizer<Number> normalizer;
    private List<Number> values;

    public NumberColumn(String name) {
        this.name = name;
        this.values = new ArrayList<>();
        this.normalizer = new NumberNormalizer(this);
    }
    
    public void addValues(Double value) {
    	this.values.add(value);
    }

    @Override
    public boolean push(Object value) {
        if (!(value instanceof Number)) return false;
        return values.add((Number) value);
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
        return this.name;
    }

    @Override
    public IDataSet<?> getDataset() {
        return null;
    }

    @Override
    public boolean isNormalizable() {
        return true;
    }

    public double getMin() {
        return values.stream()
                .map(Number::doubleValue)
                .min(Double::compareTo)
                .orElse(0.0);
    }

    public double getMax() {
        return values.stream()
                .map(Number::doubleValue)
                .max(Double::compareTo)
                .orElse(0.0);
    }

    @Override
    public String toString() {
        return "NumberColumn{" +
                "name='" + name + '\'' +
                ", values=" + values +
                '}';
    }
}
