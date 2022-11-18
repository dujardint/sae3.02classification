package fr.grph3.univlille.utils.normalizers;

/**
 * Decrit un object (normalizer) qui peut transformer la valeur d'une colone en une valeur entre 0 et 1
 * Chaque normaliseur est une classe qui implemente l'interface ValueNormalizer
 */
public interface INormalizer<T> {

	/*
	    Retourne la valeur en parametre normalisee (entre 0 et 1). ex age: 32 --> 0.4
	 */
    double normalize(T value);

    /**
     *  Retourne la valeur en parametre normalisee en fonction de la valeur de référence
     *  (entre 0 et 1). ex nom: John/Joan --> 0
     */
    double normalize(T value, T reference);

    /**
     * Retourne la vraie valeur correspondante pour la colonne associee au normaliseur. ex age: 0.4 --> 32
     * De-normalise la valeur en parametre (qui est entre 0 et 1)
     */
    T denormalize(double value);
}