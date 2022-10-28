package fr.grph3.univlille.models;

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
    public void setLines(List<? extends Point> lines) {

    }

    @Override
    public void addLine(Titanic element) {

    }

    @Override
    public void addAllLine(List<Titanic> element) {

    }

    @Override
    void loadFromString(String data) {

    }

    @Override
    void loadFromFile(String dataFile) {

    }

    @Override
    Column<Titanic> defaultXCol() {
        return null;
    }

    @Override
    Column<Titanic> defaultYCol() {
        return null;
    }

    @Override
    Collection<Category<Titanic>> allCategories() {
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
