package fr.grph3.univlille;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.grph3.univlille.models.points.Iris;
import fr.grph3.univlille.utils.CSVModel;
import fr.grph3.univlille.utils.KnnMethod;
import fr.grph3.univlille.utils.MVCModel;
import fr.grph3.univlille.utils.distances.IDistance;
import fr.grph3.univlille.utils.distances.ManhattanDistance;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestKnnMethod {

	
	private CSVModel<Iris> model;
	private KnnMethod<Iris> knn;
	
	List<Iris> points = new ArrayList<>();
	List<Iris> allPoints;
	List<Iris> points2 = new ArrayList<>();

    private ManhattanDistance<Iris> distance;

    @BeforeEach
    void setUp(){
        this.model = new CSVModel<>(Iris.class, "Iris");
        this.knn = new KnnMethod<>();
        model.loadFromFile("src/main/resources/irisTest.csv");
        this.distance = new ManhattanDistance<>(model.getColumns());
        allPoints = model.getPoints();
    }
    
    @Test
    void test_getNeighbours() {
    	points.add(model.getPoint(9));
    	points.add(model.getPoint(10));
    	points.add(model.getPoint(11));
    	
    	assertTrue(knn.getNeighbours(model.getPoint(0), 3, distance, allPoints).containsAll(points));
    }
    
    @Test
    void test_classifier() {
    	points.add(model.getPoint(0)); //Setosa
    	points.add(model.getPoint(1)); //Setosa
    	points.add(model.getPoint(3)); //Versicolor
    	
    	assertEquals("Setosa", knn.classifier(points));

    }
    
    @Test
    void test_getRobustesse() {
    	assertEquals(73.33, knn.getRobustesse(distance,model),0.001); // ici 11 bon sur les 15 donc 11/15 = 73,33
    }
    
}
