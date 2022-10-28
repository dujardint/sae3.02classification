package fr.grph3.univlille;

import fr.grph3.univlille.entities.Iris;

public class IrisDistance implements Distance<Iris> {

    @Override
    public double distanceManhattan(Iris p1, Iris p2) {
        return 0;
    }

    @Override
    public double distanceEuclid(Iris p1, Iris p2) {
        return 0;
    }
}
