package lab01;

public class Country 
{
	private String name;
	private double area;
	private long population;

	public Country(String aName, double anArea, long pop) 
	{
		name = aName;
		area = anArea;
		population = pop;
	}

	public String getName() 
	{
		return name;
	}

	public double getArea()
	{
		return area;
	}

	public long getPopulation()
	{
		return population;
	}
	
	public double getAveragePopulationDensity()
	{
		return population/area;
	}
}
