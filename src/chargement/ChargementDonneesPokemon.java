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

public class ChargementDonneesPokemon implements IMVCModel{

	
	
	
	public static void main(String[] args) {
		try {
			
			List<PokemonDonneBrut> listPokemon = PokemonDonneBrut.loadPokemon("data/pokemon_suspect1.csv");
			System.out.println(listPokemon);
			System.out.println(listPokemon.size());
			System.out.println(listPokemon.get(0).name);
			
			List<PokemonDonneBrut> listPokemon1 = PokemonDonneBrut.loadPokemon("data/pokemon_suspect2.csv");
			System.out.println(listPokemon1);
			System.out.println(listPokemon1.size());
			
			List<PokemonDonneBrut> pokemonTest = PokemonDonneBrut.loadPokemon("data/pokemon_test.csv");
			System.out.println(pokemonTest.size());

			
			List<PokemonDonneBrut> pokemonTrain = PokemonDonneBrut.loadPokemon("data/pokemon_train.csv");
			System.out.println(pokemonTrain.size());
			
			
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




	@Override
	public double getMaximum() {
		// TODO Auto-generated method stub
		return 0;
	}




	@Override
	public double getMinimum() {
		// TODO Auto-generated method stub
		return 0;
	}
}