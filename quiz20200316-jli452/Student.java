package quiz20200316;
public class Student implements Comparable<Student>, Cloneable 
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
	@Override
	public int compareTo(Student st) 
	{
		if (getAsPerson().getLastNames().compareTo(st.getAsPerson().getLastNames()) == 0)
			return getAsPerson().getFirstNames().compareTo(st.getAsPerson().getFirstNames());
		if (Double.compare(gpa, st.gpa) == 0)
			return getAsPerson().getLastNames().compareTo(st.getAsPerson().getLastNames());
		return Double.compare(gpa, st.gpa);
	// TODO the basic return value is Double.compare(gpa, st.gpa)
	// but if that is 0 (this and st have the same GPA) then
	// set the return value to be compareTo of getAsPerson().getLastNames() applied to
	// st.getAsPerson().getLastNames()
	// and if that is 0 (the last names are the same)
	// return the compareTo of the first names
	}
	@Override
	public Student clone() 
	{
	// TODO -- same process as for Person
	// Person has been written to be immutable, String is immutable and the gpa is a primitive
		try {
			return (Student)super.clone();
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
}