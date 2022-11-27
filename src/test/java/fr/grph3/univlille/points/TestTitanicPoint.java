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
			.withCabin(null)
			.withEmbarked(null)
			.withFare(0)
			.withName(null)
			.withParch(0)
			.withPassengerId(0)
			.withPClass(0)
			.withSex(null)
			.withSibSp(0)
			.withSurvived(0)
			.withTicket(null)
			.build();
	
	@Test
	public void getValue() {
		assertEquals(22.0, titanic.getValue(column));
	}
	
	@Test
	public void test_toString() {
		assertEquals("Titanic{passengerId=0.0, survived=0.0, pclass=0.0, name='null', sex='null', age=22.0, sibSp=0.0, parch=0.0, ticket='null', fare=0.0, cabin='null', embarked='null'}", titanic.toString());
	}
	
}
