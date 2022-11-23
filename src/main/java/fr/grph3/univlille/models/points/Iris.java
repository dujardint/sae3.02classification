package fr.grph3.univlille.models.points;

import com.opencsv.bean.CsvBindByName;

import fr.grph3.univlille.models.columns.IColumn;

public class Iris implements IPoint {

    @CsvBindByName(column = "sepal.length")
    private Double sepalLength;
    @CsvBindByName(column = "sepal.width")
    private Double sepalWidth;
    @CsvBindByName(column = "petal.length")
    private Double petalLength;
    @CsvBindByName(column = "petal.width")
    private Double petalWidth;
    @CsvBindByName(column = "variety")
    private String variety;

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

    @Override
    public Object getValue(IColumn column) {
        if ("sepal.length".equals(column.getName())) return sepalLength;
        if ("sepal.width".equals(column.getName())) return sepalWidth;
        if ("petal.length".equals(column.getName())) return petalLength;
        if ("petal.width".equals(column.getName())) return petalWidth;
        return 0;
    }

    @Override
    public String toString() {
        return "Iris{" +
                "sepalLength=" + sepalLength +
                ", sepalWidth=" + sepalWidth +
                ", petalLength=" + petalLength +
                ", petalWidth=" + petalWidth +
                ", variety='" + variety + '\'' +
                '}';
    }
}