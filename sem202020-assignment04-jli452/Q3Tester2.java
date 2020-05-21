package assignment04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q3Tester2 {
	public static void main(String[] args) 
	{
		List<String> list1 = null;
		List<String> test1 = Question3.mostCs(list1, 'e');
		if(test1 == null) 
		{
			System.out.println("Test 12 passed: " + test1 + " is null");
		} else {
			System.out.println("Test 12 failed: " + test1 + " is not null");
		}

		list1 = new ArrayList<>();
		test1 = Question3.mostCs(list1, 'e');
		if(test1.isEmpty()) 
		{
			System.out.println("Test 13 passed: " + test1 + " is empty");
		} else {
			System.out.println("Test 13 failed: " + test1 + " is not empty");
		}

		list1 = new ArrayList<String>(Arrays.asList("Eleven", "Six", "Twenty", "Twelve", "", null));
		test1 = Question3.mostCs(list1, 'e');
		Collections.sort(test1);
		if(test1.toString().equals("[Eleven]")) 
		{
			System.out.println("Test 14 passed: " + test1 + " contains \"Eleven\"");
		} else {
			System.out.println("Test 14 failed: " + test1 + " does not contain \"Eleven\"");
		}
		
		list1 = null;
		String[] array = Question3.fewestCs(list1, 'e');
		if(array == null) 
		{
			System.out.println("Test 15 passed: " + array + " is null");
		} else {
			System.out.println("Test 15 failed: " + array + " is not null");
		}

		list1 = new ArrayList<>();
		array = Question3.fewestCs(list1, 'e');
		if(array.length == 0) 
		{
			System.out.println("Test 16 passed: " + Arrays.toString(array) + " is empty");
		} else {
			System.out.println("Test 16 failed: " + Arrays.toString(array) + " is not empty");
		}

		list1 = new ArrayList<String>(Arrays.asList("Eleven", "Eighteen", "", "Twenty", "Twelve", "", null));
		array = Question3.fewestCs(list1, 'e');
		Arrays.sort(array);
		if(Arrays.toString(array).equals("[, ]")) 
		{
			System.out.println("Test 17 passed: " + Arrays.toString(array) + " contains two \"\"");
		} else {
			System.out.println("Test 17 failed: " + Arrays.toString(array) + " does not contain two \"\"");
		}

		list1 = new ArrayList<String>(Arrays.asList("Eleven", "Eighteen", "Twenty", "Two Hundred", "Twelve", null));
		array = Question3.fewestCs(list1, 'e');
		Arrays.sort(array);
		if(Arrays.toString(array).equals("[Twenty, Two Hundred]")) 
		{
			System.out.println("Test 18 passed: " + Arrays.toString(array) + " contains \"Twelve\", \"Two Hundred\"");
		} else {
			System.out.println("Test 18 failed: " + Arrays.toString(array) + " does not contain \"Twelve\", \"Two Hundred\"");
		}

		list1 = new ArrayList<String>(Arrays.asList("Eleven", "Eighteen", "Twenty", "Two Hundred", "Twenty", null));
		array = Question3.fewestCs(list1, 'e');
		Arrays.sort(array);
		if(Arrays.toString(array).equals("[Twenty, Twenty, Two Hundred]")) 
		{
			System.out.println("Test 19 passed: " + Arrays.toString(array) + " contains \"Twelve\", \"Twelve\", \"Two Hundred\"");
		} else {
			System.out.println("Test 19 failed: " + Arrays.toString(array) + " does not contain \"Twelve\", \"Twelve\", \"Two Hundred\"");
		}

		list1 = null;
		int[] array1 = Question3.mostCsLocations(list1, 'e');
		if(array1 == null) 
		{
			System.out.println("Test 20 passed: " + array1 + " is null");
		} else {
			System.out.println("Test 20 failed: " + array1 + " is not null");
		}

		list1 = new ArrayList<>();
		array1 = Question3.mostCsLocations(list1, 'e');
		if(array1.length == 0) 
		{
			System.out.println("Test 21 passed: " + Arrays.toString(array1) + " is empty");
		} else {
			System.out.println("Test 21 failed: " + Arrays.toString(array1) + " is not empty");
		}

		list1 = new ArrayList<String>(Arrays.asList("Six", "Eleven", "Eighteen", "Twenty", "Eighteen", "", null));
		array1 = Question3.mostCsLocations(list1, 'e');
		Arrays.sort(array1);
		if(Arrays.toString(array1).equals("[1, 2, 4]")) 
		{
			System.out.println("Test 22 passed: " + Arrays.toString(array1) + " is [1, 2, 4]");
		} else {
			System.out.println("Test 22 failed: " + Arrays.toString(array1) + " is not [1, 2, 4]");
		}

		list1 = new ArrayList<String>(Arrays.asList("Eleven", null, "", "Eleven", "abc", "Eleven", null));
		array1 = Question3.mostCsLocations(list1, 'e');
		Arrays.sort(array1);
		if(Arrays.toString(array1).equals("[0, 3, 5]")) 
		{
			System.out.println("Test 23 passed: " + Arrays.toString(array1) + " is [0, 3, 5]");
		} else {
			System.out.println("Test 23 failed: " + Arrays.toString(array1) + " is not [0, 3, 5]");
		}
	}
}
