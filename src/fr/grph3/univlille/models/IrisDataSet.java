package fr.grph3.univlille.models;


import java.util.Iterator;
import java.util.List;


import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.columns.NumberColumn;
import fr.grph3.univlille.models.columns.StringColumn;
import fr.grph3.univlille.models.points.IPoint;


public class IrisDataSet implements IDataSet<IPoint> {
	
	private static final String NAME = "Iris";
	public static final List<IColumn> COLUMNS = List.of(
			new NumberColumn("sepal.length"),
			new NumberColumn("sepal.width"),
			new NumberColumn("petal.length"),
			new NumberColumn("petal.width"),
			new StringColumn("variety")
			);

	@Override
	public Iterator<IPoint> iterator() {
		// TODO Auto-generated method stub
		return null;
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

}
