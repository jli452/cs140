package quiz20200413;
import java.util.ArrayList;
import java.util.List;
public class Driver {
	private static Person[] people =  {
			new Person("Fleming", "Susana", 2002, 3, 19),
			new Person("Villa", "Marcella", 1995, 8, 13),
			new Person("Wiley", "Chasity", 1999, 9, 15),
			new Person("Marks", "Adele", 2016, 11, 4),
			new Person("Anthony", "Dana", 1993, 8, 18),
			new Person("Deleon", "Angelica", 1997, 1, 26),
			new Person("Jensen", "Daryl", 2011, 8, 28),
			new Person("Farley", "Jerry", 1977, 2, 19),
			new Person("Powers", "Elizabeth", 1978, 5, 10),
			new Person("Bruce", "Clifford", 1974, 5, 18),
			new Person("Sweeney", "Angelique", 1974, 11, 16),
			new Person("Whitney", "Hope", 1999, 12, 10),
			new Person("Nguyen", "Hugh", 1983, 6, 21),
			new Person("Fitzgerald", "Jody", 1981, 4, 2),
			new Person("Bartlett", "Alissa", 2004, 1, 15),
			new Person("Garner", "Gene", 1997, 4, 14),
			new Person("Archer", "Carole", 2015, 12, 11),
			new Person("Osborne", "Kris", 1972, 9, 27),
			new Person("Collins", "Laverne", 2009, 8, 21)
	};
	public static void main(String[] args) {
		List<BankAccount> accountList = new ArrayList<>();
		for(Person p : people) accountList.add(new BankAccount(p, 100 + 1000*Math.random()));
		System.out.println(accountList);
	}
}
