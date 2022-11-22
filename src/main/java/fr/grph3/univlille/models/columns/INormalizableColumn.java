package fr.grph3.univlille.models.columns;

import fr.grph3.univlille.utils.normalizers.INormalizer;

public interface INormalizableColumn extends IColumn {

    /**
     * Recupere la valeur de cette colonne dans la donnee en parametre,
     * puis normalise cette valeur (entre 0 et 1) et la retourne normalisee.
     * Si la colonne n'est pas normalisable, le comportement n'est pas
     * definit.
     */
    double getNormalizedValue(Object value);

    /**
     * "Denormalise" une valeur entre 0 et 1 en une "vraie" valeur pour
     * cette colonne.
     * Si la colonne n'est pas normalisable, le comportement n'est pas
     * definit.
     */

    Object getDenormalizedValue(double value);

    INormalizer<?> getNormalizer();
}
