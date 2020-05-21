package assignment07;

public class Pepperoni extends PizzaTopping{
	public Pepperoni(Pizza p) {
		super(p);
	}
	
	@Override
	public double getCost() {
		return 0.40 + getOn().getCost();
	}
}
