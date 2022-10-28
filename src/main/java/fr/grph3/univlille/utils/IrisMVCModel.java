package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.Column;
import fr.grph3.univlille.models.Iris;

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
    public void setLines(List<Iris> lines) {

    }

    @Override
    public void addLine(Iris element) {

    }

    @Override
    public void addAllLine(List<Iris> element) {

    }

    @Override
    public void loadFromFile(String dataFile) {

    }

    @Override
    public void loadFromString(String data) {

    }

    @Override
    public Column<Iris> defaultXCol() {
        return null;
    }

    @Override
    public Column<Iris> defaultYCol() {
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
