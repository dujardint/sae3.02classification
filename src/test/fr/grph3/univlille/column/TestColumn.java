package fr.grph3.univlille.column;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.grph3.univlille.models.columns.NumberColumn;

class TestColumn {

	List<Double> nombre;
	NumberColumn a;
	
	@BeforeEach
	void setUp() {
		nombre = new ArrayList<>();
		nombre.add(1.3);
		nombre.add(3.8);
		nombre.add(8.9);
		nombre.add(2.8);
		a = new NumberColumn();
	}
	
	@Test
	void test() {
		assertEquals(1,1);
	}
	
	@Test
	void testMin() {
		assertEquals(1.3, a.getMin(nombre));
	}
	
	@Test
	void testMax() {
		assertEquals(8.9, a.getMax(nombre));
	}
	
	
	@Test
	void testNormalise() {
		assertEquals(0.375, a.getNormalizedValue(15.0,12.0,20.0));
	}
	
	@Test
	void testDenormalise() {
		assertEquals(15.0, a.getDenormalizedValue(0.375,12.0,20.0));
	}

}
