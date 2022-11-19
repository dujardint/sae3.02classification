package main.java.fr.grph3.univlille.models.columns;

import main.java.fr.grph3.univlille.models.IDataSet;

/**
 * Decrit une <i>colonne</i> d'un fr.grph3.univlille.models.DataSet.
 *
 * Une colonne a un nom, son fr.grph3.univlille.models.DataSet parent et un normaliseur optionnel.
 *
 * Un normaliseur traduit toutes les valeurs possibles de la colonne
 * (dans son fr.grph3.univlille.models.DataSet) en une valeur entre 0 et 1.
 * Seule les colonnes <i>normalisables</i> (qui ont un normaliseur) peuvent
 * etre utilisees comme axe dans le nuage de points.
 */
public interface IColumn {

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

    /**
     * Retourne le nom de la colonne.
     */
    String getName();

    /**
     * Retourne le fr.grph3.univlille.models.DataSet auquel cette colonne appartient.
     */

    IDataSet<?> getDataset();

    /**
     * Indique si cette colonne est normalisable (a un <i>normaliseur</i>).
     */
    boolean isNormalizable();
}
