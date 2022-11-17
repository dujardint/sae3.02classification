package test.java.fr.grph3.univlille;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.grph3.univlille.models.points.Titanic;

public class TestTitanic {

	enum EnumTest {
		S,Q,C
	}

	Titanic pers1 = new Titanic(3, 0, 3, "Braun", "male", 22, 1, 0, "4563221", 5.3, "C54", 'S');
	Titanic pers2 = new Titanic(12, 1, 1, "Moran", "female", 30, 0, 5, "A/3 5456", 70.567, "", 'Q');
	Titanic pers3 = new Titanic(6, 0, 2, "Allen", "male", 4, 3, 1, "PP 43224", 8.05, "G7", 'S');
	Titanic pers4 = new Titanic(78, 1, 3, "Johnson", "male", 14, 5, 0, "D446G2", 29.34, "", 'C');
	Titanic pers5 = new Titanic(100, 0, 1, "Anderson", "male", 59, 0, 0, "364234", 16.7, "", 'Q');

	
	@Test
	void test_toString() {
		assertEquals("titanic [passengerId=3.0, survived=0.0, pclass=3.0, name=Braun, sex=male, age=22.0, sibSp=1.0, parch=0.0, ticket=4563221, fare=5.3, cabin=C54, embarked=S]",pers1.toString());
	}
}
