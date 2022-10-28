package fr.grph3.univlille.models;

import java.util.Iterator;
import java.util.List;

public class IrisCategory implements Category<Iris> {

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
    public Iterator<Iris> iterator() {
        return null;
    }
}
