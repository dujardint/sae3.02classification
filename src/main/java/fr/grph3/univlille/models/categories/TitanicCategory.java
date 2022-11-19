package main.java.fr.grph3.univlille.models.categories;

import java.util.Iterator;
import java.util.List;

import main.java.fr.grph3.univlille.models.points.Titanic;

public class TitanicCategory implements ICategory<Titanic> {

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public int getTotalPoints() {
        return 0;
    }

    @Override
    public void setPoints(List<Titanic> points) {

    }

    @Override
    public void addPoint(Titanic point) {

    }

    @Override
    public void addPoints(List<Titanic> points) {

    }

    @Override
    public Iterator<Titanic> iterator() {
        return null;
    }
}
