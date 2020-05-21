package lab05;
import java.util.*;

public class Division
{
	private List<Double> list = new ArrayList<>();
	
	public Division(double[] array)
	{
		if(array == null || array.length == 0)
			throw new IllegalArgumentException("need to enter an array with at least one double");
		for (int i = 0; i < array.length; i++)
			list.add(array[i]);
	}

	public List<Double> getList()
	{
		return list;
	}

	public void removeZeroes()
	{
		Iterator<Double> iter = list.iterator();
		while (iter.hasNext())
		{
			if (iter.next() == 0)
				iter.remove();
		}
	}

	public void divide(int divisor)
	{
		if (divisor == 0)
			throw new IllegalArgumentException("cannot divide by zero");
		for (int i = 0; i < list.size(); i++)
			list.set(i, list.get(i)/divisor);
	}
	
	public String toString()
	{
		return list.toString();
	}
}
