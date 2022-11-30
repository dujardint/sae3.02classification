package fr.grph3.univlille.columns;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import fr.grph3.univlille.models.IDataSet;
import fr.grph3.univlille.models.columns.NumberColumn;

public class TestNumberColumn {

	
	private IDataSet id;
	private NumberColumn nb = new NumberColumn("test", id);


	@BeforeEach
	public void setup() {
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
