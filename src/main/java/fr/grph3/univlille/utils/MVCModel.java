package main.java.fr.grph3.univlille.utils;

import main.java.fr.grph3.univlille.models.IDataSet;
import main.java.fr.grph3.univlille.models.categories.ICategory;
import main.java.fr.grph3.univlille.models.columns.IColumn;
import main.java.fr.grph3.univlille.models.columns.NullColumn;
import main.java.fr.grph3.univlille.models.points.IPoint;

import java.util.*;
import java.util.stream.Collectors;

public abstract class MVCModel<T extends IPoint> implements IDataSet<T> {

    protected List<T> points;

    protected List<IColumn> columns;

    protected List<ICategory<T>> categories;

    public MVCModel() {
        this.points = new ArrayList<>();
        this.columns = new ArrayList<>();
        this.categories = new ArrayList<>();
    }

    public List<T> getPoints(){
        return points;
    }

    public abstract void init();

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

    public IColumn getColumnByName(String name) {
        return columns.stream()
                .filter(c -> name.equals(c.getName()))
                .findAny()
                .orElse(new NullColumn());
    }

    public List<IColumn> getColumns() {
        return columns;
    }

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

    @Override
    public Iterator<T> iterator() {
        return points.iterator();
    }
}
