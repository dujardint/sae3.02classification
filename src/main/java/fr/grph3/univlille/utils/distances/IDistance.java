package main.java.fr.grph3.univlille.utils.distances;

import main.java.fr.grph3.univlille.models.points.IPoint;

public interface IDistance<T extends IPoint> {

    double distance(T p1, T p2);
}
