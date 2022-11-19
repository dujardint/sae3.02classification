package fr.grph3.univlille.columns;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.fr.grph3.univlille.models.columns.StringColumn;

public class TestStringColumn {
	
	StringColumn col = new StringColumn("test");
	
	@Test
	public void  test_get_name() {
		assertEquals(null, col.getName());
	}
	
	@Test
	public void  test_get_normaliezed_value() {
		assertEquals(0, col.getNormalizedValue("test"));
	}
	
	@Test
	public void  test_get_denormaliezed_value() {
		assertEquals(null, col.getDenormalizedValue(0.0));
	}
	
	@Test
	public void  test_is_normalizable() {
		assertEquals(false,col.isNormalizable());
	}
	
	

}
