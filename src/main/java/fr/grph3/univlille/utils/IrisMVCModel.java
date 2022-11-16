package main.java.fr.grph3.univlille.utils;

import main.java.fr.grph3.univlille.models.columns.IColumn;
import main.java.fr.grph3.univlille.models.points.Iris;

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
    public void loadFromFile(String path, Class<Iris> dataType) {

    }

    @Override
    public void loadFromString(String data) {

    }

    @Override
    public IColumn defaultXCol() {
        return null;
    }

    @Override
    public IColumn defaultYCol() {
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
