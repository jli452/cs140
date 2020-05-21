package assignment07;

public class MediumCheesePizza implements Pizza{
	public String getDescription() {
		return "Medium cheese pizza";
	}

	public double getCost() {
		return 10.0;
	}
	
	public int compareTo(Pizza arg0) {
		return 1;
	}
}
