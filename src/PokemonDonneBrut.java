import java.lang.reflect.Type;

import com.opencsv.bean.CsvBindByName;
public class PokemonDonneBrut {

	@CsvBindByName(column = "name") 
	public String name;
	@CsvBindByName(column = "attack")
	public int attack;
	@CsvBindByName(column = "base_egg_steps")
	public int baseEggSteps;
	@CsvBindByName(column = "capture_rate")
	public double captureRate;
	@CsvBindByName(column = "defense")
	public int defense;
	@CsvBindByName(column = "experience_growth")
	public int experienceGrowth;
	@CsvBindByName(column = "hp")
	public int hp;
	@CsvBindByName(column = "sp_attack")
	public int spAttack;
	@CsvBindByName(column = "sp_defense")
	public int spDefense;
	@CsvBindByName(column = "type")
	public Type type;
	@CsvBindByName(column = "type2")
	public Type type2;
	@CsvBindByName(column = "speed")
	public double speed;
	@CsvBindByName(column = "is_legendary")
	public boolean isLegendary;

	@Override
	public String toString() {
		return "Pokemon [nom=" + name + ", attack=" + attack + ", baseEggSteps=" + baseEggSteps + ", captureRate="
				+ captureRate + ", defense=" + defense + ", experienceGrowth=" + experienceGrowth + ", hp=" + hp
				+ ", spAttack=" + spAttack + ", spDefense=" + spDefense + ", type=" + type + ", type2=" + type2
				+ ", speed=" + speed + ", isLegendary=" + isLegendary + "]";

	}
}
