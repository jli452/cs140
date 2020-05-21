package assignment01;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.Period;

public class TesterA01 {
	private static PrintStream out = System.out;
	private static double numWrong = 0;
	private static int testNum = 0;
	public void min(String[] args) {}
	public static void main(String[] args) throws FileNotFoundException {
		// can change output here
		//out = new PrintStream(new FileOutputStream(new File("reportLab01.txt"), true));
		testQ1();
		out.println("--------------------");
		testQ2();
		out.println("--------------------");
		testQ3();
		out.println("--------------------");
		testQ4();
		out.println("--------------------");
		out.printf("Num Wrong=%.1f, Total Tests=%d, Testing grade=%.2f\n", 
				numWrong, testNum, 10.0*(1 - numWrong/testNum));
	}
	public static void testQ1() {
		out.println("*********TESTING QUESTION 1*********");
		try{
			++testNum;
			Class.forName("assignment01.Person");
			out.println("TEST " + testNum + " Class assignment01.Person exists");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: class Person does not exist");
			//			out.println("ERROR MESSAGE SHOWN BELOW");
			//			e.printStackTrace(out);
		}
		try{
			++testNum;
			Class<?> pClass = Class.forName("assignment01.Person");
			pClass.getConstructor(String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
			out.println("TEST " + testNum + " Person constructor exists");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Person does not exist");
			out.println("or no constructor Person(String, String, int, int, int)");
			//			out.println("ERROR MESSAGE SHOWN BELOW");
			//			e.printStackTrace(out);
		}
		try{
			++testNum;
			Class<?> pClass = Class.forName("assignment01.Person");
			Method m = pClass.getMethod("compareAgesTo", Person.class);
			Class<?> c2 = m.getReturnType();
			testEquality("" + Integer.TYPE, "" + c2, testNum + " compareAgesTo return type:");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Person does not exist");
			out.println("or no constructor Person(String, String, int, int, int)");
			out.println("or no method compareAgesTo");			
			//			out.println("ERROR MESSAGE SHOWN BELOW");
			//			e.printStackTrace(out);
		}
		try{
			++testNum;
			Class<?> pClass = Class.forName("assignment01.Person");
			Constructor<?> pc = pClass.getConstructor(String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
			Object p = pc.newInstance("Wilson", "Mary Joe", 2005, 3, 20);
			Object p1 = pc.newInstance("Watson", "John", 2005, 1, 15);
			Method m = pClass.getMethod("compareAgesTo", Person.class);
			int actual = (int)m.invoke(p, p1);
			testPositiveInt(actual, testNum + " compareAges value:");

		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Person does not exist");
			out.println("or no constructor Person(String, String, int, int, int)");
			out.println("or no method compareAgesTo");			
			//			out.println("ERROR MESSAGE SHOWN BELOW");
			//			e.printStackTrace(out);
		}
		try{
			++testNum;
			Class<?> pClass = Class.forName("assignment01.Person");
			Constructor<?> pc = pClass.getConstructor(String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
			Object p = pc.newInstance("Wilson", "Mary Joe", 2005, 3, 20);
			Object p1 = pc.newInstance("Watson", "John", 2000, 5, 15);
			Method m = pClass.getMethod("compareAgesTo", Person.class);
			int actual = (int)m.invoke(p1, p);
			testNegativeInt(actual, testNum + " compareAges value:");

		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Person does not exist");
			out.println("or no constructor Person(String, String, int, int, int)");
			out.println("or no method compareAgesTo");			
			//			out.println("ERROR MESSAGE SHOWN BELOW");
			//			e.printStackTrace(out);
		}
		try{
			++testNum;
			Class<?> pClass = Class.forName("assignment01.Person");
			Constructor<?> pc = pClass.getConstructor(String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
			Object p = pc.newInstance("Wilson", "Mary Joe", 2005, 3, 20);
			Object p1 = pc.newInstance("Watson", "John", 2005, 3, 20);
			Method m = pClass.getMethod("compareAgesTo", Person.class);
			int actual = (int)m.invoke(p1, p);
			testEquality("0", "" + actual, testNum + " compareAgesTo value:");			
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Person does not exist");
			out.println("or no method compareAgesTo");			
			//			out.println("ERROR MESSAGE SHOWN BELOW");
			//			e.printStackTrace(out);
		}
	}

	public static void testQ2() {
		out.println("*********TESTING QUESTION 2*********");
		try{
			++testNum;
			Class.forName("assignment01.Student");
			out.println("TEST " + testNum + " Class assignment01.Student exists");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: class Student does not exist");
			//			out.println("ERROR MESSAGE SHOWN BELOW");
			//			e.printStackTrace(out);
		}
		try{
			++testNum;
			Class<?> pClass = Class.forName("assignment01.Person");
			Class<?> sClass = Class.forName("assignment01.Student");
			sClass.getConstructor(pClass, String.class, Double.TYPE);
			out.println("TEST " + testNum + " Student constructor exists");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Student does not exist");
			out.println("or Person does not exist");
			out.println("or no constructor Student(String, String, int, int, int)");
			//			out.println("ERROR MESSAGE SHOWN BELOW");
			//			e.printStackTrace(out);
		}
		try{
			++testNum;
			Class<?> sClass = Class.forName("assignment01.Student");
			Method m = sClass.getMethod("compareByGpaTo", Student.class);
			Class<?> c2 = m.getReturnType();
			testEquality("" + Integer.TYPE, "" + c2, testNum + " compareByGpaTo return type:");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Student does not exist");
			out.println("or no constructor Student(String, String, int, int, int)");
			out.println("or no method compareByGpaTo");			
			//			out.println("ERROR MESSAGE SHOWN BELOW");
			//			e.printStackTrace(out);
		}
		try{
			++testNum;
			Class<?> pClass = Class.forName("assignment01.Person");
			Class<?> sClass = Class.forName("assignment01.Student");
			Constructor<?> pc = pClass.getConstructor(String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
			Constructor<?> sc = sClass.getConstructor(pClass, String.class, Double.TYPE);
			Object p = pc.newInstance("Wilson", "Mary Joe", 2005, 3, 20);
			Object p1 = pc.newInstance("Watson", "John", 2005, 3, 20);
			Object s = sc.newInstance(p, "Computer Science", 3.5);
			Object s1 = sc.newInstance(p1, "Computer Science", 3.7);
			Method m = sClass.getMethod("compareByGpaTo", Student.class);
			int actual = (int)m.invoke(s, s1);
			testNegativeInt(actual, testNum + " compareByGpaTo value:");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Student does not exist");
			out.println("or Person does not exist");
			out.println("or no constructor Person(String, String, int, int, int)");
			out.println("or no constructor Student(String, String, int, int, int)");
			out.println("or no method compareByGpaTo");			
			//			out.println("ERROR MESSAGE SHOWN BELOW");
			//			e.printStackTrace(out);
		}
		try{
			++testNum;
			Class<?> pClass = Class.forName("assignment01.Person");
			Class<?> sClass = Class.forName("assignment01.Student");
			Constructor<?> pc = pClass.getConstructor(String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
			Constructor<?> sc = sClass.getConstructor(pClass, String.class, Double.TYPE);
			Object p = pc.newInstance("Wilson", "Mary Joe", 2005, 3, 20);
			Object p1 = pc.newInstance("Watson", "John", 2005, 3, 20);
			Object s = sc.newInstance(p, "Computer Science", 3.5);
			Object s1 = sc.newInstance(p1, "Computer Science", 3.7);
			Method m = sClass.getMethod("compareByGpaTo", Student.class);
			int actual = (int)m.invoke(s1, s);
			testPositiveInt(actual, testNum + " compareByGpaTo value:");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Student does not exist");
			out.println("or Person does not exist");
			out.println("or no constructor Person(String, String, int, int, int)");
			out.println("or no constructor Student(String, String, int, int, int)");
			out.println("or no method compareByGpaTo");			
			//			out.println("ERROR MESSAGE SHOWN BELOW");
			//			e.printStackTrace(out);
		}
		try{
			++testNum;
			Class<?> pClass = Class.forName("assignment01.Person");
			Class<?> sClass = Class.forName("assignment01.Student");
			Constructor<?> pc = pClass.getConstructor(String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
			Constructor<?> sc = sClass.getConstructor(pClass, String.class, Double.TYPE);
			Object p = pc.newInstance("Wilson", "Mary Joe", 2005, 3, 20);
			Object p1 = pc.newInstance("Watson", "John", 2005, 3, 20);
			Object s = sc.newInstance(p, "Computer Science", 3.5);
			Object s1 = sc.newInstance(p1, "Computer Science", 3.5);
			Method m = sClass.getMethod("compareByGpaTo", Student.class);
			int actual = (int)m.invoke(s1, s);
			testEquality("0", "" + actual, testNum + " compareAgesTo value:");			
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Student does not exist");
			out.println("or Person does not exist");
			out.println("or no constructor Person(String, String, int, int, int)");
			out.println("or no constructor Student(String, String, int, int, int)");
			out.println("or no method compareByGpaTo");			
			//				out.println("ERROR MESSAGE SHOWN BELOW");
			//				e.printStackTrace(out);
		}
	}

	public static void testQ3() {
		out.println("*********TESTING QUESTION 3*********");
		try{
			++testNum;
			Class.forName("assignment01.Utilities");
			out.println("TEST " + testNum + " Class assignment01.Utilities exists");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: class Utilities does not exist");
			//			out.println("ERROR MESSAGE SHOWN BELOW");
			//			e.printStackTrace(out);
		}
		try {
			++testNum;
			Class.forName("assignment01.Person");
			Class<?> uClass = Class.forName("assignment01.Utilities");
			Method m = uClass.getMethod("oldest", Person.class, Person.class, Person.class, Person.class, Person.class);
			Class<?> c2 = m.getReturnType();
			testEquality("" + Person.class, "" + c2, testNum + " oldest return type:");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: class Utilities does not exist");
			out.println("or Person does not exist");
			out.println("or no method oldest");			
			//			out.println("ERROR MESSAGE SHOWN BELOW");
			//			e.printStackTrace(out);
		}
		try {
			++testNum;
			Class<?> pClass = Class.forName("assignment01.Person");
			Class<?> uClass = Class.forName("assignment01.Utilities");
			Method m = uClass.getMethod("oldest", Person.class, Person.class, Person.class, Person.class, Person.class);
 			Constructor<?> pc = pClass.getConstructor(String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
			var p0 = pc.newInstance("Wilson", "Mary Joe", 2005, 3, 12);
			var p1 = pc.newInstance("Willams", "Mary Joe", 2005, 3, 11);
			var p2 = pc.newInstance("Walker", "Mary Joe", 2000, 3, 10);
			var p3 = pc.newInstance("Walsh", "Mary Joe", 2005, 3, 10);
			var p4 = pc.newInstance("Walters", "Mary Joe", 2005, 3, 12);
			Object p = m.invoke(uClass,p0,p1,p2,p3,p4);
			testEquality("" + p, "" + p2, testNum + " oldest(p0,p1,p2,p3,p4,p5):");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: class Utilities does not exist");
			out.println("or Person does not exist");
			out.println("or no method oldest");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try {
			++testNum;
			Class<?> pClass = Class.forName("assignment01.Person");
			Class<?> uClass = Class.forName("assignment01.Utilities");
			Method m = uClass.getMethod("oldest", Person.class, Person.class, Person.class, Person.class, Person.class);
 			Constructor<?> pc = pClass.getConstructor(String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
			var p0 = pc.newInstance("Wilson", "Mary Joe", 1999, 3, 9);
			var p1 = pc.newInstance("Willams", "Mary Joe", 2005, 3, 11);
			var p2 = pc.newInstance("Walker", "Mary Joe", 2000, 3, 10);
			var p3 = pc.newInstance("Walsh", "Mary Joe", 2005, 3, 10);
			var p4 = pc.newInstance("Walters", "Mary Joe", 2005, 3, 12);
			Object p = m.invoke(uClass,p0,p1,p2,p3,p4);
			testEquality("" + p, "" + p0, testNum + " oldest(p0,p1,p2,p3,p4,p5):");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: class Utilities does not exist");
			out.println("or Person does not exist");
			out.println("or no method oldest");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try {
			++testNum;
			Class.forName("assignment01.Person");
			Class.forName("assignment01.Student");
			Class<?> uClass = Class.forName("assignment01.Utilities");
			Method m = uClass.getMethod("topGpa", Student.class, Student.class, Student.class, Student.class, Student.class);
			Class<?> c2 = m.getReturnType();
			testEquality("" + Student.class, "" + c2, testNum + " topGpa return type:");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: class Utilities does not exist");
			out.println("or Person does not exist");
			out.println("or no method topGpa");			
			//			out.println("ERROR MESSAGE SHOWN BELOW");
			//			e.printStackTrace(out);
		}
		try {
			++testNum;
			Class<?> pClass = Class.forName("assignment01.Person");
			Class<?> sClass = Class.forName("assignment01.Student");
			Class<?> uClass = Class.forName("assignment01.Utilities");
			Method m = uClass.getMethod("topGpa", Student.class, Student.class, Student.class, Student.class, Student.class);
 			Constructor<?> pc = pClass.getConstructor(String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
			Constructor<?> sc = sClass.getConstructor(pClass, String.class, Double.TYPE);
			var p0 = pc.newInstance("Wilson", "Mary Joe", 2005, 3, 12);
			var p1 = pc.newInstance("Willams", "Mary Joe", 2005, 3, 11);
			var p2 = pc.newInstance("Walker", "Mary Joe", 2000, 3, 10);
			var p3 = pc.newInstance("Walsh", "Mary Joe", 2005, 3, 10);
			var p4 = pc.newInstance("Walters", "Mary Joe", 2005, 3, 12);
			var s0 = sc.newInstance(p0, "Binghamton University", 2.5);
			var s1 = sc.newInstance(p1, "Binghamton University", 3);
			var s2 = sc.newInstance(p2, "Binghamton University", 2);
			var s3 = sc.newInstance(p3, "Binghamton University", 3);
			var s4 = sc.newInstance(p4, "Binghamton University", 3);
			Object s = m.invoke(uClass,s0,s1,s2,s3,s4);
			testEquality("" + s, "" + s1, testNum + " topGpa(s0,s1,s2,s3,s4):");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: class Utilities does not exist");
			out.println("or Person does not exist");
			out.println("or no method topGpa");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try {
			++testNum;
			Class<?> pClass = Class.forName("assignment01.Person");
			Class<?> sClass = Class.forName("assignment01.Student");
			Class<?> uClass = Class.forName("assignment01.Utilities");
			Method m = uClass.getMethod("topGpa", Student.class, Student.class, Student.class, Student.class, Student.class);
 			Constructor<?> pc = pClass.getConstructor(String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
			Constructor<?> sc = sClass.getConstructor(pClass, String.class, Double.TYPE);
			var p0 = pc.newInstance("Wilson", "Mary Joe", 2005, 3, 12);
			var p1 = pc.newInstance("Willams", "Mary Joe", 2005, 3, 11);
			var p2 = pc.newInstance("Walker", "Mary Joe", 2000, 3, 10);
			var p3 = pc.newInstance("Walsh", "Mary Joe", 2005, 3, 10);
			var p4 = pc.newInstance("Walters", "Mary Joe", 2005, 3, 12);
			var s0 = sc.newInstance(p0, "Binghamton University", 2.5);
			var s1 = sc.newInstance(p1, "Binghamton University", 2);
			var s2 = sc.newInstance(p2, "Binghamton University", 2);
			var s3 = sc.newInstance(p3, "Binghamton University", 2.5);
			var s4 = sc.newInstance(p4, "Binghamton University", 3);
			Object s = m.invoke(uClass,s0,s1,s2,s3,s4);
			testEquality("" + s, "" + s4, testNum + " topGpa(s0,s1,s2,s3,s4):");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: class Utilities does not exist");
			out.println("or Person does not exist");
			out.println("or no method topGpa");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
	}

	public static void testQ4() {
		out.println("*********TESTING QUESTION 4*********");
		try{
			++testNum;
			Class.forName("assignment01.FixedIntUnsubLoan");
			out.println("TEST " + testNum + " Class assignment01.Loan exists");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: class FixedIntUnsubLoan does not exist");
			//			out.println("ERROR MESSAGE SHOWN BELOW");
			//			e.printStackTrace(out);
		}
		try {
			++testNum;
			Class<?> lClass = Class.forName("assignment01.FixedIntUnsubLoan");
			lClass.getConstructor(Double.TYPE, Double.TYPE, Integer.TYPE, Double.TYPE);
			out.println("TEST " + testNum + " FixedIntUnsubLoan constructor exists");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: class FixedIntUnsubLoan does not exist");
			out.println("or constructor does not exist");
			//			out.println("ERROR MESSAGE SHOWN BELOW");
			//			e.printStackTrace(out);
		}
		try {
			++testNum;
			Class<?> lClass = Class.forName("assignment01.FixedIntUnsubLoan");
			Method m = lClass.getMethod("getBalanceAfter", Integer.TYPE);
			Class<?> c2 = m.getReturnType();
			testEquality("" + Double.TYPE, "" + c2, testNum + " getBalanceAfter return type:");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: class FixedIntUnsubLoan does not exist");
			out.println("or method getBalanceAfter does not exist");
			//			out.println("ERROR MESSAGE SHOWN BELOW");
			//			e.printStackTrace(out);
		}
		try {
			++testNum;
			Class<?> lClass = Class.forName("assignment01.FixedIntUnsubLoan");
 			Constructor<?> lc = lClass.getConstructor(Double.TYPE, Double.TYPE, Integer.TYPE, Double.TYPE);
			Object loan = lc.newInstance(15000.0, 4.75, 4, 189.36);
			Method m = lClass.getMethod("getBalanceAfter", Integer.TYPE);
			double c2 = (double)m.invoke(loan, 17);
			c2 = Math.round(c2*100)/100.0;
			testEquality("16041.98", "" + c2, testNum + " loan.getBalanceAfter(17):");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: class FixedIntUnsubLoan does not exist");
			out.println("or method getBalanceAfter does not exist");
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try {
			++testNum;
			Class<?> lClass = Class.forName("assignment01.FixedIntUnsubLoan");
 			Constructor<?> lc = lClass.getConstructor(Double.TYPE, Double.TYPE, Integer.TYPE, Double.TYPE);
			Object loan = lc.newInstance(15000.0, 4.75, 4, 189.36);
			Method m = lClass.getMethod("getBalanceAfter", Integer.TYPE);
			double c2 = (double)m.invoke(loan, 64);
			c2 = Math.round(c2*100)/100.0;
			testEquality("16181.28", "" + c2, testNum + " loan.getBalanceAfter(64):");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: class FixedIntUnsubLoan does not exist");
			out.println("or method getBalanceAfter does not exist");
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try {
			++testNum;
			Class<?> lClass = Class.forName("assignment01.FixedIntUnsubLoan");
			Method m = lClass.getMethod("monthsToPayLoan");
			Class<?> c2 = m.getReturnType();
			testEquality("" + Integer.TYPE, "" + c2, testNum + " monthsToPayLoan return type:");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: class FixedIntUnsubLoan does not exist");
			out.println("or method monthsToPayLoan does not exist");
			//			out.println("ERROR MESSAGE SHOWN BELOW");
			//			e.printStackTrace(out);
		}
		try {
			++testNum;
			Class<?> lClass = Class.forName("assignment01.FixedIntUnsubLoan");
 			Constructor<?> lc = lClass.getConstructor(Double.TYPE, Double.TYPE, Integer.TYPE, Double.TYPE);
			Object loan = lc.newInstance(15000.0, 4.75, 4, 189.36);
			Method m = lClass.getMethod("monthsToPayLoan");
			int c2 = (int)m.invoke(loan);
			testEquality("168", "" + c2, testNum + " loan.monthsToPayLoan(17):");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: class FixedIntUnsubLoan does not exist");
			out.println("or method monthsToPayLoan does not exist");
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try {
			++testNum;
			Class<?> lClass = Class.forName("assignment01.FixedIntUnsubLoan");
			Method m = lClass.getMethod("repayAmountCalculator", Double.TYPE, Double.TYPE, Integer.TYPE, Integer.TYPE);
			Class<?> c2 = m.getReturnType();
			testEquality("" + Double.TYPE, "" + c2, testNum + " repayAmountCalculator return type:");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: class FixedIntUnsubLoan does not exist");
			out.println("or method repayAmountCalculator does not exist");
			//			out.println("ERROR MESSAGE SHOWN BELOW");
			//			e.printStackTrace(out);
		}
		try {
			++testNum;
			Class<?> lClass = Class.forName("assignment01.FixedIntUnsubLoan");
			Method m = lClass.getMethod("repayAmountCalculator", Double.TYPE, Double.TYPE, Integer.TYPE, Integer.TYPE);
			double c2 = (double)m.invoke(lClass, 15000, 4.75, 4, 10);
			c2 = Math.round(c2*100)/100.0;
			testEquality("189.36", "" + c2, testNum + " loan.repayAmountCalculator(15000, 4.75, 4, 10):");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: class FixedIntUnsubLoan does not exist");
			out.println("or method repayAmountCalculator does not exist");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
	}	
	
	private static void testEquality(Object expected, Object actual, String testNum) {
		if (!expected.toString().equals(actual.toString())) {
			++numWrong;
			out.printf("TEST " + testNum + " FAILED: Expected '%s', received '%s'\n",
					expected.toString(),
					actual.toString());
		} else {
			out.printf("TEST " + testNum + " Passed: '%s' == '%s'\n",
					expected.toString(),
					actual.toString());
		}
	}
	private static void testPositiveInt(int actual, String testNum) {
		if (actual <= 0) {
			++numWrong;
			out.printf("TEST " + testNum + " FAILED: Value '%d' is not positive\n", actual);
		} else {
			out.printf("TEST " + testNum + " Passed: '%d' is positive\n", actual);
		}
	}
	private static void testNegativeInt(int actual, String testNum) {
		if (actual >= 0) {
			++numWrong;
			out.printf("TEST " + testNum + " FAILED: Value '%d' is not negative\n", actual);
		} else {
			out.printf("TEST " + testNum + " Passed: '%d' is negative\n", actual);
		}
	}

}
