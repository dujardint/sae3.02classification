package fr.grph3.univlille;

import fr.grph3.univlille.entities.Point;

public interface Distance<T extends Point> {

    double distanceManhattan(T p1, T p2);

    double distanceEuclid(T p1, T p2);
}
