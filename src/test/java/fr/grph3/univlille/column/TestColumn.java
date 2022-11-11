package fr.grph3.univlille.column;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.grph3.univlille.models.columns.DoubleColumn;

class TestColumn {

	List<Double> nombre;
	
	@BeforeEach
	void setUp() {
		nombre = new ArrayList<>();
		nombre.add(1.3);
		nombre.add(3.8);
		nombre.add(8.9);
		nombre.add(2.8);
		
		
	}
	
	@Test
	void test() {
		assertEquals(1,1);
	}
	
	@Test
	void testMin() {
		assertEquals(1.3, DoubleColumn.getMin(nombre));
	}
	
	@Test
	void testMax() {
		assertEquals(8.9, DoubleColumn.getMax(nombre));
	}

}
