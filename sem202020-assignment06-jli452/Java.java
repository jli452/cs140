package assignment06;

public class Java
{
	public String forLayout(String... parts)
	{
		if (parts != null && parts.length == 1)
		{
			return "for(var x : " + parts[0] + ")\n{\n\n\n}";
		}
		if (parts != null && parts.length == 3)
		{
			return "for(" + parts[0] + "; " + parts[1] + "; " + parts[2] + ")\n{\n\n\n}";
		}
		throw new IllegalArgumentException("bad arguments");
	}
}
