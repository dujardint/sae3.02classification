package fr.grph3.univlille;

import fr.grph3.univlille.models.points.Titanic;
import fr.grph3.univlille.utils.CSVModel;
import fr.grph3.univlille.utils.distances.ManhattanDistance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestManhattanDistance {

    private CSVModel model;

    private ManhattanDistance distance;

    @BeforeEach
    void setUp(){
        this.model = new CSVModel(Titanic.class, "Titanic",null);
        model.loadFromFile("src/main/resources/titanic.csv");
        this.distance = new ManhattanDistance(model.getColumns());
    }

    @Test
    void testDistance(){
    	 assertEquals(0.77, Math.round (distance.distance(model.getPoint(0), model.getPoint(72) ) *100.0)/100.0);
    	 assertEquals(0.18, Math.round (distance.distance(model.getPoint(0), model.getPoint(2) ) *100.0)/100.0);
         assertEquals(1.72, Math.round (distance.distance(model.getPoint(1), model.getPoint(5) ) *100.0)/100.0);
         assertEquals(1.41,Math.round (distance.distance(model.getPoint(45), model.getPoint(452) ) *100.0)/100.0);
    }
}
