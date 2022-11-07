package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.Iris;

public class IrisDistance implements Distance<Iris> {

    @Override
    public double distanceManhattan(Iris p1, Iris p2) {
    	double distance = 0.0;
        distance += Math.pow(p1.getPetalLength() - p2.getPetalLength(), 2);
        distance += Math.pow(p1.getPetalLength() - p2.getPetalLength(), 2);
        distance += Math.pow(p1.getSepalLength() - p2.getSepalLength(), 2);
        distance += Math.pow(p1.getSepalLength() - p2.getSepalLength(), 2);
        return Math.sqrt(distance);
    }

    @Override
    public double distanceEuclid(Iris p1, Iris p2) {
    	double distance = 0.0;
        distance += Math.abs(p1.getPetalLength() - p2.getPetalLength());
        distance += Math.abs(p1.getPetalLength() - p2.getPetalLength());
        distance += Math.abs(p1.getSepalLength() - p2.getSepalLength());
        distance += Math.abs(p1.getSepalLength() - p2.getSepalLength());
        return Math.sqrt(distance);
    }
}
