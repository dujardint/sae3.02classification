package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.points.Titanic;

import java.util.Iterator;
import java.util.List;

public class TitanicMVCModel extends MVCModel<Titanic> {

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
    public void loadFromFile(String path, Class<Titanic> dataType) {

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
    public Iterator<Titanic> iterator() {
        return null;
    }
}
