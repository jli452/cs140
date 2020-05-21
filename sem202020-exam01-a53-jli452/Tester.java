package exam01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tester {

	public static void main(String[] args) 
	{
		testMyString();
		testQuestion2();
		testQuestion3();
		testQuestion4();
	}

	public static void testMyString() 
	{
		
		System.out.println("----Testing MyString----");
		System.out.println("----Testing first constructor and toString----");
		MyString str = new MyString();
		System.out.println("Expecting no chars");
		System.out.println("Actual:   " + str);
		System.out.println("----Testing second constructor and toString----");
		str = new MyString("abcde");
		System.out.println("Expecting [a, b, c, d, e]");
		System.out.println("Actual:   " + str);
		str = new MyString(null);
		System.out.println("Expecting no chars");
		System.out.println("Actual:   " + str);
		str = new MyString("");
		System.out.println("Expecting []");
		System.out.println("Actual:   " + str);
		System.out.println("----Testing toUpperCase----");
		str = new MyString();
		System.out.println("Expecting no chars");
		System.out.println("Actual:   " + str.toUpperCase());
		str = new MyString("abcdecxey");
		System.out.println("Expecting [A, B, C, D, E, C, X, E, Y]");
		System.out.println("Actual:   " + str.toUpperCase());
		System.out.println("----Testing startsWith----");
		System.out.println("1 Expecting false");
		System.out.println("1 Actual:   " + str.startsWith(null));
		System.out.println("2 Expecting false");
		System.out.println("2 Actual:   " + str.startsWith(new MyString("abcdecxeyw")));
		System.out.println("3 Expecting true");
		System.out.println("3 Actual:   " + str.startsWith(new MyString("abcdecxey")));
		System.out.println("4 Expecting false");
		System.out.println("4 Actual:   " + str.startsWith(new MyString("abcdd")));
		System.out.println("5 Expecting true");
		System.out.println("5 Actual:   " + str.startsWith(new MyString("abcd")));
		System.out.println("6 Expecting true");
		System.out.println("6 Actual:   " + str.startsWith(new MyString("")));
		
	}
	public static void testQuestion2()
	{
		
		System.out.println("----Testing Question2----");
		List<MyString> list = new ArrayList<>(
				Arrays.asList(new MyString("abcdefgedf"), null, 
						new MyString("abcdefgeg"), new MyString("abcde"), 
						new MyString(), new MyString("abcde"), new MyString("abcde")));
		MyString[] starts = {new MyString("abcdex"), null, 
				new MyString("abcdefg"), new MyString("bcde"), 
				new MyString("cde")};
		System.out.println("Expecting [[a, b, c, d, e, f, g, e, d, f], [a, b, c, d, e, f, g, e, g]]");
		System.out.println("Actual:   " + Question2.possibleStarts(list, starts));
		
	}
	public static void testQuestion3()
	{
		
		System.out.println("----Testing Question3----");
		var test = new Question3();
		Student[] stds = new Student[26];
		double [] gpas = {3.55,	2.65, 1.67, 1.96, 3.74,
				3.89, 1.71, 2.85, 0.50, 1.90, 3.83, 2.65,
				3.25, 2.53, 1.95, 3.01, 0.90, 3.87, 2.21,
				1.49, 3.23, 1.99, 3.67, 2.93, 3.58, 3.41
		};
		for(int i = 0; i < 26; i++) 
		{
			String nm = "" + (char)('A' + i) + (char)('A' + i);
			stds[i] = new Student(nm, gpas[i]);
			test.addStudent(stds[i]);
		}
		System.out.println("Expecting [7.69, 26.92, 23.08, 42.31]");
		double[] raw = test.fractions();
		for(int i = 0; i < 4; i++) {
			raw[i] = Math.round(100*raw[i])/100.0;
		}
		String answer = Arrays.toString(raw);
		System.out.println("Actual:   " + answer);
		
	}
	
	public static void testQuestion4()
	{
		
		System.out.println("----Testing Question4----");
		int[] a = {20, 50, 30, 16, 70, 90, 55, 45, 91, 93, 1, 35, 20, 50, 30, 16, 70, 75, 40, 80, 85};
		char[] b = { 'H','H','H','H','L','L','L','H','L','L','H','H','H','H','H','H','L','L','H','L'};
		var test = new Question4(a,b);
		System.out.println("Expecting you win");
		System.out.println("Actual:   " + test.winner());
		b = new char[]{'L','H','H','H','L','L','L','H','L','L','H','H','H','H','H','H','L','L','H','L'};
		test = new Question4(a,b);
		System.out.println("Expecting tie");
		System.out.println("Actual:   " + test.winner());
		b = new char[]{'L','H','H','H','L','L','H','L','L','L','H','H','H','H','H','H','L','L','H','L'};
		test = new Question4(a,b);
		System.out.println("Expecting you lose");
		System.out.println("Actual:   " + test.winner());
		
	}
}
