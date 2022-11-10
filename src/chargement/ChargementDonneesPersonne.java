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

public class ChargementDonneesPersonne implements IMVCModel{

	
	


	public static void main(String[] args) {
		try {
			//new ChargementDonneesUtil();
			
			List<PersonneDonneeBrut> listPersonnes = PersonneDonneeBrut.loadPersonne("data/personnes.csv");
			System.out.println(listPersonnes);
			System.out.println(listPersonnes.size());

			
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