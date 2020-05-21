package assignment07;

public class SmallCheesePizza implements Pizza {
	public String getDescription() {
		return "Small Cheese Pizza";
	}

	public double getCost() {
		return 8.0;
	}
	
	public int compareTo(Pizza arg0) {
		return 1;
	}
}
