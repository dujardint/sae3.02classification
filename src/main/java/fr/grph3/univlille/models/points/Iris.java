package fr.grph3.univlille.models.points;

import com.opencsv.bean.CsvBindByName;

import fr.grph3.univlille.models.columns.IColumn;

public class Iris implements IPoint {

    public enum Variety {
        SETOSA, VERSICOLOR, VIRGINICA
    }

    @CsvBindByName(column = "sepal.length")
    private double sepalLength;
    @CsvBindByName(column = "sepal.width")
    private double sepalWidth;
    @CsvBindByName(column = "petal.length")
    private double petalLength;
    @CsvBindByName(column = "petal.width")
    private double petalWidth;
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

    @Override
    public String getCategory() {
        return variety;
    }

    @Override
    public void setCategory(String variety) {
        this.variety = variety;
    }

    @Override
    public Object getValue(IColumn column) {
        if ("sepal.length".equals(column.getName())) return sepalLength;
        if ("sepal.width".equals(column.getName())) return sepalWidth;
        if ("petal.length".equals(column.getName())) return petalLength;
        if ("petal.width".equals(column.getName())) return petalWidth;
        if ("variety".equals(column.getName())) return variety;
        return 0;
    }

    @Override
    public String toString() {
        return 
                "sepalLength = " + sepalLength + 
                " \nsepalWidth  = " + sepalWidth +
                " \npetalLength = " + petalLength +
                " \npetalWidth  = " + petalWidth +
                " \nVariety = " + variety.toUpperCase();
    }
}