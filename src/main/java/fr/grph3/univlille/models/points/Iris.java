package main.java.fr.grph3.univlille.models.points;


import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBeanBuilder;

import main.java.fr.grph3.univlille.models.columns.MistakeNormalizableValueException;


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

	String[] nomDesColonnesIris = new String[] {"sepal.length", "sepal.width", "petal.length", "petal.width", "variety" };

	public List<Iris> listIris;

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
	public String toString() {
		return "fr.grph3.univlille.models.points.Iris [sepalLength=" + sepalLength + ", sepalWidth=" + sepalWidth + ", petalLength=" + petalLength
				+ ", petalWidth=" + petalWidth + ", variety=" + variety + "]";
	}

	public void loadIris(String path) throws IllegalStateException, IOException {
		listIris = new CsvToBeanBuilder<Iris>(Files.newBufferedReader(Paths.get(path))).withSeparator(',')
				.withType(Iris.class).build().parse();
	}

	public double normaliseUnIris(List<Iris> listIris, String colonne, double valeur) {
		double max = 0;
		double min = 0;
		switch (colonne) {
		case "sepal.length" -> {
			max = listIris.get(0).getSepalLength();
			min = listIris.get(0).getSepalLength();
		}
		case "sepal.width" -> {
			max = listIris.get(0).getSepalWidth();
			min = listIris.get(0).getSepalWidth();
		}
		case "petal.length" -> {
			max = listIris.get(0).getPetalLength();
			min = listIris.get(0).getPetalLength();
		}
		case "petal.width" -> {
			max = listIris.get(0).getPetalWidth();
			min = listIris.get(0).getPetalWidth();
		}
		case "variety" -> {
			max = 0; //listIris.get(0).getVariety();
			min = 0; //listIris.get(0).getVariety();
		}
		default -> {
			System.out.println("colonne non trouve !");
			return 0;
		}
		}

		double value = 0;
		for (Iris irisIterative : listIris) {
			switch (colonne) {
			case "sepal.length" -> value = irisIterative.getSepalLength();
			case "sepal.width" -> value = irisIterative.getSepalWidth();
			case "petal.length" -> value = irisIterative.getPetalLength();
			case "petal.width" -> value = irisIterative.getPetalWidth();
			}
			if (max < value) max = value;
			if (min > value) min = value;
		}
		return (valeur - min) / (max - min);
	}


	@Override
	public Object getValue(main.java.fr.grph3.univlille.models.columns.IColumn column) {
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
	public double getNormalizedValue(main.java.fr.grph3.univlille.models.columns.IColumn xColumn) {
		try {
			return xColumn.getNormalizedValue(this);
		} catch (MistakeNormalizableValueException e) {
			e.printStackTrace();
		}
		return petalLength;
	}
}