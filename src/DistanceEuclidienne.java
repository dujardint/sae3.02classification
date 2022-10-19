
public class DistanceEuclidienne implements Distance {

	@Override
	public double distance(Iris p1, Iris p2) {
	    double distance = 0.0;
        distance += Math.pow(p1.getPetal_length() - p2.getPetal_length(), 2);
        distance += Math.pow(p1.getPetal_width() - p2.getPetal_width(), 2);
        distance += Math.pow(p1.getSepal_length() - p2.getSepal_length(), 2);
        distance += Math.pow(p1.getSepal_width() - p2.getSepal_width(), 2);
        return Math.sqrt(distance);
	}

}
