package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.columns.INormalizableColumn;
import fr.grph3.univlille.models.points.IPoint;

import java.util.List;

public abstract class IPointParser<T extends IPoint> {

    private List<INormalizableColumn> columns;

    public IPointParser(List<INormalizableColumn> columns) {
        this.columns = columns;
    }

    public abstract T parse(String line);

    /**
     * Pour chaque colonne ajouter un argument ${nom_colonne} à une chaine de caractère et retourner le tout
     */

    public String format() {
        return null;
    }
}
