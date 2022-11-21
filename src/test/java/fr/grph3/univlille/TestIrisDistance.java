package fr.grph3.univlille;

import fr.grph3.univlille.models.points.Iris;
import fr.grph3.univlille.utils.CSVModel;
import fr.grph3.univlille.utils.distances.EuclidDistance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIrisDistance {

    private CSVModel<Iris> model;

    private EuclidDistance<Iris> distance;

    @BeforeEach
    void setUp(){
        this.model = new CSVModel(Iris.class, "Iris");
        model.loadFromFile("src/main/resources/irisTest.csv");
        this.distance = new EuclidDistance<>(model.getNormalizableColumns());
    }

    @Test
    void testDistance(){
        assertEquals(1, distance.distance(model.getPoint(0), model.getPoint(1)));
    }
}
