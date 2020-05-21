package assignment07;

public abstract class PizzaTopping implements Pizza{
	private Pizza on;
	
	public String getDescription() {
		if(on instanceof PizzaTopping) {
			String retStr = getClass().getSimpleName() + ", " + on.getDescription();
			return Character.toUpperCase(retStr.charAt(0)) + retStr.substring(1).toLowerCase();
		}
		String retStr = getClass().getSimpleName() + " on " + on.getDescription();
		return Character.toUpperCase(retStr.charAt(0)) + retStr.substring(1).toLowerCase();
	}
	
	public PizzaTopping(Pizza p) {
		on = p;
	}

	public Pizza getOn() {
		return on;
	}

	public void setOn(Pizza on) {
		this.on = on;
	}
	
	public int compareTo(Pizza p) {
		if (p instanceof PizzaTopping)
			return getClass().getSimpleName().compareTo(p.getClass().getSimpleName());
		return -1;
	}
}
