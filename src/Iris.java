
import java.util.List;

import com.opencsv.bean.CsvBindByName;
public class Iris {

	@CsvBindByName(column = "sepal.length") 
	public double sepal_length;
	@CsvBindByName(column = "sepal.width")
	public double sepal_width;
	@CsvBindByName(column = "petal.length")
	public double petal_length;
	@CsvBindByName(column = "petal.width")
	public double petal_width;
	@CsvBindByName(column = "variety")
	public String variety;
	
	public Iris() {
	}
	
	public Iris (int sepal_length,int sepal_width, int petal_length,int petal_width,String variety) {
		this.petal_length = petal_length;
		this.petal_width =petal_width;
		this.sepal_length =sepal_length;
		this.sepal_width =sepal_width;
		this.variety = variety;
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

	public String getVariety() {
		return variety;
	}

	public List<Iris> getClosest(List<Iris> elements, int number) {
	    // TODO Auto-generated method stub
	    return null;
	}

	@Override
	public String toString() {
		return "Iris [sepal_length=" + sepal_length + ", sepal_width=" + sepal_width + ", petal_length=" + petal_length
				+ ", petal_width=" + petal_width + ", variety=" + variety + "]";
	}

	
}
