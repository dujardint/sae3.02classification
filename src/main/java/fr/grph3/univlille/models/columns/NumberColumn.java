package main.java.fr.grph3.univlille.models.columns;

import main.java.fr.grph3.univlille.models.IDataSet;
import main.java.fr.grph3.univlille.utils.normalizers.INormalizer;
import main.java.fr.grph3.univlille.utils.normalizers.NumberNormalizer;

import java.util.ArrayList;
import java.util.List;

public class NumberColumn implements IColumn {

    private String name;
 

    private INormalizer<Number> normalizer;
    private List<Double> values;
    
    protected Number max;
	protected Number min;

    public NumberColumn(String name) {
        this.name = name;
        this.values = new ArrayList<>();
        this.normalizer = new NumberNormalizer(this);
        max = Double.MIN_VALUE;
		min = Double.MAX_VALUE;
    }
    
    public void addValues(Double value) {
    	this.values.add(value);
    }

    @Override
    public double getNormalizedValue(Object value) {
    	Number val = (Number)value;
		return (val.doubleValue()-min.doubleValue())/(max.doubleValue()-min.doubleValue());
    }

    @Override
    public Object getDenormalizedValue(double value) {
    	return value*(max.doubleValue()-min.doubleValue())+min.doubleValue();
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
                .min(Double::compareTo)
                .orElse(0.0);
    }

    public double getMax() {
        return values.stream()
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
