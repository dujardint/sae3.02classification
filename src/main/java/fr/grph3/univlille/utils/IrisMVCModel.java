package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.points.Iris;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IrisMVCModel extends MVCModel<Iris> {

    private List<Iris> lines;

    public IrisMVCModel() {
        this.lines = new ArrayList<>();
    }

    @Override
    public String getTitle() {
        return "Iris Data";
    }

    @Override
    public int getNbLines() {
        return lines.size();
    }

    @Override
    public void setLines(List<Iris> lines) {
        this.lines = lines;
    }

    @Override
    public void addLine(Iris line) {
        this.lines.add(line);
    }

    @Override
    public void addAllLine(List<Iris> lines) {
        this.lines.addAll(lines);
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
        return 5;
    }

    @Override
    public Iterator<Iris> iterator() {
        return lines.iterator();
    }
}
