package fr.grph3.univlille.models.points;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBeanBuilder;

import fr.grph3.univlille.models.columns.IColumn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Iris implements IPoint {

    @CsvBindByName(column = "sepal.length")
    public double sepalLength;
    @CsvBindByName(column = "sepal.width")
    public double sepalWidth;
    @CsvBindByName(column = "petal.length")
    public double petalLength;
    @CsvBindByName(column = "petal.width")
    public double petalWidth;
    @CsvBindByName(column = "variety")
    public String variety;

    public double getSepalLength() {
        return sepalLength;
    }

    public void setSepalLength(double sepalLength) {
        this.sepalLength = sepalLength;
    }

    public double getSepalWidth() {
        return sepalWidth;
    }

    public void setSepalWidth(double sepalWidth) {
        this.sepalWidth = sepalWidth;
    }

    public double getPetalLength() {
        return petalLength;
    }

    public void setPetalLength(double petalLength) {
        this.petalLength = petalLength;
    }

    public double getPetalWidth() {
        return petalWidth;
    }

    public void setPetalWidth(double petalWidth) {
        this.petalWidth = petalWidth;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public List<Iris> getClosest(List<Iris> elements, int number) {
        return null;
    }

    @Override
    public Object getValue(IColumn column) {
        return null;
    }

    @Override
    public double getNormalizedValue(IColumn xColumn) {
        return 0;
    }

    @Override
    public String toString() {
        return "fr.grph3.univlille.models.points.Iris [sepalLength=" + sepalLength + ", sepalWidth=" + sepalWidth + ", petalLength=" + petalLength
                + ", petalWidth=" + petalWidth + ", variety=" + variety + "]";
    }
    
    public static  List<Iris> loadIris(String path) throws IllegalStateException, IOException {
		return new CsvToBeanBuilder<Iris>(Files.newBufferedReader(Paths.get(path))).withSeparator(',')
				.withType(Iris.class).build().parse();
	}
    
}
