package assignment07;

public class GoatCheese extends PizzaTopping{
	public GoatCheese(Pizza p) {
		super(p);
	}
	
	@Override
	public double getCost() {
		return 0.30 + getOn().getCost();
	}
}
