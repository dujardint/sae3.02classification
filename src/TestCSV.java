

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestCSV {
	
	 static List<Iris> datas;
	 static List<Iris> failDatas;
	
	@BeforeAll
    static void init(){
		try {
			TestCSV.datas = ChargementDonneesUtil.loadRaw("data/iris.csv");
			TestCSV.failDatas = ChargementDonneesUtil.loadRaw("data/iriss.csv");
		} catch (IOException e) { e.printStackTrace(); }
    }
	
	@Test
	public void testImport() {
		Iris iris = new Iris();
		iris.setPetal_length(1.4);
		iris.setPetal_width(0.2);
		iris.setSepal_length(4.9);
		iris.setSepal_width(3.0);
		iris.setVariety("Setosa");
		assertEquals(iris.toString(),datas.get(1).toString());
		assertNotEquals(iris.toString(),datas.get(0).toString());
	}
	
	
	@Test
	public void testTry() {
		Iris i = new Iris();
		assertEquals("erreur de fichier",failDatas.get(1));
	}
	
	
	
}
