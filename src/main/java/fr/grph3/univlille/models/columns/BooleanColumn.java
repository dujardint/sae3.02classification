package main.java.fr.grph3.univlille.models.columns;

import main.java.fr.grph3.univlille.models.IDataSet;
import main.java.fr.grph3.univlille.utils.normalizers.INormalizer;

import java.util.ArrayList;
import java.util.List;

public class BooleanColumn implements IColumn {

    private String name;

    private List<Boolean> values;

    private INormalizer<Boolean> normalizer;
    
    public BooleanColumn(String name) {
		this.name = name;
	}

    public BooleanColumn(String name, INormalizer<Boolean> normalizer) {
        this.name = name;
        this.values = new ArrayList<>();
        this.normalizer = normalizer;
    }

    @Override
    public double getNormalizedValue(Object value) {
    	return value.equals(true) ? 1.0 : 0.0;
    }

    @Override
    public Object getDenormalizedValue(double value) {
    	return value == 1.0 ? true : false;
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
        return true;
    }
}
