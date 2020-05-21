package quiz20200413;
import java.time.LocalDate;
public class Person {
	private String lastNames;
	private String firstNames;
	private LocalDate dateOfBirth;
	public Person (String last, String first, int year, int month, int day) {
		lastNames = last;
		firstNames = first;
		dateOfBirth = LocalDate.of(year, month, day);
	}
	public String getLastNames() {
		return lastNames;
	}
	public String getFirstNames() {
		return firstNames;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
}
