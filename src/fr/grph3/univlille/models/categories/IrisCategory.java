package fr.grph3.univlille.models.categories;

import java.util.Iterator;
import java.util.List;

import fr.grph3.univlille.models.points.Iris;

public class IrisCategory implements ICategory<Iris> {

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
