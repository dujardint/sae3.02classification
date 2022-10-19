import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MethodeKnn {

	static List<Pokemon> datas;
	static int baseEggSteps;
	static double captureRate;
	static int experienceGrowth;
	static double speed;

	public MethodeKnn(String fileName) {
		try {
			datas = ChargementDonneesUtil.loadRaw(fileName);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void calculeAmplitudes() {
		if(datas == null || datas.isEmpty()) return;
		Iterator<Pokemon> it = datas.iterator();
		Pokemon tmp = it.next();
		int minEgg = tmp.getBaseEggSteps(), maxEgg = tmp.getBaseEggSteps();
		double minCapture = tmp.getCaptureRate(), maxCapture = tmp.getCaptureRate();
		int minXpGrowth = tmp.getExperienceGrowth(), maxXpGrowth = tmp.getExperienceGrowth();
		double minSpeed = tmp.getSpeed(), maxSpeed = tmp.getSpeed();
		
		while(it.hasNext()) {
			tmp = it.next();
			if(tmp.getBaseEggSteps() < minEgg) minEgg = tmp.getBaseEggSteps();
			else if(tmp.getBaseEggSteps() > maxEgg) maxEgg = tmp.getBaseEggSteps();
			if(tmp.getCaptureRate() < minCapture) minCapture = tmp.getCaptureRate();
			else if(tmp.getCaptureRate() > maxCapture) maxCapture = tmp.getCaptureRate();
			if(tmp.getExperienceGrowth() < minXpGrowth) minXpGrowth = tmp.getExperienceGrowth();
			else if(tmp.getExperienceGrowth() > maxXpGrowth) maxXpGrowth = tmp.getExperienceGrowth();
			if(tmp.getSpeed() < minSpeed) minSpeed = tmp.getSpeed();
			else if(tmp.getSpeed() > maxSpeed) maxSpeed = tmp.getSpeed();
		}
		
		baseEggSteps = maxEgg - minEgg;
		captureRate = maxCapture - minCapture;
		experienceGrowth = maxXpGrowth - minXpGrowth;
		speed = maxSpeed - minSpeed;
	}
	
	public List<Pokemon> getVoisins(int k, Pokemon pokemon, Distance distance) {
		Map<Pokemon, Double> distances = new HashMap<>();
		for(Pokemon pok : MethodeKnn.datas) distances.put(pok, distance.distance(pokemon, pok));
		LinkedHashMap<Pokemon, Double> sortedMap = new LinkedHashMap<Pokemon, Double>();
		distances.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
		List<Pokemon> res = new ArrayList<Pokemon>();
		int i = 0;
		for(Pokemon pok : sortedMap.keySet()) {
			if(i >= k) break;
			res.add(pok);
		}
		return res;
	}
	
	public boolean isLegendary(int k, Pokemon pokemon, Distance distance) {
		List<Pokemon> voisins = getVoisins(k, pokemon, distance);
		int nbLegendary = 0;
		for(Pokemon pok : voisins) {
			if(pok.isLegendary()) nbLegendary++;
		}
		return 1.0*nbLegendary > voisins.size()/2;
	}

	
	public static void main(String[] args) throws IOException {
		MethodeKnn knn = new MethodeKnn(System.getProperty("user.dir") + System.getProperty("file.separator") + "data" + System.getProperty("file.separator") + "pokemon_train.csv");
		List<Pokemon> legendaries = ChargementDonneesUtil.loadRaw(System.getProperty("user.dir") + System.getProperty("file.separator") + "data" + System.getProperty("file.separator") + "pokemon_test.csv");
		
		int k = 5;
		
		int nbLegBienPlacer = 0;
		int nbLeg = 0;
		for(Pokemon leg : legendaries) {
			boolean isLeg = knn.isLegendary(k, leg, new DistanceEuclidienne());
			System.out.println("estLegendaire : " + leg.isLegendary() + " | Résultat : " + isLeg);
			if(leg.isLegendary()) nbLeg +=1;
			if(leg.isLegendary() && isLeg) nbLegBienPlacer += 1;
		}
		System.out.println("k = " + k);
		System.out.println("Nombre légendaires : " + nbLeg);
		System.out.println("Bien insérer : " + nbLegBienPlacer);
		System.out.println("Réussite : " + 100.0*nbLegBienPlacer/nbLeg + " %");
	}
}
