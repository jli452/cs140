package assignment07;

public class Mushroom extends PizzaTopping{
	public Mushroom(Pizza p) {
		super(p);
	}
	
	@Override
	public double getCost() {
		return 0.25 + getOn().getCost();
	}
}
