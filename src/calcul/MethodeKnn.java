package calcul;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import chargement.ChargementDonneesUtil;
import chargement.IrisDonneeBrut;

public class MethodeKnn {

	static List<IrisDonneeBrut> datas;
	static double sepal_length;
	static double sepal_width;
	static double petal_length;
	static double petal_width;
	
	//1 categorie
	/*
	 * on li donn e une liste de colonne
	 */
	//saovir ensemble donnes
	//tt clonne ne paramatres

	public MethodeKnn(String fileName) {
		try {
			datas = ChargementDonneesUtil.loadIris(fileName);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void calculeAmplitudes() {
		if(datas == null || datas.isEmpty()) return;
		Iterator<IrisDonneeBrut> it = datas.iterator();
		IrisDonneeBrut tmp = it.next();
		double minEgg = tmp.getPetal_length(), maxEgg = tmp.getPetal_length();
		double minCapture = tmp.getPetal_width(), maxCapture = tmp.getPetal_width();
		double minXpGrowth = tmp.getSepal_length(), maxXpGrowth = tmp.getSepal_length();
		double minSpeed = tmp.getSepal_width(), maxSpeed = tmp.getSepal_width();
		
		while(it.hasNext()) {
			tmp = it.next();
			if(tmp.getPetal_length() < minEgg) minEgg = tmp.getPetal_length();
			else if(tmp.getPetal_length() > maxEgg) maxEgg = tmp.getPetal_length();
			if(tmp.getPetal_width() < minCapture) minCapture = tmp.getPetal_width();
			else if(tmp.getPetal_width() > maxCapture) maxCapture = tmp.getPetal_width();
			if(tmp.getSepal_length() < minXpGrowth) minXpGrowth = tmp.getSepal_length();
			else if(tmp.getSepal_length() > maxXpGrowth) maxXpGrowth = tmp.getSepal_length();
			if(tmp.getSepal_width() < minSpeed) minSpeed = tmp.getSepal_width();
			else if(tmp.getSepal_width() > maxSpeed) maxSpeed = tmp.getSepal_width();
		}
		
		sepal_length = maxEgg - minEgg;
		sepal_width = maxCapture - minCapture;
		petal_length = maxXpGrowth - minXpGrowth;
		petal_width = maxSpeed - minSpeed;
	}
	
	public List<IrisDonneeBrut> getVoisins(int k, IrisDonneeBrut iris, Distance distance) {
		Map<IrisDonneeBrut, Double> distances = new HashMap<>();
		for(IrisDonneeBrut chaqueIris : MethodeKnn.datas) {
			distances.put(chaqueIris, distance.distance(iris, chaqueIris));
		}
		LinkedHashMap<IrisDonneeBrut, Double> sortedMap = new LinkedHashMap<IrisDonneeBrut, Double>();
		distances.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
		List<IrisDonneeBrut> res = new ArrayList<IrisDonneeBrut>();
		int i = 0;
		for(IrisDonneeBrut chaqueIris : sortedMap.keySet()) {
			if(i >= k) break;
			res.add(chaqueIris);
		}
		return res;
	}
	
	

	
	public static void main(String[] args) throws IOException {
		MethodeKnn knn = new MethodeKnn(System.getProperty("user.dir") + System.getProperty("file.separator") + "data" + System.getProperty("file.separator") + "iris.csv");
		List<IrisDonneeBrut> legendaries = ChargementDonneesUtil.loadIris(System.getProperty("user.dir") + System.getProperty("file.separator") + "data" + System.getProperty("file.separator") + "iris.csv");
		System.out.println(legendaries);
		int k = 10;
		
		int nbLegBienPlacer = 0;
		int nbLeg = 0;
		System.out.println("k = " + k);
		System.out.println("Nombre légendaires : " + nbLeg);
		System.out.println("Bien insérer : " + nbLegBienPlacer);
		System.out.println("Réussite : " + 100.0*nbLegBienPlacer/nbLeg + " %");
	}
}
