package chargement;
import java.lang.reflect.Type;

import com.opencsv.bean.CsvBindByName;

import Interfaces.IColumn;
import Interfaces.IPoint;
public class PokemonDonneBrut implements IPoint{
	

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
	@CsvBindByName(column = "type1")
	public TypePokemon type;
	@CsvBindByName(column = "type2")
	public TypePokemon type2;
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

	@Override
	public Object getValue(IColumn col) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getNormalizedValue(IColumn xcol) {
		// TODO Auto-generated method stub
		return 0;
	}
}
