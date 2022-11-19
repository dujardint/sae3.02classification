package test.java.fr.grph3.univlille.columns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import main.java.fr.grph3.univlille.models.columns.BooleanColumn;

public class TestBooleanColumn {
	
BooleanColumn col = new BooleanColumn("Test");
	

	@Test
	void test_get_normalized_value() {
		assertEquals(1.0, col.getNormalizedValue(true));
		assertEquals(0.0, col.getNormalizedValue(false));
	}
	
	@Test
	void test_get_denormalized_value() {
		assertEquals(false, col.getDenormalizedValue(0.0));
		assertEquals(true, col.getDenormalizedValue(1.0));
	}
	
	@Test
	void test_get_name() {
		assertEquals("Test", col.getName());
	}
	
	@Test
	void test_isnormalisable() {
		assertEquals(true, col.isNormalizable());
	}
	
	@Test
	void test_dataset() {
		assertEquals("", col.getDataset());
	}

}
