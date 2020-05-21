package assignment04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q3Tester1 {
	public static void main(String[] args) 
	{
		List<String> list1 = null;
		List<String> test1 = Question3.longest(list1);
		if(test1 == null) 
		{
			System.out.println("Test 1 passed: " + test1 + " is null");
		} else {
			System.out.println("Test 1 failed: " + test1 + " is not null");
		}

		list1 = new ArrayList<>();
		test1 = Question3.longest(list1);
		if(test1.isEmpty()) 
		{
			System.out.println("Test 2 passed: " + test1 + " is empty");
		} else {
			System.out.println("Test 2 failed: " + test1 + " is not empty");
		}

		list1 = new ArrayList<String>(Arrays.asList("Eleven", "Six", "Twenty", "Twelve", "", null));
		test1 = Question3.longest(list1);
		Collections.sort(test1);
		if(test1.toString().equals("[Eleven, Twelve, Twenty]")) 
		{
			System.out.println("Test 3 passed: " + test1 + " contains \"Eleven\", \"Twelve\", \"Twenty\"");
		} else {
			System.out.println("Test 3 failed: " + test1 + " does not contain \"Eleven\", \"Twelve\", \"Twenty\"");
		}
		
		list1 = null;
		String[] array = Question3.shortest(list1);
		if(array == null) 
		{
			System.out.println("Test 4 passed: " + array + " is null");
		} else {
			System.out.println("Test 4 failed: " + array + " is not null");
		}

		list1 = new ArrayList<>();
		array = Question3.shortest(list1);
		if(array.length == 0) 
		{
			System.out.println("Test 5 passed: " + Arrays.toString(array) + " is empty");
		} else {
			System.out.println("Test 5 failed: " + Arrays.toString(array) + " is not empty");
		}

		list1 = new ArrayList<String>(Arrays.asList("Eleven", "Eighteen", "Twenty", "Twelve", "", null));
		array = Question3.shortest(list1);
		Arrays.sort(array);
		if(Arrays.toString(array).equals("[]")) 
		{
			System.out.println("Test 6 passed: " + Arrays.toString(array) + " contains \"\"");
		} else {
			System.out.println("Test 6 failed: " + Arrays.toString(array) + " does not contain \"\"");
		}

		list1 = new ArrayList<String>(Arrays.asList("Eleven", "Eighteen", "Twenty", "One Hundred", "Twelve", null));
		array = Question3.shortest(list1);
		Arrays.sort(array);
		if(Arrays.toString(array).equals("[Eleven, Twelve, Twenty]")) 
		{
			System.out.println("Test 7 passed: " + Arrays.toString(array) + " contains \"Eleven\", \"Twelve\", \"Twenty\"");
		} else {
			System.out.println("Test 7 failed: " + Arrays.toString(array) + " does not contain \"Eleven\", \"Twelve\", \"Twenty\"");
		}
		list1 = null;
		int[] array1 = Question3.longestLocations(list1);
		if(array1 == null) 
		{
			System.out.println("Test 8 passed: " + array1 + " is null");
		} else {
			System.out.println("Test 8 failed: " + array1 + " is not null");
		}

		list1 = new ArrayList<>();
		array1 = Question3.longestLocations(list1);
		if(array1.length == 0) 
		{
			System.out.println("Test 9 passed: " + Arrays.toString(array1) + " is empty");
		} else {
			System.out.println("Test 9 failed: " + Arrays.toString(array1) + " is not empty");
		}

		list1 = new ArrayList<String>(Arrays.asList("Eleven", "Eighteen", "Twenty", "Twelve", "", null));
		array1 = Question3.longestLocations(list1);
		Arrays.sort(array1);
		if(Arrays.toString(array1).equals("[1]")) 
		{
			System.out.println("Test 10 passed: " + Arrays.toString(array1) + " is [1]");
		} else {
			System.out.println("Test 10 failed: " + Arrays.toString(array1) + " is not [1]");
		}

		list1 = new ArrayList<String>(Arrays.asList("Eleven", null, "", "Twenty", "abc", "Twelve", null));
		array1 = Question3.longestLocations(list1);
		Arrays.sort(array1);
		if(Arrays.toString(array1).equals("[0, 3, 5]")) 
		{
			System.out.println("Test 11 passed: " + Arrays.toString(array1) + " is [0, 3, 5]");
		} else {
			System.out.println("Test 11 failed: " + Arrays.toString(array1) + " is not [0, 3, 5]");
		}
	}
}
