package fr.grph3.univlille.normalizer;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import main.java.fr.grph3.univlille.utils.normalizers.BooleanNormalizer;

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

