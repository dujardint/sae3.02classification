
public class DistanceManhattan implements Distance{

	@Override
	public double distance(Iris p1, Iris p2) {
		 double distance = 0.0;
	        distance += Math.abs(p1.getPetal_length() - p2.getPetal_length());
	        distance += Math.abs(p1.getPetal_width() - p2.getPetal_width());
	        distance += Math.abs(p1.getSepal_length() - p2.getSepal_length());
	        distance += Math.abs(p1.getSepal_width() - p2.getSepal_width());
	        return Math.sqrt(distance);
		}

}
