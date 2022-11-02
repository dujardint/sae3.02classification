package csv;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import chargement.ChargementDonneesUtil;
import chargement.IrisDonneeBrut;
import chargement.VarietyIris;

public class TestCSV {
	
	 static List<IrisDonneeBrut> datas;
	 static List<IrisDonneeBrut> failDatas;
	
	@BeforeAll
    static void init(){
		try {
			TestCSV.datas = ChargementDonneesUtil.loadIris("data/iris.csv");
			TestCSV.failDatas = ChargementDonneesUtil.loadIris("data/iriss.csv");
		} catch (IOException e) { e.printStackTrace(); }
    }
	
	@Test
	public void testImport() {
		IrisDonneeBrut irisDonneeBrut = new IrisDonneeBrut();
		irisDonneeBrut.setPetal_length(1.4);
		irisDonneeBrut.setPetal_width(0.2);
		irisDonneeBrut.setSepal_length(4.9);
		irisDonneeBrut.setSepal_width(3.0);
		irisDonneeBrut.setVariety(VarietyIris.Setosa);
		assertEquals(irisDonneeBrut.toString(),datas.get(1).toString());
		assertNotEquals(irisDonneeBrut.toString(),datas.get(0).toString());
	}

	
}
