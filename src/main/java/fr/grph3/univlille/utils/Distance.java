package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.Point;

public interface Distance<T extends Point> {

    double distanceManhattan(T p1, T p2);

    double distanceEuclid(T p1, T p2);
}
