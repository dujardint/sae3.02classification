package fr.grph3.univlille.models.columns;

import fr.grph3.univlille.models.IDataSet;
import fr.grph3.univlille.utils.normalizers.BooleanNormalizer;

public class BooleanColumn extends INormalizableColumn {

    private BooleanNormalizer normalizer;

    public BooleanColumn(String name, IDataSet dataSet) {
        super(name, dataSet);
        this.normalizer = new BooleanNormalizer();
    }

    @Override
    public double getNormalizedValue(Object value) {
        return normalizer.normalize(value);
    }

    @Override
    public Object getDenormalizedValue(double value) {
        return normalizer.denormalize(value);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IDataSet getDataset() {
        return dataSet;
    }

    @Override
    public boolean isNormalizable() {
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

	public Integer getNormalizer() {
		// TODO Auto-generated method stub
		return null;
	}
}
