import java.util.List;

public class Iris implements Point {

    @Override
    public Object getValue(Column<? extends Point> column) {
        return null;
    }

    @Override
    public double getNormalizedValue(Column<? extends Point> xColumn) {
        return 0;
    }
    

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
	
	public Iris() {
	}
	
	


	public double getSepal_length() {
		return sepalLength;
	}

	public double getSepal_width() {
		return sepalWidth;
	}

	public double getPetal_length() {
		return petalLength;
	}

	public double getPetal_width() {
		return petalWidth;
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
		return "Iris [sepalLength=" + sepalLength + ", sepalWidth=" + sepalWidth + ", petalLength=" + petalLength
				+ ", petalWidth=" + petalWidth + ", variety=" + variety + "]";
	}

	
}
