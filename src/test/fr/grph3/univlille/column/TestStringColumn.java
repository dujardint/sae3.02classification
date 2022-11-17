package test.fr.grph3.univlille.column;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.jupiter.api.Test;

import fr.grph3.univlille.models.columns.StringColumn;



public class TestStringColumn {
	
	StringColumn col = new StringColumn("Test");
	
	@Test
	void test_get_name() {
		assertEquals("Test", col.name);
	}


	@Test
	void should_return_not_normalizable() {
		assertFalse(col.isNormalizable());
	}
	

}
