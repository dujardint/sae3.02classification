package fr.grph3.univlille.models.points;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBeanBuilder;

import fr.grph3.univlille.models.columns.DoubleColumn;
import fr.grph3.univlille.models.columns.IColumn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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


	public List<Double> normalisationColonneIris(List<Iris> listIris, String colonne){
		//Pour normaliser tout une colonne, on extrait d'abord la colonne puis on la normalise car on a besoin de son max et min
		List<Double> extraction = extractionColonneIris(listIris, colonne);
		List<Double> normalisation = normaliseColonneIris(extraction);
		return normalisation;
	}

	public List<Double> normaliseColonneIris(List<Double> extractionColonneIris){
		//2e etape sur 2 pour normaliser : apres avoir obtenu toutes les valeurs de la colonne on peut normaliser
		DoubleColumn a = new DoubleColumn(); //on cree un objet pour utiliser ses methodes
		Double maxi = a.getMax(extractionColonneIris);
		Double mini = a.getMin(extractionColonneIris);

		List<Double> colonneNormalise = new ArrayList<>();

		for(int i=0; i<extractionColonneIris.size(); i++) {
			Double valueNormalise = (extractionColonneIris.get(i) - mini) / (maxi - mini);
			colonneNormalise.add(valueNormalise);
		}
		return colonneNormalise;
	}

	public List<Double> extractionColonneIris(List<Iris> listIris, String colonne) {
		//1er étape sur 2 pour normaliser : ici on extrait la colonne
		List<Double> colonneNonNormalise = new ArrayList<>();
		double value = 0;
		for(int i=0; i<listIris.size();i++) {
			if(colonne.equals(nomDesColonnesIris[0])) {
				value = listIris.get(i).getSepalLength();
			}
			if(colonne.equals(nomDesColonnesIris[1])) {
				value = listIris.get(i).getSepalWidth();
			}
			if(colonne.equals(nomDesColonnesIris[2])) {
				value = listIris.get(i).getPetalLength();
			}
			if(colonne.equals(nomDesColonnesIris[3])) {
				value = listIris.get(i).getPetalWidth();
			}
			if(colonne.equals(nomDesColonnesIris[4])) {

				int nbEnum = VarietyIris.values().length;
				for(int k=0; k<nbEnum; k++) {
					if(listIris.get(i).getVariety().equals(VarietyIris.values()[k].name())) {
						value = (double) ( (k+1)-1 / (nbEnum-1) );
					}
				}
			}
			colonneNonNormalise.add(value);
		}
		return colonneNonNormalise;
	}
}
