package assignment07;

public interface Pizza extends Comparable<Pizza>{
	abstract String getDescription();
	
	default double getCost() {
		return 0.0;
	}
}
