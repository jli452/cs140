package quiz20200401;
/**
A bank account has a balance that can be changed by 
deposits and withdrawals.
*/
public class BankAccount implements Comparable<BankAccount> {
	private static int NEXT_ID = 1; 
	private double balance;
	private int id;

	/**
   Constructs a bank account with a zero balance.
	 */
	public BankAccount() {   
		balance = 0;
		id = NEXT_ID++;
	}

	/**
   Constructs a bank account with a given balance.
   @param initialBalance the initial balance
	 */
	public BankAccount(double initialBalance) {   
		balance = initialBalance;
		id = NEXT_ID++;
	}

	/**
   Deposits money into the bank account.
   @param amount the amount to deposit
	 */
	public void deposit(double amount) {  
		balance = balance + amount;
	}

	/**
   Withdraws money from the bank account.
   @param amount the amount to withdraw
	 */
	public void withdraw(double amount) {   
		balance = balance - amount;
	}

	/**
   Gets the current balance of the bank account.
   @return the current balance
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
	
	public static void resetNextId() {
		NEXT_ID = 1;
	}
}
