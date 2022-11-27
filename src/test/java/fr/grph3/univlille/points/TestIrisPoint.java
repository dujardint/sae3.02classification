package fr.grph3.univlille.points;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.columns.NumberColumn;
import fr.grph3.univlille.models.points.Iris;
import fr.grph3.univlille.models.points.builders.IrisBuilder;

public class TestIrisPoint {


	private IColumn column = new NumberColumn("petal.length");
	
	private Iris iris = new IrisBuilder()
	.withPetalLength(15.0)
	.withPetalWidth(10)
	.withSepalLength(0)
	.withSepalWidth(0)
	.withVariety(null)
	.build();


	@BeforeEach
	public void setUp() {
		

	}
	
	@Test
	public void getValue() {
		assertEquals(15.0, iris.getValue(column));
	}
	
	@Test 
	public void test_toString() {
		assertEquals("Iris{sepalLength=0.0, sepalWidth=0.0, petalLength=15.0, petalWidth=10.0, variety='null'}", iris.toString());
	}
	
	
}
