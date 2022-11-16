package test.fr.grph3.univlille.column;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import main.java.fr.grph3.univlille.models.columns.MistakeNormalizableValueException;
import main.java.fr.grph3.univlille.models.columns.StringColumn;



public class TestStringColumn {
	
	StringColumn col = new StringColumn("Test");

	@Test
	void should_throw_exception_when_normalize() {
		assertThrows(MistakeNormalizableValueException.class, () -> col.normalize("Test"));
	}
	
	@Test
	void should_throw_exception_when_denormalize() {
		assertThrows(MistakeNormalizableValueException.class, () -> col.denormalize(0.0));
	}
	
	@Test
	void should_return_not_normalizable() {
		assertFalse(col.isNormalizable());
	}
	

}
