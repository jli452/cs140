package assignment01;

public class LoanTester
{
	public static void main(String[] args)
	{
		var loan = new FixedIntUnsubLoan(60500, 3.75, 6, 257.12);
		for(int i = 0; i < 15; i++)
		{
			System.out.printf("Year: %d, Remaining loan: %.2f\n", i, loan.getBalanceAfter(12*i));
		}

		System.out.printf("Total months till loan complete: %d\n", loan.monthsToPayLoan());
		System.out.printf("Monthly payment: %.2f\n", FixedIntUnsubLoan.repayAmountCalculator(15000, 4.75, 4, 10));
	}
}
