package main.java.fr.grph3.univlille.models.points;

import com.opencsv.bean.CsvBindByName;

import main.java.fr.grph3.univlille.models.columns.IColumn;

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

    //String[] nomDesColonnesIris = new String[] {"sepal.length", "sepal.width", "petal.length", "petal.width", "variety" };

    //public List<Iris> listIris;

    public Iris(double sepalLength, double sepalWidth, double petalLength, double petalWidth, String variety) {
		super();
		this.sepalLength = sepalLength;
		this.sepalWidth = sepalWidth;
		this.petalLength = petalLength;
		this.petalWidth = petalWidth;
		this.variety = variety;
	}

	public Iris() {
		// TODO Auto-generated constructor stub
	}
    
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
    	switch(column.getName()) {
		case "sepal.length" : return sepalLength;
		case "sepal.width" : return sepalWidth;
		case "petal.length" : return petalLength;
		case "petal.width" : return petalWidth;
		case "variety" : return variety;
		default : return null;
		}
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