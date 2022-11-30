package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.categories.Category;
import fr.grph3.univlille.models.categories.ICategory;
import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.IDataSet;
import fr.grph3.univlille.models.columns.INormalizableColumn;
import fr.grph3.univlille.models.points.IPoint;

import java.util.*;

public abstract class AbstractMVCModel extends Subject implements IDataSet {

    protected String title;

    protected List<IPoint> points;

    protected List<IColumn> columns;

    protected List<ICategory> categories;

    protected List<INormalizableColumn> normalizableColumns;

    public AbstractMVCModel(String title) {
        this.title = title;
        this.points = new ArrayList<>();
        this.categories = new ArrayList<>();
    }

    @Override
    public String getTitle() {
        return title;
    }
    
    public List<ICategory> getCategory() {
    	return categories;
    }

    @Override
    public int getTotalPoints() {
        return points.size();
    }

    @Override
    public List<IPoint> getPoints() {
        return points;
    }

    @Override
    public void addPoint(IPoint point) {
        points.add(point);
        classifyAll(point);
    }

    @Override
    public void addPoints(List<IPoint> points) {
        this.points.addAll(points);
        classify(points);
    }

    @Override
    public void setPoints(List<IPoint> points) {
        this.points = points;
    }

    /**
     * Charge les donnees du modele d'un fichier CSV.
     */

    public abstract void loadFromFile(String path);

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

    public abstract INormalizableColumn defaultXCol();

    /**
     * Retourne la colonne a utiliser par defaut pour l'axe des Y lors de
     * l'affichage du nuage de points.
     */

    public abstract INormalizableColumn defaultYCol();

    public abstract List<IColumn> getColumns();

    protected void classify(List<IPoint> points) {
        points.forEach(this::classifyAll);
    }

    protected void classifyAll(IPoint point) {
        String category = point.getCategory();
        getCategoryByTitle(category)
                .orElseGet(() -> {
                    ICategory newCategory = new Category(category);
                    categories.add(newCategory);
                    return newCategory;
                }).addPoint(point);
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

    public List<INormalizableColumn> getNormalizableColumns() {
        return normalizableColumns;
    }

    public Optional<ICategory> getCategoryByTitle(String title) {
        return categories.stream()
                .filter(c -> title.equals(c.getTitle()))
                .findFirst();
    }

    public List<ICategory> getCategories() {
        return categories;
    }

    @Override
    public Iterator<IPoint> iterator() {
        return points.iterator();
    }
}
