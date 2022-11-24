package fr.grph3.univlille.points;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import main.java.fr.grph3.univlille.models.columns.BooleanColumn;
import main.java.fr.grph3.univlille.models.columns.NumberColumn;
import main.java.fr.grph3.univlille.models.columns.StringColumn;
import main.java.fr.grph3.univlille.models.points.Titanic;

public class TestTitanicPoint {
	
	enum EnumTest {
		S,Q,C
	}

	Titanic pers1 = new Titanic(3, 0, 3, "Braun", "male", 22, 1, 0, "4563221", 5.3, "C54", "S");
	Titanic pers2 = new Titanic(12, 1, 1, "Moran", "female", 30, 0, 5, "A/3 5456", 70.567, "", "Q");
	Titanic pers3 = new Titanic(6, 0, 2, "Allen", "male", 4, 3, 1, "PP 43224", 8.05, "G7", "S");
	Titanic pers4 = new Titanic(78, 1, 3, "Johnson", "male", 14, 5, 0, "D446G2", 29.34, "", "C");
	Titanic pers5 = new Titanic(100, 0, 1, "Anderson", "male", 59, 0, 0, "364234", 16.7, "", "Q");
	
	NumberColumn passId = new NumberColumn("PassengerId");
	BooleanColumn survived = new BooleanColumn("Survived");
	NumberColumn pClass = new NumberColumn("Pclass");
	StringColumn name = new StringColumn("Name");
	StringColumn sex = new StringColumn("Sex");
	NumberColumn age = new NumberColumn("Age");
	NumberColumn sibSp = new NumberColumn("SibSp");
	NumberColumn parch = new NumberColumn("Parch");
	StringColumn ticket = new StringColumn("Ticket");
	NumberColumn fare = new NumberColumn("Fare");
	StringColumn cabin = new StringColumn("Cabin");
	StringColumn embarked = new StringColumn("Embarked");

	
	@Test
	public void test_toString() {
		assertEquals("Titanic{passengerId=3.0, survived=0.0, pclass=3.0, name=Braun, sex=male, age=22.0, sibSp=1.0, parch=0.0, ticket=4563221, fare=5.3, cabin=C54, embarked=S}",pers1.toString());
	}
	
	@Test
	public void test_getValue() {
		assertEquals(3.0,pers1.getValue(passId));
		assertEquals(0.0,pers3.getValue(survived));
		assertEquals(3.0,pers4.getValue(pClass));
		assertEquals("Braun",pers1.getValue(name));
		assertEquals(30.0,pers2.getValue(age));
		assertEquals(5.0,pers4.getValue(sibSp));
		assertEquals(0.0,pers1.getValue(parch));
		assertEquals("PP 43224",pers3.getValue(ticket));
		assertEquals(16.7,pers5.getValue(fare));
		assertEquals("C54",pers1.getValue(cabin));
		assertEquals('Q',pers2.getValue(embarked));
	}

}
