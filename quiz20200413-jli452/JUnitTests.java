package quiz20200413;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JUnitTests {
	List<BankAccount> accountList; 
	Person[] people;
	@BeforeEach
	void setUp() throws Exception {
		BankAccount.reset();
		people =  new Person[] {
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
	}

	@Test
	void testBankAccountPerson() {
		new BankAccount(people[0]);
		assertEquals("Fleming", BankAccount.getOwnerName(1));
		new BankAccount(people[1]);
		assertEquals("Villa", BankAccount.getOwnerName(2));
	}

	@Test
	void testBankAccountPersonDouble() {
		BankAccount b1 = new BankAccount(people[0], 123.40);
		assertEquals("Fleming", BankAccount.getOwnerName(1));
		assertEquals("Ac1($123.40)", b1.toString());
		BankAccount b2 = new BankAccount(people[1], 567.80);
		assertEquals("Villa", BankAccount.getOwnerName(2));
		assertEquals("Ac2($567.80)", b2.toString());
	}

	@Test
	void testGetOwnerName() {
		accountList = new ArrayList<>();
		for(int i = 0; i <people.length; i++) 
			accountList.add(new BankAccount(people[i], 100 + 15.56*i));
		for(int i = 0; i <people.length; i++) 
			assertEquals(people[i].getLastNames(), BankAccount.getOwnerName(i+1));
	}

	@Test
	void testAccNumA() {
		accountList = new ArrayList<>();
		for(int i = 0; i <people.length; i++) 
			accountList.add(new BankAccount(people[i], 100 + 15.56*i));
		assertTrue(Set.of(3, 10, 17).contains(BankAccount.accNum('c')));
	}

	@Test
	void testAccNumB() {
		accountList = new ArrayList<>();
		for(int i = 0; i <people.length; i++) 
			accountList.add(new BankAccount(people[i], 100 + 15.56*i));
		assertTrue(Set.of(4, 6, 11, 15).contains(BankAccount.accNum('A')));
	}

	@Test
	void testAccNumC() {
		accountList = new ArrayList<>();
		for(int i = 0; i <people.length; i++) 
			accountList.add(new BankAccount(people[i], 100 + 15.56*i));
		assertEquals(-1, BankAccount.accNum('z'));
	}

	@Test
	void testGetAccountsA() {
		accountList = new ArrayList<>();
		for(int i = 0; i <people.length; i++) 
			accountList.add(new BankAccount(people[i], 100 + 15*i));
		Set<BankAccount> set1 = new HashSet<>();
		for(int i = 6; i < 13; i++) set1.add(accountList.get(i));
		Set<Person> set2 = new HashSet<>();
		for(Person p : BankAccount.getAccounts(190, 280)) set2.add(p);
	}

	@Test
	void testGetAccountsB() {
		accountList = new ArrayList<>();
		for(int i = 0; i <people.length; i++) 
			accountList.add(new BankAccount(people[i], 100 + 15*i));
		Set<BankAccount> set1 = new HashSet<>();
		for(int i = 6; i < 13; i++) set1.add(accountList.get(i));
		Set<Person> set2 = new HashSet<>();
		for(Person p : BankAccount.getAccounts(190, 290)) set2.add(p);
	}

	@Test
	void testGetAccountsC() {
		accountList = new ArrayList<>();
		for(int i = 0; i <people.length; i++) 
			accountList.add(new BankAccount(people[i], 100 + 15*i));
		Set<BankAccount> set1 = new HashSet<>();
		for(int i = 6; i < 13; i++) set1.add(accountList.get(i));
		Set<Person> set2 = new HashSet<>();
		for(Person p : BankAccount.getAccounts(180, 280)) set2.add(p);
	}
	
	@Test
	void testQuiz413SubstringsA() {
		assertNull(Quiz413.substrings(null));
	}

	@Test
	void testQuiz413SubstringsB() {
		assertEquals("[]",Quiz413.substrings("").toString());
	}

	@Test
	void testQuiz413SubstringsC() {
		List<String> list1 = new ArrayList<>(Arrays.asList("abcda", "abcd", "abca", 
				"abc", "abda", "abd", "aba", "ab", "acda", "acd", "aca", "ac", 
				"ada", "ad", "aa", "a", "bcda", "bcd", "bca", "bc", "bda", "bd", 
				"ba", "b", "cda", "cd", "ca", "c", "da", "d", "a", ""));
		List<String> list2 = new ArrayList<>();
		for(String s : Quiz413.substrings("abcda")) list2.add(s);
		Collections.sort(list1);
		Collections.sort(list2);
		assertEquals(list1, list2);
	}

	@Test
	void testQuiz413Substrings2A() {
		assertNull(Quiz413.substrings2(null));
	}

	@Test
	void testQuiz413Substrings2B() {
		assertEquals("[]",Quiz413.substrings2("").toString());
	}

	@Test
	void testQuiz413Substrings2C() {
		Set<String> set1 = new HashSet<>(Arrays.asList("abcda", "abcd", "abca", 
				"abc", "abda", "abd", "aba", "ab", "acda", "acd", "aca", "ac", 
				"ada", "ad", "aa", "a", "bcda", "bcd", "bca", "bc", "bda", "bd", 
				"ba", "b", "cda", "cd", "ca", "c", "da", "d", "a", ""));
		List<String> list = new ArrayList<>();
		for(String s : Quiz413.substrings2("abcda")) list.add(s);
		assertEquals(set1.size(), list.size());
		Set<String> set2 = new HashSet<>();
		set2.addAll(list);
		assertEquals(set1, set2);
	}
}
