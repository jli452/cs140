package assignment01;

public class Utilities
{
	public static Person oldest(Person p0, Person p1, Person p2, Person p3, Person p4)
	{
		var oldest = p0;

		if (oldest.compareAgesTo(p1) > 0)
		{
			oldest = p1;
		}
		if (oldest.compareAgesTo(p2) > 0)
		{
			oldest = p2;
		}
		if (oldest.compareAgesTo(p3) > 0)
		{
			oldest = p3;
		}
		if (oldest.compareAgesTo(p4) > 0)
		{
			oldest = p4;
		}

		return oldest;
	}

	public static Student topGpa(Student p0, Student p1, Student p2, Student p3, Student p4)
	{
		var topGpa = p0;

		if (topGpa.compareByGpaTo(p1) < 0)
		{
			topGpa = p1;
		}
		if (topGpa.compareByGpaTo(p2) < 0)
		{
			topGpa = p2;
		}
		if (topGpa.compareByGpaTo(p3) < 0)
		{
			topGpa = p3;
		}
		if (topGpa.compareByGpaTo(p4) < 0)
		{
			topGpa = p4;
		}

		return topGpa;
	}
}
