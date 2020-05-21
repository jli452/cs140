package exam01;
import java.util.ArrayList;
import java.util.List;

public class Question2
{
	public static List<MyString> possibleStarts(List<MyString> source, MyString[] possibleStarts)
	{
		if (source == null || possibleStarts == null)
			return null;
		List<MyString> returnList = new ArrayList<>();
		for (int i = 0; i < source.size(); i++)
		{
			if (source.get(i) == null)
				continue;
			else
			{
				boolean b = false;
				for (int j = 0; j < possibleStarts.length; j++)
				{
					if (source.get(i).startsWith(possibleStarts[j]))
						b = true;
				}
			if (b == true)
				returnList.add(source.get(i));
			}
		}
		return returnList;
	}
}
