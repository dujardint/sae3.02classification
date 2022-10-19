import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class ChargementDonneesUtil {

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
}