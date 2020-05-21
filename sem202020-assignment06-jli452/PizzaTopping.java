package assignment06;

abstract class PizzaTopping extends Pizza
{
	private Pizza on;	

	public PizzaTopping(String aDescription, double aCost, Pizza pizza)
	{
		super(aDescription, aCost);
		on = pizza;
	}

	public Pizza getOn()
	{
		return on;
	}

	public void setOn(Pizza onWhat)
	{
		on = onWhat;
	}
	
	public double getCost()
	{
		return super.getCost() + on.getCost();
	}

	public String getDescription()
	{
		if (on instanceof PizzaTopping)
			return super.getDescription() + ", " + on.getDescription();
		return super.getDescription() + " on " + on.getDescription();
	}
}
