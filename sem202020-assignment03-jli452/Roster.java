package assignment03;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Roster
{
	private List<Student> classRoster = new ArrayList<>();

	public List<Student> getClassRoster()
	{
		return classRoster;
	}

	public void addStudent(Student s)
	{
		classRoster.add(s);
	}
	
	public void dropStudent(String bNum)
	{
		Iterator<Student> iter = classRoster.iterator();
		while(iter.hasNext())
		{
			if (iter.next().getBNumber().equals(bNum))
			{
				iter.remove();
				break;
			}
		}
	}

	public void dropStudent1(String bNum)
	{
		for (Student st : classRoster)
		{
			if (st.getBNumber().equals(bNum))
			{
				classRoster.remove(st);
				break;
			}
		}
	}

	public void dropStudent2(String bNum)
	{
		boolean removed = false;
		for (int i = 0; i < classRoster.size() && !removed; i++)
		{
			var st = classRoster.get(i);
			if (st.getBNumber().equals(bNum))
			{
				classRoster.remove(st);
				removed = true;
			}
		}
	}

	public String toString()
	{
		StringBuilder ret = new StringBuilder("[");

		for (int i = 0; i < classRoster.size(); i++)
		{
			var st = classRoster.get(i);
			ret.append(st.getAsPerson().getFirstNames());
			ret.append(" ");
			ret.append(st.getAsPerson().getLastNames());
			ret.append(" (");
			ret.append(st.getBNumber());
			ret.append("), ");
		}
		
		if (classRoster.size() > 0)
		{
			ret.setLength(ret.length() - 2);
			ret.append("]");
		}

		return ret.toString();
	}
	
	public void sortByBNum()
	{
		for(int i = 0; i < classRoster.size(); i++)
		{
			for(int j = 1; j < (classRoster.size()-i); j++)
			{
				if(classRoster.get(j-1).getBNumber().compareTo(classRoster.get(j).getBNumber()) > 0)
				{
					Student temp = classRoster.get(j-1);
					classRoster.set(j-1, classRoster.get(j));
					classRoster.set(j, temp);
				}
			}
		}
	}
}
