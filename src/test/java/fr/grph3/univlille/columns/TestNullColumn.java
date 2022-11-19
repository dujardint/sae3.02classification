package test.java.fr.grph3.univlille.columns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import main.java.fr.grph3.univlille.models.columns.NullColumn;

public class TestNullColumn {
	
	NullColumn col = new NullColumn();
	

	@Test
	void test_get_normalized_value() {
		assertEquals(0, col.getNormalizedValue(true));
		assertEquals(0, col.getNormalizedValue(false));
	}
	
	@Test
	void test_get_denormalized_value() {
		assertEquals(null, col.getDenormalizedValue(0.0));
		assertEquals(null, col.getDenormalizedValue(1.0));
	}
	
	
	@Test
	void test_get_name() {
		assertEquals("Null Column", col.getName());
	}
	

	@Test
	void test_isnormalisable() {
		assertEquals(false, col.isNormalizable());
	}

}
