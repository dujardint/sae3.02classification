package fr.grph3.univlille.columns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.columns.NullColumn;
import fr.grph3.univlille.models.columns.NumberColumn;
import fr.grph3.univlille.models.points.Iris;
import fr.grph3.univlille.models.points.builders.IrisBuilder;

public class TestNullColumn {
	

	private IColumn column = new NullColumn();
	
	private Iris iris = new IrisBuilder()
			.withPetalLength(15.0)
			.build();
	

	
	
	
	@Test
	public void test_get_name() {
		assertEquals("Null Column", column.getName());
	}
	

	@Test
	public void test_isnormalisable() {
		assertEquals(false, column.isNormalizable());
	}


}
