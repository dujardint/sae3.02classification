package fr.grph3.univlille.models.columns;

import fr.grph3.univlille.models.IDataSet;

public class BooleanColumn implements IColumn {
	
	private String name;
	
	public BooleanColumn(String name) {
		this.name = name;
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
        return this.getDataset();
    }

    @Override
    public boolean isNormalizable() {
        return true;
    }
}
