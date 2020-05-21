package lab01;

public class Student
{
	private Person asPerson;
	private String major;
	private double gpa;

	public Student(Person person, String aMajor, double aGpa)
	{
		asPerson = person;
		major = aMajor;
		gpa = aGpa;
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

	public void setGpa(double aGpa) 
	{
		gpa = aGpa;
	}
}
