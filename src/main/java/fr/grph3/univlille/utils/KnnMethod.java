package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.points.IPoint;
import fr.grph3.univlille.utils.distances.IDistance;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

public class KnnMethod<T extends IPoint> {

	private IDistance<T> distance;

	private List<T> datas;

	public KnnMethod(String data, boolean isFile, IDistance<T> distance) throws IOException {
		this.distance = distance;
	}

	public KnnMethod(String url, IDistance<T> distance) throws IOException {
		this(url, true, distance);
	}

	private List<T> readerData(Reader reader) {
		return null;
	}

	public void displayData() {
	}

	public double getMin() {
		return 0;
	}

	public double getMax() {
		return 0;
	}

	public List<Double> compareAndSet(List<Double> l, T point, boolean greaterThan) {
		return null;
	}

	public void computeAndSetAmps() {
	}

	public Map<Double, T> computeDist(T point) {
		return  null;
	}

	public boolean kNN(int k, T point) {
		return false;
	}

	public double createNewGen(String url, int k) throws IOException {
		return 0;
	}
}