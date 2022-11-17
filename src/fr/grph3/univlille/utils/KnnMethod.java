package fr.grph3.univlille.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.points.IPoint;
import fr.grph3.univlille.utils.distances.IDistance;


public class KnnMethod<T extends IPoint> {

	private int k;
	private IDistance distance;
	
	public KnnMethod(int k, IDistance distance) {
		this.k = k;
		this.distance = distance;
	}
	
	public KnnMethod(int k) {
		this(k, null);
	}
	
	public List<IPoint> getNeighbours(IPoint point, List<IPoint> points, List<IColumn> columns){
		points.remove(point);
		List<IPoint> neighbours = new ArrayList<>();
		for(IPoint p : points) neighbours.add(p);
		if(distance != null) neighbours.sort((p1,p2)->Double.compare(distance.distance(p1, point, columns),distance.distance(p2, point, columns)));
		else neighbours.sort((p1,p2)->Double.compare(p1.distanceTo(point),p2.distanceTo(point)));
		
		return neighbours.subList(0, k);
	}

	public void classifyPoint(IPoint point, IColumn columnClass, List<IPoint> points, List<IColumn> columns) {
		points.remove(point);
		List<IPoint> neighbours = getNeighbours(point, points, columns);
		Map<Object, Integer> valueCount = new HashMap<>();
		for(IPoint p: neighbours) {
			Object value = p.getValue(columnClass);
			if(valueCount.containsKey(value)) {
				valueCount.put(value, valueCount.get(value)+1);
			}else {
				valueCount.put(value, 1);
			}
		}
		Entry<Object, Integer> entry = valueCount.entrySet().stream().max((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue())).get();
		point.setValue(columnClass, entry.getKey());
		/*pointClass.put(neighbours.get(0).getValue(columnClass), 1);
		for(int i = 1; i < neighbours.size(); i++) {
			for(int j = 0; j < pointClass.size(); j++) {
				if(neighbours.get(i).getValue(columnClass).equals(pointClass.keySet().toArray()[j])) {
					pointClass.merge(pointClass.keySet().toArray()[j], 1, Integer::sum);
				}else {
					pointClass.put(points.get(i).getValue(columnClass),1);
				}
			}
			
		}
		Entry<Object, Integer> entry = pointClass.entrySet().stream().max((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue())).get();
		point.setValue(columnClass, entry.getKey());*/
	}

	public void classifyAllPoint(IColumn columnClass, List<IPoint> points) {
		// TODO Auto-generated method stub
	}
	
}