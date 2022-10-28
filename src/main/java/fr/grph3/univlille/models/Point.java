package fr.grph3.univlille.models;

/**
 * Decrit un fr.grph3.univlille.models.Point (ou donnee, ou ligne) dans un fr.grph3.univlille.models.DataSet.
 */

public interface Point {

    /**
     * Retourne la valeur de ce point pour la colonne en parametre.
     *
     * Note, on aurait pu utiliser une interface generique (parametree avec
     * un type), mais cela complique significativement d'autres parties
     * du code.
     */

    Object getValue(Column<? extends Point> column);

    /**
     * Retourne la valeur de ce point normalisee pour la colonne en parametre.
     *
     * La normalisation se fait avec le <i>normaliseur</i> de la colonne.
     * Si la colonne n'est pas normalisable, le comportement n'est pas defini.
     */

    double getNormalizedValue(Column<? extends Point> xColumn);
}
