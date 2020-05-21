package assignment02;

import java.time.LocalDate;
import java.time.Period;

public class Person 
{
	private String lastNames;
	private String firstNames;
	private LocalDate dateOfBirth;

	public Person(String last, String first, int year, int month, int day)
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

	public int ageInYears()
	{
		var today = LocalDate.now();
		var p = Period.between(dateOfBirth, today);
		return p.getYears();
	}

	public String exactAge()
	{
		var today = LocalDate.now();
		var p = Period.between(dateOfBirth, today);
		return p.getYears() + " years, " + p.getMonths() + " months, " + p.getDays() + " days";
	}

	public int compareAgesTo(Person other)
	{
		return dateOfBirth.compareTo(other.dateOfBirth);
	}
}
