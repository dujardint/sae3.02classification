<<<<<<< HEAD

=======
package fr.grph3.univlille.normalizer;
>>>>>>> beb493cf081372f1eed20af010086d0928a893c9

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

<<<<<<< HEAD
import main.java.fr.grph3.univlille.utils.normalizers.BooleanNormalizer;
=======
import fr.grph3.univlille.utils.normalizers.BooleanNormalizer;
>>>>>>> beb493cf081372f1eed20af010086d0928a893c9

class TestBooleanNormalizer {

	private BooleanNormalizer valueBooleanNorm;
	
	@BeforeEach
	void setUp() {
		valueBooleanNorm = new BooleanNormalizer();
	}
	
	@Test
	void testNormalize() {
		assertEquals(0, valueBooleanNorm.normalize(true));
		assertEquals(1, valueBooleanNorm.normalize(false));
		
		assertNotEquals(1, valueBooleanNorm.normalize(true));
		assertNotEquals(0, valueBooleanNorm.normalize(false));
	}
	
	@Test
	void testDeormalize() {
		assertEquals(0, valueBooleanNorm.normalize(true));
		assertEquals(1, valueBooleanNorm.normalize(false));
		
		assertNotEquals(1, valueBooleanNorm.normalize(true));
		assertNotEquals(0, valueBooleanNorm.normalize(false));
	}

}
<<<<<<< HEAD

=======
>>>>>>> beb493cf081372f1eed20af010086d0928a893c9
