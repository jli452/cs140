package assignment03;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

public class Driver
{
	public static void main(String[] args)
	{
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new LinkedList<>();
	
		a = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		int[] c ={1, 2, 3};
		Assignment03.appendArray(a,c);
		System.out.println("Expected: [1, 2, 3, 4, 5, 1, 2, 3]");
		System.out.println("Actual: " + a);		

		a = new ArrayList<>(Arrays.asList(1,2,3,4));
		b = new LinkedList<>(Arrays.asList(1,2,3,4));
		System.out.println("Expected: [2, 4, 6, 8]");
		System.out.println("Actual: " + Assignment03.sumElementWise(a,b));
		a = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		b = new LinkedList<>(Arrays.asList(1,2,3,4));
		System.out.println("Expected: [2, 4, 6, 8, 5, 6]");
		System.out.println("Actual: " + Assignment03.sumElementWise(a,b));
		a = new ArrayList<>(Arrays.asList(2,2,2,2));
		b = new LinkedList<>(Arrays.asList(3,2,1,0,78,93));
		System.out.println("Expected: [5, 4, 3, 2, 78, 93]");
		System.out.println("Actual: " + Assignment03.sumElementWise(a,b));
	}
}
