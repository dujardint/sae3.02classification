package fr.grph3.univlille.normalizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.grph3.univlille.models.columns.NumberColumn;
import fr.grph3.univlille.utils.normalizers.NumberNormalizer;

public class TestNumberNormalizer {
	
	private List<Double> values;
	private NumberColumn column;
	private NumberNormalizer number;
	
	@BeforeEach
	void setUp() {
		column=new NumberColumn("sepal.length");
		number = new NumberNormalizer(column);
		
		column.addValues(5.1);
		column.addValues(4.9);
		column.addValues(4.7);		
		column.addValues(4.6);
	}
	
	
	@Test
    void testGetNameColumn() {
    	assertEquals("sepal.length", column.getName());
    }
	
	@Test
    void testNormalize() {
    	assertEquals(0.60, number.normalize(4.9));
    }
	
	@Test
    void testDenormalize() {
    	assertEquals(4.9, number.denormalize(0.6000));
    }
}
