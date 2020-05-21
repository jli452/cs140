package lab06;

public class BankAccount {
	private double balance;
	private int idNum;
	private static int numAccounts = 0;

	public BankAccount(double bal) {
		if (bal < 0)
			throw new IllegalArgumentException("bal cannot be negative");
		balance = bal;
		idNum = numAccounts;
		numAccounts++;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getIdNum() {
		return idNum;
	}

	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}

	static void reset() {
		numAccounts = 0;
	}
	
	@Override
	public String toString() {
		return "Acct. #" + idNum + " has $" + balance;
	}
	
	public void deposit(double amount) {
		if (amount < 0)
			throw new IllegalArgumentException("deposits must be done with positive values");
		balance += amount;
	}
	
	public double withdraw(double amount) {
		if (amount < 0)
			throw new IllegalArgumentException("withdrawals must be done with positive values");
		if (amount < balance) {
			balance -= amount;
			return amount;
		}
		else {
			double withdrawnAmt = balance;
			balance = 0;
			return withdrawnAmt;
		}
		
	}
}