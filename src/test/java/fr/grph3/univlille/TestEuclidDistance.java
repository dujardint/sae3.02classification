package fr.grph3.univlille;

import fr.grph3.univlille.models.points.Titanic;
import fr.grph3.univlille.utils.CSVModel;
import fr.grph3.univlille.utils.distances.EuclidDistance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEuclidDistance {

    private CSVModel model;

    private EuclidDistance distance;

    @BeforeEach
    void setUp(){
        this.model = new CSVModel(Titanic.class, "Titanic",null);
        model.loadFromFile("src/main/resources/titanic.csv");
        this.distance = new EuclidDistance(model.getColumns());
    }
    
    @Test
    void testDistance(){
        assertEquals(0.53, Math.round (distance.distance(model.getPoint(0), model.getPoint(72) ) *100.0)/100.0);
        assertEquals(0.13, Math.round (distance.distance(model.getPoint(0), model.getPoint(2) ) *100.0)/100.0);
        assertEquals(1.12,Math.round (distance.distance(model.getPoint(1), model.getPoint(5) ) *100.0)/100.0);
        assertEquals(0.21,Math.round (distance.distance(model.getPoint(14), model.getPoint(814) ) *100.0)/100.0);
    }
}
