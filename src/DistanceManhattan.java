
public class DistanceManhattan implements Distance{

	@Override
	public double distance(Iris p1, Iris p2) {
		return Math.abs(p1.getBaseEggSteps()-p2.getBaseEggSteps())/MethodeKnn.baseEggSteps +
				Math.abs(p1.getCaptureRate()-p2.getCaptureRate())/MethodeKnn.captureRate +
				Math.abs(p1.getExperienceGrowth()-p2.getExperienceGrowth())/MethodeKnn.experienceGrowth +
				Math.abs(p1.getSpeed()-p2.getSpeed())/MethodeKnn.speed;
	}

}
