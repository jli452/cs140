package lab07;

public abstract class Herbivore extends Animal{
	private String foliage;
	private int aggressionLevel;
	
	abstract void graze();
	
	public Herbivore(String aFoliage, int aAggressionLevel) {
		foliage = aFoliage;
		aggressionLevel = aAggressionLevel;
	}
	
	@Override
	public String toString() {
		return "A herbivore only eats plants. It can additionally perform the action graze, and has a foliage that it eats.";
	}

	public String getFoliage() {
		return foliage;
	}

	public int getAggressionLevel() {
		return aggressionLevel;
	}
	
}
