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

public class MethodeKnn extends Distance{
	
	static List<Pokemon> datas;
	
	static double amp_base_egg_steps;
	static double amp_capture_rate;
	static double amp_experience_growth;
	static double amp_speed;

	public MethodeKnn(String url) throws IOException{
		this(url, true);
	}
	
	public MethodeKnn(String data, boolean isFile) throws IOException{
		if (isFile) {
			MethodeKnn.datas = readerData( new FileReader(data));
		}
		else {
			MethodeKnn.datas = readerData( new StringReader(data));
		}
	}
	
	static void exemple() {
		try {
			new MethodeKnn("name,age,sex,vegetarien\nTropius,a,homme,true,45\n", false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Pokemon> readerData(Reader reader)  {
		return new CsvToBeanBuilder<Pokemon>(reader)
	        .withSeparator(',')
	        .withType(Pokemon.class)
	        .build().parse();
	}
	
	public void displayData() {
		for(Pokemon p : datas) {
			System.out.println(p);
		}
	}
	
	public ArrayList<Double> getMinOrMax(boolean getMax) {
		Iterator<Pokemon> i = datas.iterator();
		Pokemon pkm;
		ArrayList<Double> l = null;
		if(i.hasNext()) {
			pkm = i.next();
			l = new ArrayList<Double>();
			l.add((double) pkm.base_egg_steps);
			l.add(pkm.capture_rate);
			l.add((double) pkm.experience_growth);
			l.add(pkm.speed);
		}
		while(i.hasNext()) {
			pkm = (Pokemon) i.next();
			l = compareAndSet(l, pkm, getMax);
		}
		return l;
	}
	
	public ArrayList<Double> compareAndSet(ArrayList<Double> l, Pokemon pkm, boolean greaterThan) {
		if(!greaterThan) {
			if(pkm.base_egg_steps < l.get(0)) {
				l.set(0, (double) pkm.base_egg_steps);
			}
			if(pkm.capture_rate < l.get(1)) {
				l.set(1, pkm.capture_rate);
			}
			if(pkm.experience_growth < l.get(2)) {
				l.set(2, (double) pkm.experience_growth);
			}
			if(pkm.speed < l.get(3)) {
				l.set(3, pkm.speed);
			}
		}else {
			if(pkm.base_egg_steps > l.get(0)) {
				l.set(0, (double) pkm.base_egg_steps);
			}
			if(pkm.capture_rate > l.get(1)) {
				l.set(1, pkm.capture_rate);
			}
			if(pkm.experience_growth > l.get(2)) {
				l.set(2, (double) pkm.experience_growth);
			}
			if(pkm.speed > l.get(3)) {
				l.set(3, pkm.speed);
			}
		}
		
		return l;
	}
	
	public void computeAndSetAmps() {
		List<Double> mins = getMinOrMax(false);
		List<Double> maxs = getMinOrMax(true);
		
		MethodeKnn.amp_base_egg_steps = maxs.get(0).intValue() - mins.get(0).intValue();
		MethodeKnn.amp_capture_rate = maxs.get(1).doubleValue() - mins.get(1).doubleValue();
		MethodeKnn.amp_experience_growth = maxs.get(2).intValue() - mins.get(2).intValue();
		MethodeKnn.amp_speed = maxs.get(3).doubleValue() - mins.get(3).doubleValue();
	}
	
	public String toString() {
		return amp_base_egg_steps + " - " + amp_capture_rate +" - " + amp_experience_growth + " - " + amp_speed;
	}
	
	public Map<Double, Pokemon> computeDist(Pokemon pkm){
		Map<Double, Pokemon> map = new HashMap<Double, Pokemon>();
		DistanceEuclidienne de = new DistanceEuclidienne();
		for(Pokemon pkm2 : datas) {
			map.put(de.distance(pkm, pkm2), pkm2);
		}
		return map;
	}
	
	public boolean kNN(int k, Pokemon stdCase) {
		Map<Double, Pokemon> map = computeDist(stdCase);
		ArrayList<Pokemon> nn = new ArrayList<Pokemon>();
		Pokemon pkm;
		int lgn=0;
		int nLgn=0;
		for(int i = 0; i < k; i++) {
			pkm = map.remove(Collections.min(map.keySet()));
			nn.add(pkm);
			if(pkm.is_legendary) {
				lgn++;
			}else {
				nLgn++;
			}
			System.out.println(pkm);
		}
		System.out.println(lgn + " - " + nLgn);
		if(lgn==nLgn) {
			Random rnd = new Random();
			return rnd.nextBoolean();
		} else {
			return lgn>nLgn?true:false;
		}
		
	}
	
	public double createNewGen(String url, int k) throws IOException {
		List<Pokemon> data = new CsvToBeanBuilder<Pokemon>(new FileReader(url))
		        .withSeparator(',')
		        .withType(Pokemon.class)
		        .build().parse();
		double totNumber = 0;
		double correct = 0;
		for(Pokemon pkm : data) {
			totNumber = totNumber + 1;
			System.out.println("Study -> "+pkm);
			if(kNN(k,pkm) == pkm.is_legendary) correct = correct + 1;
		}
		System.out.println(totNumber +" >-< " + correct);
		
		return (correct * 100) / totNumber;