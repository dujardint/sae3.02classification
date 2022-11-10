package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.categories.ICategory;
import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.IDataSet;
import fr.grph3.univlille.models.points.IPoint;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class MVCModel<T extends IPoint> implements IDataSet<T> {

    private List<IColumn> columns;

    private List<ICategory<T>> categories;

    /**
     * Charge les donnees du modele d'un fichier CSV.
     */

    public abstract void loadFromFile(String path, Class<T> dataType);

    /**
     * Charge les donnees du modele d'une String "CSV".
     * Cette methode est surtout un utilitaire de test pour eviter d'avoir a
     * creer des fichiers CSV pour tous les cas de test.
     * Il suffit d'appeller cette methode avec une String contenant les lignes
     * d'un "fichier CSV" que l'on veut tester.
     */

    public abstract void loadFromString(String data);

    /**
     * Retourne la colonne a utiliser par defaut pour l'axe des X lors de
     * l'affichage du nuage de points.
     */

    public abstract IColumn defaultXCol();

    /**
     * Retourne la colonne a utiliser par defaut pour l'axe des Y lors de
     * l'affichage du nuage de points.
     */

    public abstract IColumn defaultYCol();

    /**
     * Ajoute une Categorie (ou classe) de donnees au model.
     */

    public void addCategory(ICategory<T> category) {
        categories.add(category);
    }

    /**
     * Retourne toutes les categories du modele.
     */

    public Collection<ICategory<T>> allCategories() {
        return categories;
    }

    /**
     * Nombre de colonnes dans le modele (egale au nombre de colonnes du
     * fr.grph3.univlille.models.DataSet associe a ce modele)
     */

    public abstract int nbColumns();

    /**
     * Retourne la collection de toutes les colonnes du fr.grph3.univlille.models.DataSet dont les
     * valeurs peuvent etre normalisees.
     * Seules les colonnes normalisables peuvent servir d'axes dans le
     * nuage de points.
     * La normalisation doit retourner une valeur dans l’intervalle [0;1]
     */

    public List<IColumn> getNormalizableColumns() {
        return columns.stream()
                .filter(IColumn::isNormalizable)
                .collect(Collectors.toList());
    }
}
