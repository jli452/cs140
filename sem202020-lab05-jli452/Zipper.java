package lab05;

public class Zipper
{
	public static int[] zip(int[] arr1, int[] arr2)
	{
		if (arr1 == null || arr2 == null || arr1.length != arr2.length)
			throw new IllegalArgumentException("bad input");
		int[] arr3 = new int[arr1.length+arr2.length];
		for (int i = 0; i < arr3.length; i+=2)
			arr3[i] = arr1[i/2];
		for (int i = 0; i < arr3.length; i++)
		{
			if (arr3[i] == 0)
				arr3[i] = arr2[i/2];
			else continue;
		}
		return arr3;
	}
}
