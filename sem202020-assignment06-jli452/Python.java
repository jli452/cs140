package assignment06;

public class Python
{
	public String forLayout(String... parts)
	{
		if (parts != null && parts.length == 1)
		{	
			return "for x in " + parts[0];
		}
		throw new IllegalArgumentException("bad arguments");
	}
}
