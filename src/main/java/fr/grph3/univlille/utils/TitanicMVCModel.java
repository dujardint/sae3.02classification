package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.Category;
import fr.grph3.univlille.models.Column;
import fr.grph3.univlille.models.Point;
import fr.grph3.univlille.models.Titanic;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class TitanicMVCModel extends MVCModel<Titanic> {

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public int getNbLines() {
        return 0;
    }

    @Override
    public void setLines(List<Titanic> lines) {

    }

    @Override
    public void addLine(Titanic element) {

    }

    @Override
    public void addAllLine(List<Titanic> element) {

    }

    @Override
    public void loadFromFile(String dataFile) {

    }

    @Override
    public void loadFromString(String data) {

    }

    @Override
    public Column<Titanic> defaultXCol() {
        return null;
    }

    @Override
    public Column<Titanic> defaultYCol() {
        return null;
    }

    @Override
    public int nbColumns() {
        return 0;
    }

    @Override
    public Iterator<Titanic> iterator() {
        return null;
    }
}
