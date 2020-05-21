package quiz20200316;
import java.time.LocalDate;
public class Person implements Comparable<Person>, Cloneable 
{
	private String lastNames;
	private String firstNames;
	private LocalDate dateOfBirth;
	public Person (String last, String first, int year, int month, int day)
	{
		lastNames = last;
		firstNames = first;
		dateOfBirth = LocalDate.of(year, month, day);
	}
	public String getLastNames() 
	{
		return lastNames;
	}
	public String getFirstNames() 
	{
		return firstNames;
	}
	public LocalDate getDateOfBirth() 
	{
		return dateOfBirth;
	}
	@Override
	public int compareTo(Person o) 
	{
	// TODO the return value is set to the
	// compareTo of the dateOfBirth fields (LocalDate is comparable)
	// if that is 0 the return value is set to the
	// compareTo of the lastNames fields (String is comparable)
	// if that is 0 the return value is set to the
	// compareTo of the firstNames fields (String is comparable)
		if (lastNames.compareTo(o.getLastNames()) == 0)
			return firstNames.compareTo(o.getFirstNames());
		if (dateOfBirth.compareTo(o.getDateOfBirth()) == 0)
			return lastNames.compareTo(o.getLastNames());
		return dateOfBirth.compareTo(o.getDateOfBirth());
	}
	@Override
	public Person clone() 
	{
	// TODO Since fields are immutable use the same approach as BankAccount2.java
	// that was downloaded with notes05ver3
		try {
			return (Person)super.clone();
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
}