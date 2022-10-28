package fr.grph3.univlille.utils;

public interface ValueNormalizer {

    double normalize(Object value);

    Object denormalize(double value);
}
