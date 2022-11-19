package test.java.fr.grph3.univlille.columns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import main.java.fr.grph3.univlille.models.columns.NumberColumn;

public class TestNumberColumn {
	
	NumberColumn col = new NumberColumn("Test");
	
	@BeforeEach
	void setUp() {
		col.addValues(0.0);
		col.addValues(10.0);
	}
	
	@Test
	public void test_is_normalizable() {
		assertEquals(true ,col.isNormalizable());
	}
	
	@Test
	public void test_get_min(){
		assertEquals(0.0 ,col.getMin());
	}
	
	@Test
	public void test_get_max(){
		assertEquals(10.0 ,col.getMax());
	}
	
	@Test
	public void test_get_name() {
		assertEquals("Test", col.getName());
	}
	
	@Test
	public void get_normalized_nalue() {
		assertEquals(0,col.getDenormalizedValue(col.getMin()));
		assertEquals(1,col.getDenormalizedValue(col.getMax()));
	}
	
	@Test
	public void get_denormalized_nalue() {
		assertEquals(0.0,col.getDenormalizedValue(0));
		assertEquals(10.0,col.getDenormalizedValue(1));
	}
	
	

}
