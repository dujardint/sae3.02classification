package fr.grph3.univlille.models;

import java.util.List;

/**
 * Decrit un <i>DatSet</i>, c'est a dire un ensemble de points (ou lignes,
 * ou donnees) ayant tous la meme structure (les memes colonnes)
 *
 * Un fr.grph3.univlille.models.DataSet est <i>Iterable</i> pour pouvoir parcourir l'ensemble des
 * donnees(ou lignes ou points) .
 * Pour cette raison, il n'y a pas de getter pour l'ensemble des points
 * d'un fr.grph3.univlille.models.DataSet.
 */
public interface DataSet<T extends Point> extends Iterable<T> {

    /**
     * Le nom du fr.grph3.univlille.models.DataSet ex: fr.grph3.univlille.models.Titanic, fr.grph3.univlille.models.Iris, Pokemon, ...
     */

    String getTitle();

    /**
     * Nombre de lignes (ou donnees ou points) dans le fr.grph3.univlille.models.DataSet
     */

    int getNbLines();

    /**
     * stocke dans le fr.grph3.univlille.models.DataSet la collection de donnees passee en parametre
     */

    void setLines(List<? extends Point> lines);

    /**
     * Ajoute une donnee dans le fr.grph3.univlille.models.DataSet
     */

    void addLine(T element);

    /**
     * Ajoute une collection de donnees dans le fr.grph3.univlille.models.DataSet
     */

    void addAllLine(List<T> element);
}