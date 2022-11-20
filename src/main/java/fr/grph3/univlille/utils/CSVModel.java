package fr.grph3.univlille.utils;

import com.opencsv.bean.CsvToBeanBuilder;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.columns.NullColumn;
import fr.grph3.univlille.models.points.IPoint;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVModel<T extends IPoint> extends MVCModel<T> {

    private String title;

    private List<T> points;

    public CSVModel() {
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
    public void setPoints(List<T> points) {
        this.points = points;
    }

    @Override
    public void addPoint(T point) {
        points.add(point);
    }

    @Override
    public void addPoints(List<T> points) {
        this.points.addAll(points);
    }

    @Override
    public void loadFromFile(String location, Class<T> dataType) {
        Path path = Paths.get(location);
        try {
            this.points = new CsvToBeanBuilder<T>(Files.newBufferedReader(path)).withSeparator(',')
                    .withType(dataType)
                    .build()
                    .parse();
            this.title = String.valueOf(path.getFileName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void loadFromString(String data) {

    }

    @Override
    public IColumn defaultXCol() {
        return new NullColumn();
    }

    @Override
    public IColumn defaultYCol() {
        return new NullColumn();
    }

    @Override
    public List<IColumn> getColumns() {
        return null;
    }

    @Override
    public int nbColumns() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return points.iterator();
    }
}
