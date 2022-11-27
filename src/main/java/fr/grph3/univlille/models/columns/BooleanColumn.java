package fr.grph3.univlille.models.columns;

import fr.grph3.univlille.models.IDataSet;
import fr.grph3.univlille.utils.normalizers.BooleanNormalizer;
import fr.grph3.univlille.utils.normalizers.INormalizer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BooleanColumn implements INormalizableColumn {

    private String name;

    private List<Object> values;

    private INormalizer<Boolean> normalizer;

    public BooleanColumn(String name) {
        this.name = name;
        this.values = new ArrayList<>();
        this.normalizer = new BooleanNormalizer();
    }

    @Override
    public boolean push(Object value) {
        if (!(value instanceof Boolean)) return false;
        return values.add((Boolean) value);
    }

    @Override
    public double getNormalizedValue(Object value) {
        return normalizer.normalize((Boolean) value);
    }

    @Override
    public Object getDenormalizedValue(double value) {
        return normalizer.denormalize(value);
    }

    @Override
    public INormalizer<?> getNormalizer() {
        return normalizer;
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
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
}
