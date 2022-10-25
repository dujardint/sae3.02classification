import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class MVCModel<T extends Point> implements DataSet<T> {

    private List<Column<T>> columns;

    /**
     * Charge les donnees du modele d'un fichier CSV.
     */

    public void loadFromFile(String datafile) {

    }

    /**
     * Charge les donnees du modele d'une String "CSV".
     * Cette methode est surtout un utilitaire de test pour eviter d'avoir a
     * creer des fichiers CSV pour tous les cas de test.
     * Il suffit d'appeller cette methode avec une String contenant les lignes
     * d'un "fichier CSV" que l'on veut tester.
     */

    abstract void loadFromString(String data);

    /**
     * Retourne la colonne a utiliser par defaut pour l'axe des X lors de
     * l'affichage du nuage de points.
     */

    abstract Column<T> defaultXCol();

    /**
     * Retourne la colonne a utiliser par defaut pour l'axe des Y lors de
     * l'affichage du nuage de points.
     */

    abstract Column<T> defaultYCol();

    /**
     * Ajoute une Categorie (ou classe) de donnees au model.
     */

    public void addCategory(Category category) {

    }

    /**
     * Retourne toutes les categories du modele.
     */

    abstract Collection<Category> allCategories();

    /**
     * Nombre de colonnes dans le modele (egale au nombre de colonnes du
     * DataSet associe a ce modele)
     */

    abstract public int nbColumns();

    /**
     * Retourne la collection de toutes les colonnes du DataSet dont les
     * valeurs peuvent etre normalisees.
     * Seules les colonnes normalisables peuvent servir d'axes dans le
     * nuage de points.
     * La normalisation doit retourner une valeur dans l’intervalle [0;1]
     */

    public List<Column<T>> getNormalizableColumns() {
        return columns.stream()
                .filter(Column::isNormalizable)
                .collect(Collectors.toList());
    }
}
