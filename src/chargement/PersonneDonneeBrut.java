package chargement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.CsvToBeanBuilder;

import Interfaces.IColumn;
import Interfaces.IPoint;

public class PersonneDonneeBrut implements IPoint {
	/*
	private String nom;
	private Genre prenom;
	private LocalDate dateNaissance;
	private String genre;
	private double taille;
	private int score;
	private OuiNon souscription; // OuiNon est un type �num�r� � cr�er
	 */

	@CsvBindByName(column = "Nom")  // Indique que la valeur de l'attribut nom se trouve dans la colonne Nom
	private String nom;

	@CsvBindByName(column = "Prénom")  // Indique que la valeur de l'attribut nom se trouve dans la colonne Nom
	private String prenom;

	@CsvBindByName(column = "Date de naissance")  // Indique que la valeur de l'attribut dateNaissance se trouve dans la colonne Date de naissance
	@CsvDate("yyyy-MM-dd")  // Comme cette donn�e est de type date, il faut indiquer quel est le format de repr�sentation de la date
	private LocalDate dateNaissance;

	@CsvBindByName(column = "Genre")  // Indique que la valeur de l'attribut nom se trouve dans la colonne Nom
	private GenrePersonne genre;

	@CsvBindByName(column = "Taille")  // Indique que la valeur de l'attribut nom se trouve dans la colonne Nom
	private double taille;

	@CsvBindByName(column = "Score")  // Indique que la valeur de l'attribut nom se trouve dans la colonne Nom
	private int score;

	@CsvBindByName(column = "Souscription")  // Indique que la valeur de l'attribut nom se trouve dans la colonne Nom
	private String souscription;





	public static List<PersonneDonneeBrut> loadPersonne(String path) throws IllegalStateException, IOException {
		return new CsvToBeanBuilder<PersonneDonneeBrut>(Files.newBufferedReader(Paths.get(path))).withSeparator(';')
				.withType(PersonneDonneeBrut.class).build().parse();
	}



	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", genre="
				+ genre + ", taille=" + taille + ", score=" + score + ", souscription=" + souscription + "]";
	}




	@Override
	public Object getValue(IColumn col) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public double getNormalizedValue(IColumn xcol) {
		// TODO Auto-generated method stub
		return 0;
	}
}

