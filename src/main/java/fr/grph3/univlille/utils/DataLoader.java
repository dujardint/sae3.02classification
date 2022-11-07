package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.Column;
import fr.grph3.univlille.models.Point;

import java.util.Iterator;
import java.util.List;

public class DataLoader<T extends Point> extends MVCModel<T> {

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public int getNbLines() {
        return 0;
    }

    @Override
    public void setLines(List<T> lines) {

    }

    @Override
    public void addLine(T element) {

    }

    @Override
    public void addAllLine(List<T> element) {

    }

    @Override
    public void loadFromFile(String dataFile) {

    }

    @Override
    public void loadFromString(String data) {

    }

    @Override
    public Column<T> defaultXCol() {
        return null;
    }

    @Override
    public Column<T> defaultYCol() {
        return null;
    }

    @Override
    public int nbColumns() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
