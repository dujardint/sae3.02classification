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

public class ChargementDonneesIris{

	
	
	static List<IrisDonneeBrut> listIris;
	

	public static void main(String[] args) {
		try {
			//new ChargementDonneesUtil();
			listIris = IrisDonneeBrut.loadIris("data/iris.csv");
			System.out.println(listIris);
			
			System.out.println(getMaximum());
			System.out.println(getMinimum());
			
			
			
		} catch (IllegalStateException | IOException e) {
			System.out.println("erreur de fichier");
			e.printStackTrace();
		}
	}

	
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public static int getNbLines() {
		return listIris.size();
	}
	

	
	public void setLines(List<IPoint> lines) {
		// TODO Auto-generated method stub

	}

	
	public void addLine(IPoint element) {
		// TODO Auto-generated method stub

	}

	
	public void addAllLine(List<IPoint> element) {
		// TODO Auto-generated method stub

	}

	
	public Iterator<IPoint> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void loadFromFile(String datafile) {
		// TODO Auto-generated method stub

	}

	
	public void loadFromString(String data) {
		// TODO Auto-generated method stub

	}

	
	public IColumn defaultXCol() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public IColumn defaultYCol() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void addCategory(ICategory classe) {
		// TODO Auto-generated method stub

	}

	
	public Collection<ICategory> allCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int nbColumns() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	public static double getMaximum() {
		double max=listIris.get(0).getSepal_length();
		for(int i=0; i<getNbLines(); i++) {
			if(max<listIris.get(i).sepal_length) {
				max=listIris.get(i).sepal_length;
			}
		}
		return max;
		
	}


	public List<IColumn> getNormalizableColumns() {
		
		return null;
	}

	public static double getMinimum() {
		double min=listIris.get(0).getSepal_length();
		for(int i=0; i<getNbLines(); i++) {
			if(min>listIris.get(i).sepal_length) {
				min=listIris.get(i).sepal_length;
			}
		}
		return min;
	}
}