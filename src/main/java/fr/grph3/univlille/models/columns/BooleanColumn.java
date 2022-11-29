package fr.grph3.univlille.models.columns;

import fr.grph3.univlille.models.IDataSet;
import fr.grph3.univlille.utils.normalizers.BooleanNormalizer;

public class BooleanColumn extends INormalizableColumn {

    private BooleanNormalizer normalizer;

    public BooleanColumn(String name, IDataSet dataSet) {
        super(name, dataSet);
        initNormalizer(new BooleanNormalizer());
    }

    @Override
    public boolean isNormalizable() {
        return true;
    }
}
