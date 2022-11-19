package test.java.fr.grph3.univlille.points;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.fr.grph3.univlille.models.columns.NumberColumn;
import main.java.fr.grph3.univlille.models.points.Iris;

public class TestIrisPoint {
	Iris setosa = new Iris(5.1, 3.5, 1.4, 0.2, "Setosa");
	Iris setosa1 = new Iris(10, 5, 1, 1.2, "Setosa");
	Iris setosa2 = new Iris(3, 3, 0.4, 4.2, "Setosa");
	Iris virginica = new Iris(6.3, 3.3, 6, 2.5, "Virginica");
	Iris versicolor = new Iris(5.7, 2.8, 4.1, 1.3, "Versicolor");
	NumberColumn spL = new NumberColumn("sepal.length");
	NumberColumn spW = new NumberColumn("sepal.width") {};
	NumberColumn ptL = new NumberColumn("petal.length") {};
	NumberColumn ptW = new NumberColumn("petal.width") {};
	NumberColumn var = new NumberColumn("variety");
	
	@Test
	public void test_toString() {
		assertEquals("Iris{sepalLength=5.1, sepalWidth=3.5, petalLength=1.4, petalWidth=0.2, variety='Setosa'}", setosa.toString());
	}
	
	@Test
	public void test_get_value() {
		assertEquals(5.1, setosa.getValue(spL));
		assertEquals(10.0, setosa1.getValue(spL));
		assertEquals(0.4, setosa2.getValue(ptL));
		assertEquals(6.0, virginica.getValue(ptL));
	}
	
	
	@Test
	public void test_getter() {
		assertEquals(1.4, setosa.getPetalLength());
		assertEquals(0.2, setosa.getPetalWidth());
		assertEquals(5.1, setosa.getSepalLength());
		assertEquals(3.5, setosa.getSepalWidth());
	}

}
