package fr.grph3.univlille.points;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.grph3.univlille.models.IDataSet;
import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.columns.NumberColumn;
import fr.grph3.univlille.models.points.Iris;
import fr.grph3.univlille.models.points.builders.IrisBuilder;
import fr.grph3.univlille.utils.CSVModel;



public class TestIrisPoint {

	private IDataSet id;
	private IColumn column = new NumberColumn("petal.length", id);

	private CSVModel model;

	private Iris iris = new IrisBuilder()
			.withSepalLength(0)
			.withSepalWidth(0)
			.withPetalLength(15.0)
			.withPetalWidth(10)
			.withVariety("Setosa")
			.build();


	@BeforeEach
	void setUp(){
		this.model = new CSVModel(Iris.class, "Iris");
		model.loadFromFile("src/main/resources/iris.csv");
	}

	
	@Test
	public void getValueFromModel() {
		assertEquals("Setosa", model.getPoint(0).getCategory());
	}

	@Test
	public void getValue() {
		assertEquals(15.0, iris.getValue(column));
	}

	@Test 
	public void test_toString() {
		assertEquals(
				"sepalLength = 0.0" + 
						" \nsepalWidth  = 0.0" +
						" \npetalLength = 15.0" +
						" \npetalWidth  = 10.0" +
						" \nVariety = SETOSA", iris.toString());

	}


}
