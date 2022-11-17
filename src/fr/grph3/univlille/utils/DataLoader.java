package fr.grph3.univlille.utils;




import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import fr.grph3.univlille.models.points.Iris;

public class DataLoader{

	public static List<Iris> loadIris(String fileName) throws IOException {
		return new CsvToBeanBuilder<Iris>(Files.newBufferedReader(Paths.get(fileName)))
				.withSeparator(',')
				.withType(Iris.class)
				.build().parse();
	}
    
    
    
}
