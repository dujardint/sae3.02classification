package fr.grph3.univlille.utils;

import java.util.ArrayList;
import java.util.List;

import fr.grph3.univlille.models.IDataSet;
import fr.grph3.univlille.models.columns.IColumn;



public class Model extends Subject {

	
	private IDataSet dataset;
	private List<IDataSet> categories = new ArrayList<IDataSet>();
	private IColumn xColumn;
	private IColumn yColumn;
}
