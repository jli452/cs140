package exam01;

public class Student {
	private String name;
	private double gpa;
	public Student(String aName, double aGpa) 
	{
		name = aName;
		gpa = aGpa;
	}
	public String getName() 
	{
		return name;
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
