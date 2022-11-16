package main.java.fr.grph3.univlille.models.columns;

public class MistakeNormalizableValueException extends Exception {

	public MistakeNormalizableValueException() {
		super("La colonne choisie n'est pas normalizable ! ");
	}
}
