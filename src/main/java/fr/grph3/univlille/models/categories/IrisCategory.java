package fr.grph3.univlille.models.categories;

import fr.grph3.univlille.models.categories.ICategory;
import fr.grph3.univlille.models.points.Iris;

import java.util.Iterator;
import java.util.List;

public class IrisCategory implements ICategory<Iris> {

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public int getTotalPoints() {
        return 0;
    }

    @Override
    public void setPoints(List<Iris> points) {

    }

    @Override
    public void addPoint(Iris point) {

    }
    @Override
    public void addPoints(List<Iris> points) {

    }

    @Override
    public Iterator<Iris> iterator() {
        return null;
    }
}
