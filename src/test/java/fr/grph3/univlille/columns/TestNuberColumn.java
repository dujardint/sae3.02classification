package fr.grph3.univlille.columns;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import fr.grph3.univlille.models.columns.NumberColumn;

public class TestNuberColumn {

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
		assertEquals("test", nb.toString());
	}

	@Test
	public void  test_is_normalizable() {
		assertEquals(true, nb.isNormalizable());
	}


}
