package fr.grph3.univlille.models;

import java.util.Iterator;
import java.util.List;

public class TitanicCategory implements Category<Titanic> {

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
    public Iterator<Titanic> iterator() {
        return null;
    }
}
