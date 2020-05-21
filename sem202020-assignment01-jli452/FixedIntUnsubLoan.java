package assignment01;

public class FixedIntUnsubLoan
{
	private double originalAmount;
	private double interestRate;
	private int nonPayYears;
	private double repaymentAmount;
	
	public FixedIntUnsubLoan(double amt, double ir, int npYears, double repay)
	{
		originalAmount = amt;
		interestRate = ir;
		nonPayYears = npYears;
		repaymentAmount = repay;
	}
	
	public double getOriginalAmount()
	{
		return originalAmount;
	}
	public double getInterestRate()
	{
		return interestRate;
	}
	public int getNonPayYears()
	{
		return nonPayYears;
	}
	public double getRepaymentAmount()
	{
		return repaymentAmount;
	}

	public double getBalanceAfter(int months)
	{
		double amt = originalAmount;
		if (months <= 12*nonPayYears)
		{
			for (int i = 0; i < months; i++)
				{
					amt+=amt*(interestRate/1200);
				}
		}
		else
		{
			for (int i = 0; i < 12*nonPayYears; i++)
			{
				amt+=amt*(interestRate/1200);
			}
			for (int i = 0; i < months - 12 * nonPayYears; i++)
			{
				amt-=repaymentAmount;
				amt+=amt*(interestRate/1200);
			}
		}
		return amt;
	}

	public int monthsToPayLoan()
	{
		int months = 0;
		double amountToPay = originalAmount;
		
		while(amountToPay > 0)
		{
			amountToPay = getBalanceAfter(months);
			months++;
		}
		return months-1;
	}

	public static double repayAmountCalculator(double amt, double ir, int npYears, int desiredPaymentYears)
	{
		double payments = amt/(12*desiredPaymentYears);
		var test = new FixedIntUnsubLoan(amt, ir, npYears, payments);

		while(test.monthsToPayLoan() > (12*(npYears+desiredPaymentYears)))
		{
			payments+=.01;
			test = new FixedIntUnsubLoan(amt, ir, npYears, payments);	
		}
	
		return payments;
	}
}
