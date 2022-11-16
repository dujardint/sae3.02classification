package test.fr.grph3.univlille.column;



import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import main.java.fr.grph3.univlille.models.columns.DoubleColumn;

public class TestDoubleColumn {
	
DoubleColumn col = new DoubleColumn("column");
	
	@BeforeEach
	void setUp() {
		col.min = 0.0;
		col.max = 10.0;
	}

	@Test
	void should_return_normalizable() {
		assertTrue(col.isNormalizable());
	}
	
	@Test
	void should_return_normalizable_value() {
		assertEquals(0, col.normalize(0));
		assertEquals(1, col.normalize(10));
		assertEquals(0.5, col.normalize(5));
	}
	
	@Test
	void should_return_denormalizable_value() {
		assertEquals(0.0, col.denormalize(0));
		assertEquals(10.0, col.denormalize(1));
		assertEquals(5.0, col.denormalize(0.5));
	}
	
	
}
