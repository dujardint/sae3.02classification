package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.points.IPoint;
import fr.grph3.univlille.utils.distances.IDistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}