package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.points.IPoint;
import fr.grph3.univlille.utils.distances.IDistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class KnnMethod<T extends IPoint> {

	public List<T> getNeighbours(T point, int k, IDistance<T> distance, List<T> points) {
		points.remove(point);
		Map<T, Double>  neighbours = new HashMap<>();
		for (T p : points) {
			double calcDist = distance.distance(point, p);
			if (neighbours.size() > k - 1) {
				for (T p2 : new ArrayList<>(neighbours.keySet())) {
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

	public double getRobustesse(IDistance<T> distance, MVCModel<T> model) {
		List<T> points = model.getPoints();
		List<T> pcalcul = new ArrayList<>();
		int divisor = points.size() / 5;
		double wellClassified = 0; 
		double totalClassified = 0;
		for(int i = 0;i < 5; i++) {
			pcalcul.clear();
			for (T p : points) {
				if(pcalcul.size() < divisor) {
					pcalcul.add(p);
				}
			}removeElement(points,0,divisor);
			for(T p : pcalcul) {
				if(p.getCategory().equals(classifier(getNeighbours(p, divisor, distance, points)))) {
					wellClassified++;
				}totalClassified ++;
			}
			addElement(points, pcalcul);
		}return Math.round((wellClassified/totalClassified)*100.0*100.0)/100.0;
	}
	
	public void removeElement(List<T> liste, int nb, int nbFin) {
		for(int i = nbFin - 1; i >= 0; i--) {
			liste.remove(i);
		}
	}
	
	public void addElement(List<T> listeToAdd, List<T> listeToPick) {
		for(T p : listeToPick) {
			listeToAdd.add(p);
		}
	}
	
	public String classifier(List<T> liste) {
		Map<String, Integer>  occurence = new HashMap<>();
		for (T p : liste) { 
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