package fr.grph3.univlille.models;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class IrisMVCModel extends MVCModel<Iris> {

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
    public void addLine(Iris element) {

    }

    @Override
    public void addAllLine(List<Iris> element) {

    }

    @Override
    void loadFromString(String data) {

    }

    @Override
    void loadFromFile(String dataFile) {

    }

    @Override
    Column<Iris> defaultXCol() {
        return null;
    }

    @Override
    Column<Iris> defaultYCol() {
        return null;
    }

    @Override
    Collection<Category<Iris>> allCategories() {
        return null;
    }

    @Override
    public int nbColumns() {
        return 0;
    }

    @Override
    public Iterator<Iris> iterator() {
        return null;
    }
}
