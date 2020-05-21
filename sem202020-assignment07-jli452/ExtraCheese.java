package assignment07;

public class ExtraCheese extends PizzaTopping{
	public ExtraCheese(Pizza p) {
		super(p);
	}
	
	@Override
	public double getCost() {
		return 0.15 + getOn().getCost();
	}
}
