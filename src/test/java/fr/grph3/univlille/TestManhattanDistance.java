package fr.grph3.univlille;

import fr.grph3.univlille.models.points.Titanic;
import fr.grph3.univlille.utils.CSVModel;
import fr.grph3.univlille.utils.distances.ManhattanDistance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestManhattanDistance {

    private CSVModel<Titanic> model;

    private ManhattanDistance<Titanic> distance;

    @BeforeEach
    void setUp(){
        this.model = new CSVModel<>(Titanic.class, "Titanic");
        model.loadFromFile("src/main/resources/titanicTest.csv");
        this.distance = new ManhattanDistance<>(model.getColumns());
    }

    @Test
    void testDistance(){
        assertEquals(0.89, Math.round (distance.distance(model.getPoint(2), model.getPoint(3) ) *100.0)/100.0);
        assertEquals(1.30, Math.round (distance.distance(model.getPoint(0), model.getPoint(2) ) *100.0)/100.0);
        assertEquals(1.94,Math.round (distance.distance(model.getPoint(1), model.getPoint(3) ) *100.0)/100.0);
    }
}
