package lab07;

public abstract class Carnivore extends Animal{
	private String prey;
	private int predatoryLevel;
	
	abstract void prowl();
	
	public Carnivore(String aPrey, int aPredatoryLevel) {
		prey = aPrey;
		predatoryLevel = aPredatoryLevel;
	}
	
	@Override
	public String toString() {
		return "A carnivore only eats meat. It can additionally perform the action prowl, and has prey that it eats";
	}

	public String getPrey() {
		return prey;
	}

	public int getPredatoryLevel() {
		return predatoryLevel;
	}
	
	
}
