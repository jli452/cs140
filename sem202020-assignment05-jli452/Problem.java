package assignment05;
//package exam01;

import java.util.ArrayList;
import java.util.List;

public class Problem {
	
	public static String findDigits (String userId) {
		// if userId is null, return null, if userId is "", return userId
		
		// Find the index i where the first digit appears in the userId
		// If c is a char, then Character.isDigit(c) is true if c is a digit, otherwise false
		
		// You can use either of 2 ways to go through the String:
		// 1. use char[] cs = userId.toCharArray(); which turns userId into its array of chars
		// or 2. loop through userId looking at each userId.charAt(i), which is the char
		// at index i. The length of userId is userId.length(), which is the same as cs.length
		// 
		// If you do not find any digits in userId, return "0"
		// otherwise return userId.substring(i)
		// For example findDigits("lander") is "0" but findDigits("smith71") is "71"
		if (userId == null)
			return null;
		if (userId.equals(""))
			return userId;
		String retStr = "";
		int counter = 0;
		char[] cs = userId.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (Character.isDigit(cs[i])) {
				counter++;
				retStr += cs[i];
			}
		}
		if (counter == 0)
			return "0";
			
		return retStr; // replace with a correct string
	}

	public static List<Integer> intParts (List<String> userIds) {
		// return an ArrayList of the numeric parts of the userIds, for example
		// var test = List.of("xxx12", "a123", "bbb1", null, "ccc", "", "fasdfa7", "adfa23");
		// System.out.println(intParts(test)); prints
		// [12, 123, 1, 0, 7, 23]

		// If userIds is null, return null, if (userIds.isEempty()) return List.of()
		
		// The previous question has the code to find substring of digits in the userId	
		// If a String uId in the list userIds is null or is empty SKIP OVER it
		// Otherwise add Integer.parseInt(findDigits(uId)) to the output list.

		if (userIds == null)
			return null;
		if (userIds.isEmpty())
			return List.of();
		List<Integer> retList = new ArrayList<>();
		for (int i = 0; i < userIds.size(); i++)
		{
			if (userIds.get(i) == null || userIds.get(i).equals(""))
				continue;
			retList.add(Integer.parseInt(findDigits(userIds.get(i))));
		}
		
		return retList; // change to the correct value if strings is not empty
	}
	
	public static BankAccount[] largestAndSmallest(List<BankAccount> list) {
		if(list == null || list.isEmpty()) throw new IllegalArgumentException("Bad list");
		// The "size" of the BankAccount object will be the value of getBalanceInCents(). This is a 
		// long in order to have an exact balance with no inaccuracies that are possible with double. 
		
		// Find the minimum and maximum values of getBalanceInCents() for all the BankAccount
		// objects in list, if you find any objects that are null, throw new IllegalArgumentException
		// with the message "Bad list"
		
		// Return an array of all the BankAccounts in list that have getBalanceInCents() either equal to
		// the minimum value equal to the maximum value.
		
		// It is acceptable to make an ArrayList of all the bankAccounts that have getBalanceInCents() 
		// equal to either the minimum or the maximum areas and then copy those over 
		// to the return array that will have length equal to the size() of the ArrayList.
		List<BankAccount> bAcc = new ArrayList<>();
		long max = 0;
		long min = Long.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == null)
				throw new IllegalArgumentException("Bad list");
			if (list.get(i).getBalanceInCents() > max)
				max = list.get(i).getBalanceInCents();
			if (list.get(i).getBalanceInCents() < min)
				min = list.get(i).getBalanceInCents();
		}

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getBalanceInCents() == max || list.get(i).getBalanceInCents() == min)
				bAcc.add(list.get(i));
		}

		BankAccount[] retArr = new BankAccount[bAcc.size()];
		for (int i = 0; i < bAcc.size(); i++)
			retArr[i] = bAcc.get(i);

		return retArr; // change to the correct array if list is not empty
	}
}
