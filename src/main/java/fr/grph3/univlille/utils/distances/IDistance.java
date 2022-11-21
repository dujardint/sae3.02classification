package fr.grph3.univlille.utils.distances;

import fr.grph3.univlille.models.points.IPoint;

public interface IDistance<T extends IPoint> {

    double distance(T p1, T p2);
}
