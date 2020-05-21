package assignment06;

public class Pizza
{
	private String description;
	private double cost;

	public Pizza(String desc, double price)
	{
		description = desc;
		cost = price;
	}

	public String getDescription()
	{
		return description;
	}

	public double getCost()
	{
		return cost;
	}
}
