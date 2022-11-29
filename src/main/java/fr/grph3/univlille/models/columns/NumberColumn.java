package fr.grph3.univlille.models.columns;

import fr.grph3.univlille.models.IDataSet;
import fr.grph3.univlille.utils.normalizers.NumberNormalizer;

public class NumberColumn extends INormalizableColumn {

    public NumberColumn(String name, IDataSet dataSet) {
        super(name, dataSet);
        initNormalizer(new NumberNormalizer(this));
    }

    @Override
    public boolean isNormalizable() {
        return true;
    }
}
