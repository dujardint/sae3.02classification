package fr.grph3.univlille.column;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import main.java.fr.grph3.univlille.models.columns.NumberColumn;

public class TestNumberColumn {
	
	NumberColumn nb = new NumberColumn("test");
	
	
	@BeforeEach
	public void setup() {
		nb.addValues(1.5);
		nb.addValues(3.5);
	}
	
	
	@Test
	public void  test_get_name() {
		assertEquals("test", nb.getName());
	}
	
	@Test
	public void  test_to_string() {
		assertEquals("NumberColumn{name='test', values=[]}", nb.toString());
	}
	
	@Test
	public void  test_is_normalizable() {
		assertEquals(true, nb.isNormalizable());
	}
	
}