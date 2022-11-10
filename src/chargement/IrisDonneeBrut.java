package chargement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBeanBuilder;

import Interfaces.IColumn;
import Interfaces.IPoint;

public class IrisDonneeBrut implements IPoint{

	@CsvBindByName(column = "sepal.length") 
	public double sepal_length;
	@CsvBindByName(column = "sepal.width")
	public double sepal_width;
	@CsvBindByName(column = "petal.length")
	public double petal_length;
	@CsvBindByName(column = "petal.width")
	public double petal_width;
	@CsvBindByName(column = "variety")
	public VarietyIris variety;
	
	public IrisDonneeBrut() {
	}
	
	public IrisDonneeBrut (int sepal_length,int sepal_width, int petal_length,int petal_width,VarietyIris variety) {
		this.petal_length = petal_length;
		this.petal_width =petal_width;
		this.sepal_length =sepal_length;
		this.sepal_width =sepal_width;
		this.variety = variety;
	}
	
	public static List<IrisDonneeBrut> loadIris(String path) throws IllegalStateException, IOException {
		return new CsvToBeanBuilder<IrisDonneeBrut>(Files.newBufferedReader(Paths.get(path))).withSeparator(',')
				.withType(IrisDonneeBrut.class).build().parse();
	}


	public double getSepal_length() {
		return sepal_length;
	}

	public double getSepal_width() {
		return sepal_width;
	}

	public double getPetal_length() {
		return petal_length;
	}

	public double getPetal_width() {
		return petal_width;
	}

	public VarietyIris getVariety() {
		return variety;
	}
	
	
	public void setSepal_length(double sepal_length) {
		this.sepal_length = sepal_length;
	}

	public void setSepal_width(double sepal_width) {
		this.sepal_width = sepal_width;
	}

	public void setPetal_length(double petal_length) {
		this.petal_length = petal_length;
	}

	public void setPetal_width(double petal_width) {
		this.petal_width = petal_width;
	}

	public void setVariety(VarietyIris variety) {
		this.variety = variety;
	}

	public List<IrisDonneeBrut> getClosest(List<IrisDonneeBrut> elements, int number) {
	    // TODO Auto-generated method stub
	    return null;
	}

	@Override
	public String toString() {
		return "Iris [sepal_length=" + sepal_length + ", sepal_width=" + sepal_width + ", petal_length=" + petal_length
				+ ", petal_width=" + petal_width + ", variety=" + variety + "]";
	}

	@Override
	public Object getValue(IColumn col) {
		switch(col.getName()) {
		case "sepal.length" : return sepal_length;
		case "sepal.width" : return sepal_width;
		case "petal.length" : return petal_length;
		case "petal.width" : return petal_width;
		case "variety" : return variety;
		default : return null;
		}
	}

	@Override
	public double getNormalizedValue(IColumn xcol) {
		if(xcol.isNormalizable()) {
			return xcol.getNormalizedValue(null);
		}
		return 0.0;
	}

	
}
