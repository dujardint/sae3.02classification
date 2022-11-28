package fr.grph3.univlille.models.columns;

import fr.grph3.univlille.models.IDataSet;

public abstract class INormalizableColumn extends IColumn {

    public INormalizableColumn(String name, IDataSet dataSet) {
        super(name, dataSet);
    }

    /**
     * Recupere la valeur de cette colonne dans la donnee en parametre,
     * puis normalise cette valeur (entre 0 et 1) et la retourne normalisee.
     * Si la colonne n'est pas normalisable, le comportement n'est pas
     * definit.
     */

    public abstract double getNormalizedValue(Object value);

    /**
     * "Denormalise" une valeur entre 0 et 1 en une "vraie" valeur pour
     * cette colonne.
     * Si la colonne n'est pas normalisable, le comportement n'est pas
     * definit.
     */

    public abstract Object getDenormalizedValue(double value);

    public double getMin() {
        return dataSet.getPoints()
                .stream()
                .map(point -> ((Number) point.getValue(this)))
                .mapToDouble(Number::doubleValue)
                .min()
                .orElse(0);

    }

    public double getMax() {
        return dataSet.getPoints()
                .stream()
                .map(point -> ((Number) point.getValue(this)))
                .mapToDouble(Number::doubleValue)
                .max()
                .orElse(0);
    }
}
