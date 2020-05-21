package assignment06;

public class Ada
{
	public String forLayout(String... parts)
	{
		if (parts != null && parts.length == 1)
		{
			return "for x in " + parts[0] + " loop\n\n\n\nend loop;";
		}
		throw new IllegalArgumentException("bad arguments");
	}
}
