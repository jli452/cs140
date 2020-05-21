package lab03;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ArrayListPractice
{
	public static int intRemoveAll1(List<Integer> list, int e)
	{
		Iterator<Integer> iter = list.iterator();
		int counter = 0;
		while(iter.hasNext())
		{
	    	if(iter.next().equals(e))
			{
				counter++;
				iter.remove();
			}
        }
		return counter;
	}

	public static int intRemoveAll2(List<Integer> list, int e)
	{
		int counter = 0;
		if (list != null && !list.isEmpty())
		{
			Iterator<Integer> iter = list.iterator();
			while(iter.hasNext())
			{
				if(iter.next() == null)
					iter.remove();
				else
				{
					if(iter.next().equals(e))
					{
						counter++;
						iter.remove();
					}
				}
		    }
		}
		return counter;
	}

	public static boolean isEqual1(List<Integer> alpha, List<Integer> other)
	{
		int counter = 0;
		if (alpha.size() == other.size())
		{
			Iterator<Integer> iter = alpha.iterator();
			Iterator<Integer> iter2 = other.iterator();
			while(iter.hasNext())
			{
				if (iter.next() == iter2.next())
					counter++;
				else
					return false;
			}
			if (counter == alpha.size())
				return true;
			else
				return false;
		}
		else
			return false;
	}

	public static boolean isEqual2(List<Integer> alpha, List<Integer> other)
	{
		boolean isBothNull = false;
		if (alpha == null && other == null)
		{
			isBothNull = true;
			return true;
		}
		else if (alpha == null && isBothNull == false || other == null && isBothNull == false)
			return false;

		int counter = 0;
		if (alpha.size() == other.size())
		{
			Iterator<Integer> iter = alpha.iterator();
			Iterator<Integer> iter2 = other.iterator();
			while(iter.hasNext())
			{
				if (iter.next() == iter2.next())
					counter++;
				else
					return false;
			}
			if (counter == alpha.size())
				return true;
			else
				return false;
		}
		else
			return false;
	}
}
