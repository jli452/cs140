package lab06;

public class SavingsAccount extends BankAccount{
	private double rate;
	
	public SavingsAccount(double balance, double rate) {
		super(balance);
		if (rate < 0)
			throw new IllegalArgumentException("rate cannot be negative");
		this.rate = rate;
	}
	
	@Override
	public void deposit(double amount) {
		if (amount < 0)
			throw new IllegalArgumentException("deposits must be done with positive values");
		double amt = amount + (rate * amount);
		super.deposit(amt);
	}

	public double getRate() {
		return rate;
	}
	
	@Override
	public String toString() {
		return super.toString() + " @ " + rate*100 + "%";
	}
}
