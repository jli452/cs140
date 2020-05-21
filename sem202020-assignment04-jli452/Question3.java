package assignment04;
import java.util.*;	

public class Question3
{
	public static List<String> longest(List<String> list)
	{
		List<String> arrList = new ArrayList<>();
		int len = 0;
		if (list == null)
			return null;
		if (list.size() == 0)
			return arrList;
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) == null)
				continue;
			if (list.get(i).length() > len)
				len = list.get(i).length();
		}
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) == null)
				continue;
			if (list.get(i).length() == len)
				arrList.add(list.get(i));
		}
		return arrList;
	}
	
	public static String[] shortest(List<String> list)
	{
		String[] arr0 = new String[0];
		if (list == null)
			return null;
		if (list.size() == 0)
			return arr0;
		int len = Integer.MAX_VALUE;
		List<String> arrList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) == null)
				continue;
			if (list.get(i).equals(""))
			{
				len = 0;
				break;
			}
			if (list.get(i).length() < len)
				len = list.get(i).length();
		}
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) == null)
				continue;
			if (list.get(i).length() == len)
				arrList.add(list.get(i));
		}
		String[] retArr = new String[arrList.size()];
		for (int i = 0; i < arrList.size(); i++)
		{
			retArr[i] = arrList.get(i);
		}
		return retArr;
	}

	public static int[] longestLocations(List<String> list)
	{
		int[] arr0 = new int[0];
		int len = 0;
		if (list == null)
			return null;
		if (list.size() == 0)
			return arr0;
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) == null)
				continue;
			if (list.get(i).length() > len)
				len = list.get(i).length();
		}
		List<Integer> arrList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) == null)
				continue;
			if (list.get(i).length() == len)
				arrList.add(i);
		}
		int[] retArr = new int[arrList.size()];
		for (int i = 0; i < arrList.size(); i++)
		{
			retArr[i] = arrList.get(i);
		}
		return retArr;
	}
	
	public static List<String> mostCs(List<String> list, char c)
	{
		int counter = 0;
		List<String> arrList = new ArrayList<>();
		if (list == null)
			return null;
		if (list.size() == 0)
			return arrList;
		char c1 = Character.toUpperCase(c);
		char c2 = Character.toLowerCase(c);
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) == null)
				continue;
			int temp = 0;
			for (char ch : list.get(i).toCharArray())
			{
				if (ch == c1 || ch == c2)
					temp++;
			}
			if (temp > counter)
				counter = temp;
		}
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) == null)
				continue;
			int temp = 0;
			for (char ch : list.get(i).toCharArray())
			{
				if (ch == c1 || ch == c2)
					temp++;
			}
			if (temp == counter)
				arrList.add(list.get(i));
		}
		return arrList;
	}

	public static String[] fewestCs(List<String> list, char c)
	{
		int counter = Integer.MAX_VALUE;
		String[] arr0 = new String[0];
		List<String> arrList = new ArrayList<>();
		if (list == null)
			return null;
		if (list.size() == 0)
			return arr0;
		char c1 = Character.toUpperCase(c);
		char c2 = Character.toLowerCase(c);
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) == null)
				continue;
			int temp = 0;
			for (char ch : list.get(i).toCharArray())
			{
				if (ch == c1 || ch == c2)
					temp++;
			}
			if (temp < counter)
				counter = temp;
		}
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) == null)
				continue;
			int temp = 0;
			for (char ch : list.get(i).toCharArray())
			{
				if (ch == c1 || ch == c2)
					temp++;
			}
			if (temp == counter)
				arrList.add(list.get(i));
		}
		String[] retArr = new String[arrList.size()];
		for (int i = 0; i < arrList.size(); i++)
		{
			retArr[i] = arrList.get(i);
		}
		return retArr;
	}

	public static int[] mostCsLocations(List<String> list, char c)
	{
		int[] arr0 = new int[0];
		if (list == null)
			return null;
		if (list.size() == 0)
			return arr0;
		int counter = 0;
		List<Integer> arrList = new ArrayList<>();
		char c1 = Character.toUpperCase(c);
		char c2 = Character.toLowerCase(c);
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) == null)
				continue;
			int temp = 0;
			for (char ch : list.get(i).toCharArray())
			{
				if (ch == c1 || ch == c2)
					temp++;
			}
			if (temp > counter)
				counter = temp;
		}
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) == null)
				continue;
			int temp = 0;
			for (char ch : list.get(i).toCharArray())
			{
				if (ch == c1 || ch == c2)
					temp++;
			}
			if (temp == counter)
				arrList.add(i);
		}
		int[] retArr = new int[arrList.size()];
		for (int i = 0; i < arrList.size(); i++)
		{
			retArr[i] = arrList.get(i);
		}
		return retArr;
	}
}
