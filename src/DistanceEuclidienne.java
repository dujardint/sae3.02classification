
public class DistanceEuclidienne implements Distance {

	@Override
	public double distance(Iris p1, Iris p2) {
		return Math.sqrt(Math.pow(p1.getBaseEggSteps()-p2.getBaseEggSteps(), 2)/MethodeKnn.baseEggSteps +
				Math.pow(p1.getCaptureRate()-p2.getCaptureRate(), 2)/MethodeKnn.captureRate +
				Math.pow(p1.getExperienceGrowth()-p2.getExperienceGrowth(), 2)/MethodeKnn.experienceGrowth +
				Math.pow(p1.getSpeed()-p2.getSpeed(), 2)/MethodeKnn.speed);
	}

}
