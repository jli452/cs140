package assignment03;

public class Student
{
	private Person asPerson;
	private String major;
	private double gpa;
	private String bNumber;

	public Student(Person person, String aMajor, double aGpa, String bNum)
	{
		asPerson = person;
		major = aMajor;
		gpa = aGpa;
		bNumber = bNum.toUpperCase();
	}

	public Person getAsPerson()
	{
		return asPerson;
	}
	
	public String getMajor()
	{
		return major;
	}

	public double getGpa()
	{
		return gpa;
	}

	public String getBNumber()
	{
		return bNumber;
	}

	public void setGpa(double aGpa) 
	{
		gpa = aGpa;
	}
	
	public int compareByGpaTo(Student other)
	{
		return Double.compare(gpa, other.gpa);
	}
}
