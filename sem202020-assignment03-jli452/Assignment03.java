package assignment03;
import java.util.ArrayList;
import java.util.List;

public class Assignment03
{
	public static void appendArray(List<Integer> arrList, int[] arr)
	{
		if (arr == null)
			throw new IllegalArgumentException("Null array");
		for (int i = 0; i < arr.length; i++)
			arrList.add(arr[i]);
	}

	public static List<Integer> sumElementWise(List<Integer> lst1, List<Integer> lst2)
	{
		if (lst1 == null || lst2 == null)
			throw new IllegalArgumentException("Null array");
		List<Integer> lst3 = new ArrayList<>();
		if (lst1.size() == lst2.size())
		{
			for (int i = 0; i < lst1.size(); i++)
				lst3.add(lst1.get(i) + lst2.get(i));				
		}

		if (lst1.size() > lst2.size())
		{
			for (int i = 0; i < lst1.size(); i++)
			{
				if (i < lst2.size())
					lst3.add(lst1.get(i) + lst2.get(i));
				else
					lst3.add(lst1.get(i));
			}
		}

		if (lst1.size() < lst2.size())
		{
			for (int i = 0; i < lst2.size(); i++)
			{
				if (i < lst1.size())
					lst3.add(lst1.get(i) + lst2.get(i));
				else
					lst3.add(lst2.get(i));
			}				
		}
		return lst3;
	}
}
