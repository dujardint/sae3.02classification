package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.points.IPoint;
import fr.grph3.univlille.utils.distances.IDistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class KnnMethod {

	public List<IPoint> getNeighbours(IPoint point, double k, IDistance distance, List<IPoint> points) {
		points.remove(point);
		Map<IPoint, Double>  neighbours = new HashMap<>();
		for (IPoint p : points) {
			double calcDist = distance.distance(point, p);
			if (neighbours.size() > k - 1) {
				for (IPoint p2 : new ArrayList<>(neighbours.keySet())) {
					if (neighbours.get(p2) > calcDist) {
						neighbours.remove(p2);
						neighbours.put(p, calcDist);
					}
				}
			} else {
				neighbours.put(p, calcDist);
			}
		}
		return new ArrayList<>(neighbours.keySet());
	}

	public double getRobustesse(IDistance distance, List<IPoint> data, double k) {
		List<IPoint> tmp = new ArrayList<>();
		int divisor = data.size() / 5;
		double wellClassified = 0; 
		double totalClassified = 0;
		for(int i = 0;i < 5; i++) {
			tmp.clear();
			for (IPoint p : data) {
				if(tmp.size() < divisor) {
					tmp.add(p);
				}
			}removeElement(tmp,0,divisor);
			for(IPoint p : tmp) {
				if(p.getCategory().equals(classifier(getNeighbours(p, k, distance, data)))) {
					wellClassified++;
				}totalClassified ++;
			}
			addElement(data, tmp);
		}return Math.round((wellClassified/totalClassified)*100.0*100.0)/100.0;
	}
	
	public void removeElement(List<IPoint> liste, int nb, int nbFin) {
		if (nbFin > 0) {
			liste.subList(0, nbFin).clear();
		}
	}
	
	public void addElement(List<IPoint> listeIPointoAdd, List<IPoint> listeIPointoPick) {
		listeIPointoAdd.addAll(listeIPointoPick);
	}
	
	public String classifier(List<IPoint> liste) {
		Map<String, Integer>  occurence = new HashMap<>();
		for (IPoint p : liste) { 
			occurence.putIfAbsent(p.getCategory(), 0);
			occurence.put(p.getCategory(), occurence.get(p.getCategory())+1);
		}
		Entry<String,Integer> maxEntry = null;

		for(Entry<String,Integer> entry : occurence.entrySet()) {
		    if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
		        maxEntry = entry;
		    }
		}
		return maxEntry.getKey();

	}
}