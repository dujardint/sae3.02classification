package fr.grph3.univlille.columns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import fr.grph3.univlille.models.columns.BooleanColumn;
import org.junit.jupiter.api.Test;


public class TestBooleanColumn {

    BooleanColumn col = new BooleanColumn("Test");

    @Test
    public void test_get_normalized_value() {
        assertEquals(0.0, col.getNormalizedValue(true));
        assertEquals(1.0, col.getNormalizedValue(false));
    }

    @Test
    public void test_get_denormalized_value() {
        assertEquals(true, col.getDenormalizedValue(0.0));
        assertEquals(false, col.getDenormalizedValue(1.0));
    }

    @Test
    public void test_get_name() {
        assertEquals("Test", col.getName());
    }

    @Test
    public void test_isnormalisable() {
        assertTrue(col.isNormalizable());
    }
    
    @Test
    public void test_push() {
    	assertEquals(true,col.push(true));
    }
    
    @Test
    public void test_get_dataset() {
    	assertEquals(null,col.getDataset());
    }
    
    @Test
    public void test_get_normalizer() {
    	assertEquals(0,col.getNormalizer());
    }

}
