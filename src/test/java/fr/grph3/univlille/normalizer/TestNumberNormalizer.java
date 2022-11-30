package fr.grph3.univlille.normalizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.grph3.univlille.models.IDataSet;
import fr.grph3.univlille.models.columns.NumberColumn;
import fr.grph3.univlille.utils.normalizers.NumberNormalizer;

public class TestNumberNormalizer {
	
	IDataSet id;
	private NumberColumn column;
	private NumberNormalizer number;
	
	@BeforeEach
	void setUp() {
		
		column=new NumberColumn("sepal.length", id);
		number = new NumberNormalizer(column);	
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
