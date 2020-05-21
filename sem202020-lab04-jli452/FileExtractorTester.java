package lab04;
import java.util.Arrays;

public class FileExtractorTester
{
	public static void main(String[] args)
	{
		if (args.length != 1)
			throw new IllegalArgumentException("The program requires exactly 1 argument, the name of a file to be opened");
		FileExtractor fe = new FileExtractor(args[0]);
		System.out.println("Expected:");
		System.out.println("array: [5, 20, 8, 13, 46, 7]");
		System.out.println("list: [5, 20, 8, 13, 46, 7]");
		System.out.println("Actual:");
		System.out.println(fe+"\n");

		fe.removeOddElements();
		fe.removeEvenElements();
		System.out.println("Expected:");
		System.out.println("array: [20, 8, 46]");
		System.out.println("list: [5, 13, 7]");
		System.out.println("Actual:");
		System.out.println(fe+"\n");

		int n = 0;
		int array[] = new int[5];
		for (int i : array)
		{
			i = n;
			n++;
		}
		System.out.println(Arrays.toString(array));

		String[] strings = {"Comp", "Sci", "is", "crazy"};
		for (String i : strings)
		{
			System.out.println(i + " " + i.length());
		}

		var test1 = FileExtractor.makeUsingStream(args[0]);
		test1.streamRemoveOddElements();
		System.out.println(test1);

		var test2 = FileExtractor.oldWayButWorksOnAllFiles(args[0]);
		test2.streamRemoveOddElements();
		System.out.println(test2);
	}
}
