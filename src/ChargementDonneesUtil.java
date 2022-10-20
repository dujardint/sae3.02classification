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

public class ChargementDonneesUtil implements IMVCModel{

	public static List<Iris> loadRaw(String path)
			throws IllegalStateException, IOException {
		return new CsvToBeanBuilder<Iris>(Files.newBufferedReader(Paths.get(path))).withSeparator(',')
				.withType(Iris.class).build().parse();
	}

	public List<Iris> load(String path) throws IllegalStateException, IOException
	{
		List<Iris> elements = loadRaw(path);
		return elements;
	}

	public static void main(String[] args) {
		try {
			List<Iris> persons =
					new ChargementDonneesUtil().load("data/iris.csv");

			System.out.println(persons);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
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