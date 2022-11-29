package fr.grph3.univlille.models.columns;

import fr.grph3.univlille.models.IDataSet;

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
public abstract class IColumn {

    public IColumn(String name, IDataSet dataSet) {
        this.name = name;
        this.dataSet = dataSet;
    }

    protected String name;

    protected IDataSet dataSet;

    /**
     * Retourne le nom de la colonne.
     */

    public String getName() {
        return name;
    }

    /**
     * Retourne le fr.grph3.univlille.models.DataSet auquel cette colonne appartient.
     */

    public IDataSet getDataset() {
        return dataSet;
    }

    /**
     * Indique si cette colonne est normalisable (a un <i>normaliseur</i>).
     */
    public abstract boolean isNormalizable();

    @Override
    public String toString() {
        return name;
    }
}
