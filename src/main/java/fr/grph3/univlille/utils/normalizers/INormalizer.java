package main.java.fr.grph3.univlille.utils.normalizers;
//Decrit un object (normalizer) qui peut transformer la valeur d'une colone en une valeur entre 0 et 1

//Chaque normaliseur est une classe qui implemente l'interface ValueNormalizer
public interface INormalizer {
	
	// Liste tous les normaliseurs connus par le programme. 
	//A chaque valeur dans cette liste doit correspondre une classe qui implemente <i>INormalizer</i>.

	enum NormalizerTypes {
		NUMBER_NORMALIZER,  //Normalise une valeur numerique (entiere ou reelle)
		BOOLEAN_NORMALIZER, //Normalise une valeur booleenne (typiquement false = 0 et true = 1)
		STRING_NORMALIZER//Chaque type recoit une valeur unique entre 0 et 1.
	}

	// Retourne la valeur en parametre normalisee (entre 0 et 1). ex age: 32 --> 0.4
    double normalize(Object value);

    //De-normalise la valeur en parametre (qui est entre 0 et 1)
    //Retourne la vraie valeur correspondante pour la colonne associee au normaliseur. ex age: 0.4 --> 32
    Object denormalize(double value);
    
}