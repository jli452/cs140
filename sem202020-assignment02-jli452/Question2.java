package assignment02;
import java.util.Random;
import java.util.Arrays;

public class Question2
{
	private int length1;
	private Random rand = new Random();

	public Question2(int len)
	{
		length1 = len;
	}
	
	public String[] makeStringArray()
	{
		String[] arr = new String[length1];

		for (int i = 0; i < arr.length; i++)
			{
				byte[] bArray = new byte[i+1];
				for (int j = 0; j < i + 1; j++)
					bArray[j] = (byte)(65 + rand.nextInt(26));
				arr[i] = new String(bArray);
			}

		return arr;
	}

	public int[][] makeTriangleArray()
	{
		int[][] retArray = new int[length1][];
		for (int i = 0; i < retArray.length; i++)
		{
			retArray[i] = new int[i+1];

			for (int j = 0; j < i + 1; j++)
				retArray[i][j] = 10 + rand.nextInt(90);
		}

		return retArray;
	}

	public int[][] makeSymmetricArray()
	{
		var arr = makeTriangleArray();
		int[][] retArray = new int[length1][length1];

		for(int i = 0; i < length1; i++)
		{
			for(int j = 0; j <= i; j++)
			{
				retArray[i][j] = arr[i][j];
				if (i != j)
					retArray[j][i] = retArray[i][j];
			}
		}
		return retArray;
	}

	public int[][] makePascalTriangle()
	{
		int[][] retArray = new int[length1][];
		retArray[0] = new int[]{1};
		
		for (int i = 1; i < length1; i++)
		{
			retArray[i] = new int[i+1];
			retArray[i][0] = 1;
			retArray[i][i] = 1;
			
			for (int j = 1; j < i; j++)
				retArray[i][j] = retArray[i-1][j-1] + retArray[i-1][j];
		}
		return retArray;
	}
	
	public static int[] makeRowMajor(int[][] array)
	{
		if (array == null)
			throw new IllegalArgumentException("Null array");
		if (array.length == 0)
			throw new IllegalArgumentException("Empty array");
		if (array[0] == null)
			throw new IllegalArgumentException("Null first row");

		int numCols = array[0].length;
		for (int i = 1; i < array.length; i++)
		{
			if (array[i] == null)
				throw new IllegalArgumentException("Null row " + i);
			if (array[i].length != numCols)
				throw new IllegalArgumentException("Array is ragged");
		}
		
		int retVal[] = new int[2 + numCols*array.length];
		retVal[0] = array.length;
		retVal[1] = numCols;

		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < numCols; j++)
				retVal[2+ i*numCols + j] = array[i][j];
		}
		return retVal;
	}

	public static int[][] unfoldRowMajor(int[] array)
	{
		if (array == null)
			throw new IllegalArgumentException("Null array");
		if (array.length < 2)
			throw new IllegalArgumentException("Illegal array");

		int numRows = array[0];
		int numCols = array[1];

		if (array.length != 2 + numRows*numCols)
			throw new IllegalArgumentException("Illegal array");

		int retArray[][] = new int[numRows][numCols];
		
		for (int i = 0; i < numRows; i++)
		{
			for (int j = 0; j < numCols; j++)
			{
				retArray[i][j] = array[2+ i*numCols + j];
			}
		}
		return retArray;
	}

	public static void main(String[] args) 
	{
		var arr = new Question2(12).makeStringArray();
		for (String s : arr)
			System.out.println(s);

		System.out.println("-----------------------------------");
		var arr1 = new Question2(12).makeTriangleArray();
		for (int[] row : arr1)
			System.out.println(Arrays.toString(row));

		System.out.println("-----------------------------------");
		var arr2 = new Question2(12).makeSymmetricArray();
		for (int[] row : arr2)
			System.out.println(Arrays.toString(row));

		System.out.println("-----------------------------------");
		var arr3 = new Question2(12).makePascalTriangle();
		for (int i = 0; i < 12; i++) 
		{
			for(int j = 0; j < 11 - i; j++)
				System.out.print("  ");
			for(int j = 0; j < arr3[i].length; j++)
				System.out.printf("%4d", arr3[i][j]);
			System.out.println();
		}

		System.out.println("-----------------------------------");
		int[][] matrix = {
			{ 1, 2, 3, 4, 5, 6},
			{ 7, 8, 9,10,11,12},
			{13,14,15,16,17,18},
			{19,20,21,22,23,24}
			};
		int[] linearVersion = makeRowMajor(matrix);
		System.out.println(Arrays.toString(linearVersion));					
		// the 4, 6 at the beginning are the counts of rows and columns

		System.out.println("-----------------------------------");
		int[][] arr4 = unfoldRowMajor(linearVersion);
		for (int[] row : arr4) System.out.println(Arrays.toString(row));
			System.out.println("Comparing equality of rows:");
		for (int i = 0; i < matrix.length; i++) 
			System.out.println("Row " + i + " equal: " + Arrays.equals(matrix[i], arr4[i]));
	}
}
