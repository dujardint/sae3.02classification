package fr.grph3.univlille.models.points;

import fr.grph3.univlille.models.columns.IColumn;

/**
 * Decrit un fr.grph3.univlille.models.Point (ou donnee, ou ligne) dans un fr.grph3.univlille.models.DataSet.
 */

public interface IPoint {

    /*
     * Retourne la valeur de ce point pour la colonne en parametre.
     *
     * Note, on aurait pu utiliser une interface generique (parametre avec
     * un type), mais cela complique significativement d'autres parties
     * du code.
     */

    Object getValue(IColumn column);

    /**
     * Retourne la valeur de ce point normalisee pour la colonne en parametre.
     *
     * La normalisation se fait avec le <i>normaliseur</i> de la colonne.
     * Si la colonne n'est pas normalisable, le comportement n'est pas defini.
     */

    //double getNormalizedValue(IColumn xColumn);
}
