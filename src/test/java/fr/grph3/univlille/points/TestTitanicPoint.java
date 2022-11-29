package fr.grph3.univlille.points;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.grph3.univlille.models.IDataSet;
import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.columns.NumberColumn;
import fr.grph3.univlille.models.points.Iris;
import fr.grph3.univlille.models.points.Titanic;
import fr.grph3.univlille.models.points.builders.TitanicBuilder;

public class TestTitanicPoint {
	
	private IDataSet id;
	private IColumn column = new NumberColumn("Age", id);
	
	private Titanic titanic = new TitanicBuilder()
			.withAge(22)
			.withCabin(null)
			.withEmbarked("S")
			.withFare(10)
			.withName("Damien")
			.withParch(0)
			.withPassengerId(0)
			.withPClass(0)
			.withSex("Homme")
			.withSibSp(0)
			.withSurvived(0)
			.withTicket("2a")
			.build();
	
	@Test
	public void getValue() {
		assertEquals(22.0, titanic.getValue(column));
	}
	
	@Test
	public void test_toString() {
	assertEquals(
					 "passengerId = 0.0" +
				     "\nsurvived = 0.0" +
				     "\npclass = 0.0" +
				     "\nname = Damien" +
				     "\nsex = Homme" +
				     "\nage = 22.0" +
				     "\nsibSp = 0.0" +
				     "\nparch = 0.0" +
				     "\nticket = 2a" +
				     "\nfare = 10.0" +
				     "\ncabin = null" +
				     "\nembarked = S"  , titanic.toString());
	}
	
	
}
