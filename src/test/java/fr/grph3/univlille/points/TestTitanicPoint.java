package fr.grph3.univlille.points;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.columns.NumberColumn;
import fr.grph3.univlille.models.points.Iris;
import fr.grph3.univlille.models.points.Titanic;
import fr.grph3.univlille.models.points.builders.TitanicBuilder;

public class TestTitanicPoint {
	
	private IColumn column = new NumberColumn("Age");
	
	private Titanic titanic = new TitanicBuilder()
			.withAge(22)
			.build();
	
	@Test
	public void getValue() {
		assertEquals(22.0, titanic.getValue(column));
	}

}
