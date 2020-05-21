package exam01;
import java.util.*;

public class MyString
{
	private char[] chars;

	public MyString()
	{
	}

	public MyString(String str)
	{
		if (str != null)
			chars = str.toCharArray();
	}

	public String toString()
	{
		if (chars == null)
			return "no chars";
		else
			return Arrays.toString(chars);
	}

	public MyString toUpperCase()
	{
		MyString str = new MyString();
		if (chars == null)
			return str;
		else
		{
			char[] charv = new char[chars.length];
			str.chars = charv;
		}
		for (int i = 0; i < chars.length; i++)
			str.chars[i] = Character.toUpperCase(chars[i]);
		return str;
	}

	public boolean startsWith(MyString str)
	{
		if (str == null || chars == null || str.chars.length > chars.length)
			return false;
		for (int i = 0; i < str.chars.length; i++)
		{
			if (chars[i] != str.chars[i])
				return false;
		}
		return true;
	}
}
