package fr.grph3.univlille.distance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import main.java.fr.grph3.univlille.models.columns.IColumn;
import main.java.fr.grph3.univlille.models.columns.NumberColumn;
import main.java.fr.grph3.univlille.models.points.IPoint;
import main.java.fr.grph3.univlille.models.points.Iris;
import main.java.fr.grph3.univlille.utils.distances.EuclidDistance;
import main.java.fr.grph3.univlille.utils.distances.IDistance;
import main.java.fr.grph3.univlille.utils.normalizers.BooleanNormalizer;
import main.java.fr.grph3.univlille.utils.normalizers.NumberNormalizer;

public class TestDistanceEuclideine {

   
	
	IPoint p1 = new Iris(5.1, 3.5, 1.4, 0.2,"SETOSA");
	IPoint p2 = new Iris(6.3, 3.3, 6, 2.5, "SETOSA");
	IPoint p3 = new Iris(3.2, 4.2, 4, 1.6, "SETOSA");
	
	NumberColumn spL = new NumberColumn("sepal.length");
	NumberColumn spW = new NumberColumn("sepal.width");
	NumberColumn ptL = new NumberColumn("petal.length");
	NumberColumn ptW = new NumberColumn("petal.width");
	NumberNormalizer nn = new NumberNormalizer(ptL);
	BooleanNormalizer bn = new BooleanNormalizer();
	
	List<IColumn> columns;
	
	 IDistance dist = new EuclidDistance(nn, bn, columns);
	
	@BeforeEach
	void setUp() {
		spL.addValues(3.2);
		spL.addValues(3.4);
		spL.addValues(4.2);
	}
	
	@Test
	public void test_euclid() {
		assertEquals(0.0, dist.distance(p1, p2));
	}
}
