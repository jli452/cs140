package assignment05;

public class Partitioner
{
	public static double[] moduloPartition(int[] arr, int mod)
	{
		if (arr == null || arr.length == 0 || mod <= 0)
			throw new IllegalArgumentException("Bad input");
		double[] retArr = new double[mod];
		for (int i = 0; i < arr.length; i++)
			retArr[arr[i]%mod]+=1;
		for (int i = 0; i < retArr.length; i++)
			retArr[i] = retArr[i]*100/arr.length;
		return retArr;
	}
}
