package fr.grph3.univlille.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.fr.grph3.univlille.models.points.Iris;
import main.java.fr.grph3.univlille.models.points.builders.IrisBuilder;

public class TestIrisBuilder {

	IrisBuilder bl;
	Iris setosa = new Iris(5.1, 3.5, 1.4, 0.2, "Setosa");

	
	@Test
	public void test_withSepalLength() {
		assertEquals(1,bl.withPetalLength(0));
	}
	
	
}
