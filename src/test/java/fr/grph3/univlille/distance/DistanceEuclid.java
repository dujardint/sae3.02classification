package test.java.fr.grph3.univlille.distance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.groupeh6.sae.columns.NumberColumn;
import fr.grph3.univlille.models.columns.DoubleColumn;
import fr.grph3.univlille.models.points.IPoint;
import fr.grph3.univlille.models.points.Iris;
import fr.grph3.univlille.utils.distances.Distance;
import fr.grph3.univlille.utils.distances.EuclidDistance;

public class DistanceEuclid {
	
EuclidDistance<Iris> dist = new EuclidDistance<Iris>(null);
	
	IPoint p1 = new Iris(5.1, 3.5, 1.4, 0.2, "Setosa");
	IPoint p2 = new Iris(6.3, 3.3, 6, 2.5, "Virginica");
	

	DoubleColumn spL = new DoubleColumn("sepal.length");
	DoubleColumn spW = new DoubleColumn("sepal.width");
	DoubleColumn ptL = new DoubleColumn("petal.length");
	DoubleColumn ptW = new DoubleColumn("petal.width");
	
	@Test
	void test_distance_a_lui_meme() {
		assertEquals(0.0, dist.distance(p1, p1, List.of(spL, spW, ptL, ptW)));
	}
	
	@Test
	void test_distance_1_column() {
		assertEquals(1.0, dist.distance(p1, p2, List.of(spL)));;
	}


}
