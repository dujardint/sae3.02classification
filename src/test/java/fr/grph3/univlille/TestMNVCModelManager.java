package fr.grph3.univlille;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.grph3.univlille.models.points.Iris;
import fr.grph3.univlille.models.points.Titanic;
import fr.grph3.univlille.utils.AbstractMVCModel;
import fr.grph3.univlille.utils.CSVModel;

public class TestMNVCModelManager {
	 
	 private MVCModelManager manager;
	 
	 private AbstractMVCModel model1;
	 private AbstractMVCModel model2;
	 
	 private List<String> names;
	 
	 @BeforeEach
	 public void setUp() {
		 this.manager = new MVCModelManager();
		 this.model1 = new CSVModel(Iris.class, "Iris",null);
		 this.model2 = new CSVModel(Titanic.class, "Titanic",null);
		 manager.getModels().add(model1);
		 manager.getModels().add(model2);
		 
		 this.names = new ArrayList<>();
	 }
	 
	 @Test
	 public void test_findModelByTitle_should_return_null() {
		 assertEquals(null,manager.findModelByTitle("birds"));
	 }

	@Test
	 public void test_findModelByTitle_should_not_return_null() {
		 assertEquals(model1,manager.findModelByTitle(model1.getTitle()));
	 }	 
	 
	 @Test
	 public void test_subscribe_should_return_true() {
		 assertTrue(manager.subscribe(model1, "src/main/resources/irisTest.csv", true));
		 assertEquals(3,manager.getModels().size());
	 }
	 
	 @Test
	 public void test_subscribe_should_return_false() {
		 assertFalse(manager.subscribe(model1, "src/main/resources/irisTest.csv", false));
		 assertEquals(2,manager.getModels().size());
	 }
	 
	 @Test
	 public void test_subscribe_should_return_false_short() {
		 assertFalse(manager.subscribe(model1, "src/main/resources/irisTest.csv"));
		 assertEquals(2,manager.getModels().size());
	 }
	 
	 @Test
	 public void test_switchModel() {
		 assertEquals(model1,manager.switchModel(model1.getTitle()));
		 assertEquals(model2,manager.switchModel(model2.getTitle()));
	 }
	 
	 @Test
	 public void test_getCurrentModel() {
		 manager.switchModel(model2.getTitle());
		 assertEquals(model2,manager.getCurrentModel());
	 }
	 
	 @Test
	 public void test_name() {
		 names.add("Iris");
		 names.add("Titanic");
		 assertEquals(names,manager.names());
	 }
	 
}
