package main.java.fr.grph3.univlille.models.categories;

import fr.grph3.univlille.models.points.Titanic;

import java.util.Iterator;
import java.util.List;

public class TitanicCategory implements ICategory<Titanic> {

    @Override
    public String getTitle() {
        return null;
    }

    public int getTotalPoints() {
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
    public Iterator<Titanic> iterator() {
        return null;
    }
}
