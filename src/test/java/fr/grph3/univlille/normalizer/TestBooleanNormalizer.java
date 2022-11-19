package fr.grph3.univlille.normalizer;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import main.java.fr.grph3.univlille.utils.normalizers.BooleanNormalizer;

public class TestBooleanNormalizer {

	public BooleanNormalizer valueBooleanNorm;
	
	@BeforeEach
	public void setUp() {
		valueBooleanNorm = new BooleanNormalizer();
	}
	
	@Test
	public void testNormalize() {
		assertEquals(0, valueBooleanNorm.normalize(true));
		assertEquals(1, valueBooleanNorm.normalize(false));
		
	}
	
	@Test
	public void testDeormalize() {
		assertEquals(0, valueBooleanNorm.normalize(true));
		assertEquals(1, valueBooleanNorm.normalize(false));
	}

}

