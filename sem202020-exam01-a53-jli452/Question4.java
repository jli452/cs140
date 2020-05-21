package exam01;

public class Question4
{
	private int[] numbers;
	private char[] guesses;

	public Question4(int[] arrA, char[] arrB)
	{
		if (arrA == null || arrB == null || arrA.length != 21 || arrB.length != 20)
			throw new IllegalArgumentException("bad input");
		numbers = arrA;
		guesses = arrB;
	}

	public String winner()
	{
		int points = 0;
		for (int i = 0; i < guesses.length; i++)
		{
			if (guesses[i] == 'H' && numbers[i+1] > numbers[i])
				points++;
			else if (guesses[i] == 'L' && numbers[i+1] < numbers[i])
				points++;
			else points--;
		}
		if (points > 0)
			return "you win";
		else if (points < 0)
			return "you lose";
		else return "you tie";
	}
}
