package test.fr.grph3.univlille.column;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.grph3.univlille.models.IrisDataSet;
import fr.grph3.univlille.models.columns.BooleanColumn;
import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.columns.NumberColumn;
import fr.grph3.univlille.models.columns.StringColumn;

public class TestIrisDataSet {
	
	
	IrisDataSet ids;
	
	@BeforeEach
	void setUp() {
		ids= new IrisDataSet();
	}
	
	@Test
	void testNom() {
		assertEquals("Iris", ids.getTitle());
	}

	@Test
	void testNbLignes() {
		assertEquals(5, ids.getNbLines());
		//car il y a 5 colonnes dans une iris
	}
	
	@Test
	void testAdd() {
		//on teste un ajout d'un element dans la colonne correspondante
	}
	
	
}
