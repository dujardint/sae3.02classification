package main.java.fr.grph3.univlille.models.columns;

import main.java.fr.grph3.univlille.models.IDataSet;

public class StringColumn implements IColumn {
	public String name;
	

    public StringColumn(String name) {
		super();
		this.name = name;
	}

	@Override
    public double getNormalizedValue(Object value) throws MistakeNormalizableValueException {
		throw new MistakeNormalizableValueException();
    }

    @Override
    public Object getDenormalizedValue(double value) throws MistakeNormalizableValueException {
    	throw new MistakeNormalizableValueException();
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
        return false;
    }
}
