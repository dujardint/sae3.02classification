package fr.grph3.univlille.points;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.columns.NumberColumn;
import fr.grph3.univlille.models.points.Iris;
import fr.grph3.univlille.models.points.builders.IrisBuilder;

public class TestIrisPoint {


	private IColumn column = new NumberColumn("petal.length");
	
	private Iris iris = new IrisBuilder()
	.withPetalLength(15.0)
	.build();


	@BeforeEach
	public void setUp() {
		

	}
	
	@Test
	public void getValue() {
		assertEquals(15.0, iris.getValue(column));
	}

}
