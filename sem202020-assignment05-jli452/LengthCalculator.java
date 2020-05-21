package assignment05;
import java.util.*;

public class LengthCalculator
{
	public static void removeNulls(List<String> list)
	{
		if (list == null)
			throw new IllegalArgumentException("List must be non-null");
		Iterator<String> iter = list.iterator();
		while (iter.hasNext())
		{
			if (iter.next() == null)
				iter.remove();
		}
	}

	public static List<Integer> stringLengths(List<String> list)
	{
		removeNulls(list);
		if (list.size() == 0)
			throw new IllegalArgumentException("Cannot calculate string lengths of an empty list");
		List<Integer> retVal = new ArrayList<>();
		Iterator<String> iter = list.iterator();
		while (iter.hasNext())
		{
			retVal.add(iter.next().length());
		}
		return retVal;
	}
}
