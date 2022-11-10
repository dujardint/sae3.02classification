package classificator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import chargement.IrisDonneeBrut;

public class classification {
	
	public static List<IrisDonneeBrut> loadIris(String path) throws IllegalStateException, IOException {
		return new CsvToBeanBuilder<IrisDonneeBrut>(Files.newBufferedReader(Paths.get(path))).withSeparator(',')
				.withType(IrisDonneeBrut.class).build().parse();
	}
	
	public static void main(String[] args) {
		
	}

}
