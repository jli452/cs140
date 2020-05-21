package lab08;

import java.util.List;

public class Recursion {
	public static final double DELTA = 1e-6;

	public static int recurse(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 3;
		else
			return 2*recurse(n-1) - recurse(n-2) - 1;
	}

	public static double squareRoot(double n) {
		return squareRootHelper(n, 5);
	}

	private static double squareRootHelper(double n, double approx) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (Math.abs(approx*approx-n) < DELTA)
			return approx;
		else
			return squareRootHelper(n, (approx + n/approx) / 2);	
	}

	public static int sum(List<Integer> nums) {
		return sumHelper(nums, 0);
	}

	private static int sumHelper(List<Integer> nums, int index) {
		if (nums.isEmpty())
			return 0;
		else {
			try {
				return nums.get(index) + sumHelper(nums, index + 1);
			} catch(IndexOutOfBoundsException e) {
				return 0;
			}
		}
	}

	public static int sum(int[] nums) {
		return sumHelper(nums, 0);
	}

	private static int sumHelper(int[] nums, int index) {
		try {
			return nums[index] + sumHelper(nums, index+1);
		} catch(IndexOutOfBoundsException e) {
			return 0;
		}
	}

	public static int binomialCoefficient(int n, int k) {
		if (k == 0)
			return 1;
		if (k > n/2)
			return binomialCoefficient(n, n-k);
		return binomialCoefficient(n-1, k-1) + binomialCoefficient(n-1, k);
	}

	public static void printPascalsTriangle(int limit) {
		int counter = 0;
		if (limit == 0)
			System.out.print(binomialCoefficient(limit, limit) + " ");
		else {
			counter++;
			printPascalsTriangle(limit-counter);
			System.out.println();
			for (int i = 0; i < limit+1; i++) {
				System.out.print(binomialCoefficient(limit, i) + " ");
			}
		}
	}

	public static void main(String[] args) {
		printPascalsTriangle(5);
	}
}
