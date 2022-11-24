package fr.grph3.univlille;

import fr.grph3.univlille.models.points.Titanic;
import fr.grph3.univlille.utils.CSVModel;
import fr.grph3.univlille.utils.distances.EuclidDistance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEuclidDistance {

    private CSVModel<Titanic> model;

    private EuclidDistance<Titanic> distance;

    @BeforeEach
    void setUp(){
        this.model = new CSVModel<>(Titanic.class, "Titanic");
        model.loadFromFile("src/main/resources/titanicTest.csv");
        this.distance = new EuclidDistance<>(model.getNormalizableColumns());
        System.out.println(model.getColumns().toString());
    }

    @Test
    void testDistance(){
        assertEquals(0.79, Math.round (distance.distance(model.getPoint(2), model.getPoint(3) ) *100.0)/100.0);
        assertEquals(1.21, Math.round (distance.distance(model.getPoint(0), model.getPoint(2) ) *100.0)/100.0);
        assertEquals(1.89,Math.round (distance.distance(model.getPoint(1), model.getPoint(3) ) *100.0)/100.0);
    }
}
