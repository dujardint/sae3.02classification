import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.opencsv.bean.CsvToBeanBuilder;

public class MethodeKnn<T> extends Distance<T> {
	
	static List<T> datas;
	
	static double amp_base_egg_steps;
	static double amp_capture_rate;
	static double amp_experience_growth;
	static double amp_speed;

	public MethodeKnn(String url) throws IOException{
	}
	
	public MethodeKnn(String data, boolean isFile) throws IOException{
	}
	
	static void exemple() {
	}

	public List<Pokemon> readerData(Reader reader)  {
	}
	
	public void displayData() {
	}
	
	public ArrayList<Double> getMinOrMax(boolean getMax) {
	}
	
	public ArrayList<Double> compareAndSet(ArrayList<Double> l, Pokemon pkm, boolean greaterThan) {
	}
	
	public void computeAndSetAmps() {
	}
	
	public String toString() {
	}
	
	public Map<Double, T> computeDist(T pkm){
	}
	
	public boolean kNN(int k, T stdCase) {
	}
	
	public double createNewGen(String url, int k) throws IOException {
	}