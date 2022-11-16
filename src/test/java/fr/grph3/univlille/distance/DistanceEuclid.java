package test.java.fr.grph3.univlille.distance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.fr.grph3.univlille.models.columns.DoubleColumn;
import main.java.fr.grph3.univlille.models.points.IPoint;
import main.java.fr.grph3.univlille.utils.distances.Distance;

public class DistanceEuclid {
	
Distance dist = new DistanceEuclid();
	
	IPoint p1 = new IrisPoint(5.1, 3.5, 1.4, 0.2, "Setosa");
	IPoint p2 = new IrisPoint(6.3, 3.3, 6, 2.5, "Virginica");
	
	DoubleColumn spL = new DoubleColumn("sepal.length");
	DoubleColumn spW = new DoubleColumn("sepal.width");
	DoubleColumn ptL = new DoubleColumn("petal.length");
	DoubleColumn ptW = new DoubleColumn("petal.width");
	
	@BeforeEach
	void setUp() {
		spL.update(5.1);
		spL.update(6.3);
		spW.update(3.5);
		spW.update(3.3);
		ptL.update(1.4);
		ptL.update(6);
		ptW.update(0.2);
		ptW.update(2.5);
	}

	@Test
	void test_distance_a_lui_meme() {
		assertEquals(0.0, dist.distance(p1, p1, List.of(spL, spW, ptL, ptW)));
	}
	
	@Test
	void test_distance_1_column() {
		assertEquals(1.0, dist.distance(p1, p2, List.of(spL)));;
	}

}
