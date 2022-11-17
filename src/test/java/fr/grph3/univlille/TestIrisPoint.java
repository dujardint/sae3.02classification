package test.java.fr.grph3.univlille;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

import fr.grph3.univlille.models.columns.DoubleColumn;
import fr.grph3.univlille.models.columns.MistakeNormalizableValueException;
import fr.grph3.univlille.models.columns.StringColumn;
import fr.grph3.univlille.models.points.Iris;

public class TestIrisPoint {
	
	Iris setosa = new Iris(5.1, 3.5, 1.4, .2, "Setosa");
	Iris setosa1 = new Iris(10, 5, 1, 1.2, "Setosa");
	Iris setosa2 = new Iris(3, 3, 0.4, 4.2, "Setosa");
	Iris virginica = new Iris(6.3, 3.3, 6, 2.5, "Virginica");
	Iris versicolor = new Iris(5.7, 2.8, 4.1, 1.3, "Versicolor");
	DoubleColumn spL = new DoubleColumn("sepal.length") {};
	DoubleColumn spW = new DoubleColumn("sepal.width") {};
	DoubleColumn ptL = new DoubleColumn("petal.length") {};
	DoubleColumn ptW = new DoubleColumn("petal.width") {};
	StringColumn var = new StringColumn("variety");
	
	@Test
	void test_toString() {
		assertEquals("Setosa[5.1,3.5,1.4,0.2]", setosa.toString());
	}
	
	@Test
	void test_get_value() {
		assertEquals(5.1, setosa.getValue(spL));
		assertEquals(10.0, setosa1.getValue(spL));
		assertEquals(0.4, setosa2.getValue(ptL));
		assertEquals(6.0, virginica.getValue(ptL));
	}
	
	@Test
	void get_normalized_test() {
		assertEquals(0.4555, setosa.getNormalizedValue(spL), 0.0001);
		assertThrows(MistakeNormalizableValueException.class, () -> setosa.getNormalizedValue(var));
	}

}
