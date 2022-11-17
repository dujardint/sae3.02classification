

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import fr.grph3.univlille.models.columns.DoubleColumn;

public class TestDoubleColumn {
	
DoubleColumn col = new DoubleColumn("column");
DoubleColumn coll;
	
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
		assertEquals(0, col.getNormalizedValue(0));
		assertEquals(1, col.getNormalizedValue(10));
		assertEquals(0.5, col.getNormalizedValue(5));
	}
	
	@Test
	void should_return_denormalizable_value() {
		assertEquals(0.0, col.getDenormalizedValue(0));
		assertEquals(10.0, col.getDenormalizedValue(1));
		assertEquals(5.0, col.getDenormalizedValue(0.5));
	}
	
	
}
