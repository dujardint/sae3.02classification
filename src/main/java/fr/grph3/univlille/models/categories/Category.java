package fr.grph3.univlille.models.categories;

import fr.grph3.univlille.models.points.IPoint;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Category implements ICategory {

    private String title;

    private List<IPoint> points;

    public Category(String title) {
        this.title = title;
        this.points = new ArrayList<>();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getTotalPoints() {
        return points.size();
    }

    @Override
    public IPoint getPoint(int index) {
        return points.get(0);
    }

    @Override
    public List<IPoint> getPoints() {
        return points;
    }

    @Override
    public void setPoints(List<IPoint> points) {
        points.clear();
        addPoints(points);
    }

    @Override
    public void addPoint(IPoint point) {
        if (title.equals(point.getCategory())) points.add(point);
    }

    @Override
    public void addPoints(List<IPoint> points) {
        points.forEach(this::addPoint);
    }

    @Override
    public Iterator<IPoint> iterator() {
        return points.iterator();
    }

    @Override
    public String toString() {
        return title.toUpperCase();
    }
}
