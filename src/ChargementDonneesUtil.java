import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class ChargementDonneesUtil {

	private List<PokemonDonneBrut> loadRaw(String path)
			throws IllegalStateException, IOException {
		return new CsvToBeanBuilder<PokemonDonneBrut>(Files.newBufferedReader(Paths.get(path))).withSeparator(';')
				.withType(PokemonDonneBrut.class).build().parse();
	}

	public List<Pokemon> load(String path) throws IllegalStateException, IOException
	{
		List<PokemonDonneBrut> rawElements = loadRaw(path);
		List<Pokemon> elements = new ArrayList<>();

		for (PokemonDonneBrut element : rawElements) {
			elements.add(
					new Pokemon(element.name, element.attack, element.baseEggSteps, element.captureRate,
							element.defense, element.experienceGrowth, element.hp, element.spAttack, element.spDefense,
							element.type, element.type2, element.speed, element.isLegendary)
					);
		}
		return elements;
	}

	public static void main(String[] args) {
		try {
			List<Pokemon> persons =
					new ChargementDonneesUtil().load("data/pokemon_test.csv");

			System.out.println(persons);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}