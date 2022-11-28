package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.columns.INormalizableColumn;
import fr.grph3.univlille.models.points.Iris;

import java.util.List;

public class IIrisParser extends IPointParser<Iris> {

    public IIrisParser(List<INormalizableColumn> columns) {
        super(columns);
    }

    /**
     * Faire attention aux exceptions, récupère chaque argument de la ligne et le transforme en point
     * récupérer l'argument correspondant à la colonne avec la methode format
     */

    @Override
    public Iris parse(String line) {
        return null;
    }
}
