package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.points.IPoint;
import fr.grph3.univlille.utils.distances.IDistance;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class KnnMethod<T extends IPoint> {

	public List<T> getNeighbours(T point, int k, IDistance<T> distance, MVCModel<T> model) {
		List<T> points = model.getPoints();
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