package chargement;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import Interfaces.ICategory;
import Interfaces.IColumn;
import Interfaces.IMVCModel;
import Interfaces.IPoint;
import calcul.Pokemon;

public class ChargementDonneesUtil implements IMVCModel{

	public static List<IrisDonneeBrut> loadIris(String path) throws IllegalStateException, IOException {
		return new CsvToBeanBuilder<IrisDonneeBrut>(Files.newBufferedReader(Paths.get(path))).withSeparator(',')
				.withType(IrisDonneeBrut.class).build().parse();
	}
	
	public static List<PersonneDonneeBrut> loadPersonne(String path) throws IllegalStateException, IOException {
		return new CsvToBeanBuilder<PersonneDonneeBrut>(Files.newBufferedReader(Paths.get(path))).withSeparator(';')
				.withType(PersonneDonneeBrut.class).build().parse();
	}

	public static List<PokemonDonneBrut> loadPokemon(String path) throws IllegalStateException, IOException {
		return new CsvToBeanBuilder<PokemonDonneBrut>(Files.newBufferedReader(Paths.get(path))).withSeparator(',')
				.withType(PokemonDonneBrut.class).build().parse();
	}
	
	public static List<TitanicDonneeBrut> loadTitanic(String path) throws IllegalStateException, IOException {
		return new CsvToBeanBuilder<TitanicDonneeBrut>(Files.newBufferedReader(Paths.get(path))).withSeparator(',')
				.withType(TitanicDonneeBrut.class).build().parse();
	}


	public static void main(String[] args) {
		try {
			//new ChargementDonneesUtil();
			List<IrisDonneeBrut> listIris = ChargementDonneesUtil.loadIris("data/iris.csv");
			System.out.println(listIris);
			System.out.println(listIris.size());
			
			List<PersonneDonneeBrut> listPersonnes = ChargementDonneesUtil.loadPersonne("data/personnes.csv");
			System.out.println(listPersonnes);
			System.out.println(listPersonnes.size());
			
			List<PokemonDonneBrut> listPokemon = ChargementDonneesUtil.loadPokemon("data/pokemon_suspect1.csv");
			System.out.println(listPokemon);
			System.out.println(listPokemon.size());
			System.out.println(listPokemon.get(0).name);
			
			List<PokemonDonneBrut> listPokemon1 = ChargementDonneesUtil.loadPokemon("data/pokemon_suspect2.csv");
			System.out.println(listPokemon1);
			System.out.println(listPokemon1.size());
			
			List<PokemonDonneBrut> pokemonTest = ChargementDonneesUtil.loadPokemon("data/pokemon_test.csv");
			System.out.println(pokemonTest.size());

			
			List<PokemonDonneBrut> pokemonTrain = ChargementDonneesUtil.loadPokemon("data/pokemon_train.csv");
			System.out.println(pokemonTrain.size());
			
			

			List<TitanicDonneeBrut> listTitanic = ChargementDonneesUtil.loadTitanic("data/titanic.csv");
			System.out.println(listTitanic);
			
			
			
		} catch (IllegalStateException | IOException e) {
			System.out.println("erreur de fichier");
			e.printStackTrace();
		}
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNbLines() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLines(List<IPoint> lines) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addLine(IPoint element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAllLine(List<IPoint> element) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<IPoint> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadFromFile(String datafile) {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadFromString(String data) {
		// TODO Auto-generated method stub

	}

	@Override
	public IColumn defaultXCol() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IColumn defaultYCol() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCategory(ICategory classe) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<ICategory> allCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nbColumns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<IColumn> getNormalizableColumns() {
		// TODO Auto-generated method stub
		return null;
	}
}