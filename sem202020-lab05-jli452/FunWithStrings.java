package lab05;
import java.util.*;

public class FunWithStrings
{
	public static void swapMaxes(List<String> list1, List<String> list2)
	{
		int listIndex1 = 0;
		int listIndex2 = 0;
		String listString1 = "";
		String listString2 = "";

		if (list1 == null || list1.size() == 0 || list2 == null || list2.size() == 0 || list1.isEmpty() || list2.isEmpty())
			throw new IllegalArgumentException("cannot swap maxes of empty lists, null lists, or lists with all null elements");

		for (int i = 0; i < list1.size(); i++)
		{
			if (list1.get(i) == null)
				continue;
			if (list1.get(i).length() > listString1.length())
			{
				listString1 = list1.get(i);
				listIndex1 = i;
			}
		}

		for (int i = 0; i < list2.size(); i++)
		{
			if (list2.get(i) == null)
				continue;
			if (list2.get(i).length() > listString2.length())
			{
				listString2 = list2.get(i);
				listIndex2 = i;
			}
		}

		list1.set(listIndex1, listString2);
		list2.set(listIndex2, listString1);
	}
}
