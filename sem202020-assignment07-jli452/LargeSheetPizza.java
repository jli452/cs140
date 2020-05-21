package assignment07;

public class LargeSheetPizza implements Pizza{
	public String getDescription() {
		return "Large Sheet Pizza";
	}

	public double getCost() {
		return 15.0;
	}
	
	public int compareTo(Pizza arg0) {
		return 1;
	}
}
