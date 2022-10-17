import java.lang.reflect.Type;
import java.util.List;

public class Pokemon {
	private String name;
	private int attack;
	private int baseEggSteps;
	private double captureRate;
	private int defense;
	private int experienceGrowth;
	private int hp;
	private int spAttack;
	private int spDefense;
	private Type type;
	private Type type2;
	private double speed;
	private boolean isLegendary;

	
	public Pokemon (String name,int attack, int baseEggSteps,double captureRate,int defense,int experienceGrowth,
			int hp,int spAttack, int spDefense, Type type, Type type2, double speed, boolean isLegendary) {
		this.attack = attack;
		this.baseEggSteps = baseEggSteps;
		this.captureRate = captureRate;
		this.defense = defense;
		this.experienceGrowth = experienceGrowth;
		this.hp = hp;
		this.isLegendary = isLegendary;
		this.name = name;
		this.spAttack = spAttack;
		this.spDefense = spDefense;
		this.speed = speed;
		this.type = type;
		this.type2 = type2;
	}
	
	public List<Pokemon> getClosest(List<Pokemon> elements, int number) {
        // TODO Auto-generated method stub
        return null;
    }
	
	
	@Override
	public String toString() {
		return "Pokemon [nom=" + name + ", attack=" + attack + ", baseEggSteps=" + baseEggSteps + ", captureRate="
				+ captureRate + ", defense=" + defense + ", experienceGrowth=" + experienceGrowth + ", hp=" + hp
				+ ", spAttack=" + spAttack + ", spDefense=" + spDefense + ", type=" + type + ", type2=" + type2
				+ ", speed=" + speed + ", isLegendary=" + isLegendary + "]";
	}
}