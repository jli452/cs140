package quiz20200413;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A bank account has a balance that can be changed by 
 * deposits and withdrawals.
 */
public class BankAccount implements Comparable<BankAccount> {
	private static int NEXT_ID = 1; 
	private double balance;
	private int id;
	private Person owner;
	/**
	 * Constructs a bank account with a zero balance.
	 */
	public BankAccount(Person aPerson) {   
		balance = 0;
		id = NEXT_ID++;
		owner = aPerson;
		owners.put(this, owner);
		accounts.put(owner, this);
	}
	/**
	 * Constructs a bank account with a given balance.
	 * @param initialBalance the initial balance
	 */
	public BankAccount(Person aPerson, double initialBalance) {   
		balance = initialBalance;
		id = NEXT_ID++;
		owner = aPerson;
		owners.put(this, owner);
		accounts.put(owner, this);
	}
	/**
	 * Deposits money into the bank account.
	 * @param amount the amount to deposit
	 */
	public void deposit(double amount) {  
		balance = balance + amount;
	}
	/**
	 * Withdraws money from the bank account.
	 * @param amount the amount to withdraw
	 */
	public void withdraw(double amount) {   
		balance = balance - amount;
	}
	/**
	 * Gets the current balance of the bank account.
	 * @return the current balance
	 */
	public double getBalance() {   
		return balance;
	}
	public int compareTo(BankAccount other) {
		return Double.compare(balance, other.balance);
	}
	public String toString() {
		return String.format("Ac%d($%.2f)", id, balance);
	}
	static void reset() {
		NEXT_ID = 1;
		owners.clear();
		accounts.clear();
	}
	
	public static Map<BankAccount, Person> owners = new HashMap<>();
	public static Map<Person, BankAccount> accounts = new HashMap<>();
	
	public static String getOwnerName(int num) {
		for(var x : owners.keySet()) {
			if (num == x.id)
				return owners.get(x).getLastNames();
		}
		return "";
	}
	
	public static int accNum(char ch) {
		char temp = Character.toLowerCase(ch);
		for(var x : accounts.keySet()) {
			if (temp == (x.getFirstNames().toLowerCase().charAt(0)))
				return accounts.get(x).id;
		}
		return -1;
	}
	
	public static List<Person> getAccounts(int low, int high) {
		List<Person> retList = new ArrayList<>();
		int counter = 0;
		for(var x : owners.keySet()) {
			if (x.getBalance() > low && x.getBalance() < high) {
				retList.add(owners.get(x));
				counter++;
			}
		}
		if (counter > 0)
			return retList;
		return null;
	}
	
	public static void main(String[] args) {
		List<BankAccount> accountList; 
		Person[] people;
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
		accountList = new ArrayList<>();
		for(int i = 0; i <people.length; i++) 
			accountList.add(new BankAccount(people[i], 100 + 15.56*i));
		System.out.println((BankAccount.accNum('A')));
	}
}
