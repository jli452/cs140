package lab01;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.time.LocalDate;

public class Tester 
{
	private static PrintStream out = System.out;
	private static double numWrong = 0;
	private static int testNum = 0;
	public void min(String[] args) {}
	public static void main(String[] args) throws FileNotFoundException 
	{
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
	public static void testQ1() 
	{
		out.println("*********TESTING QUESTION 1*********");
		try
		{
			++testNum;
			Class.forName("lab01.Country");
			out.println("TEST " + testNum + " Class lab01.Country exists");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: class Country does not exist");
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Country");
			Country.class.getConstructor(String.class, Double.TYPE, Long.TYPE);
			out.println("TEST " + testNum + " Country constructor exists");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Country does not exist");
			out.println("or no constructor Country(String, double, long)");
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Country");
			Method m = Country.class.getMethod("getName");
			Class<?> c2 = m.getReturnType();
			testEquality("" + String.class, "" + c2, testNum + " getName return type:");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Country does not exist");
			out.println("or no method getName()");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Country");
			Constructor<Country> c = Country.class.getConstructor(String.class, Double.TYPE, Long.TYPE);
			Country c1 = c.newInstance("USA", 9525067.00, 329064917);
			Method m = Country.class.getMethod("getName");
			String actual = (String)m.invoke(c1);
			testEquality("USA", actual, testNum + " getName:");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Country does not exist");
			out.println("or no constructor Country(String, double, long)");
			out.println("or no method getName()");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Country");
			Method m = Country.class.getMethod("getArea");
			Class<?> c2 = m.getReturnType();
			testEquality("" + Double.TYPE, "" + c2, testNum + " getArea return type:");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Country does not exist");
			out.println("or no method getArea()");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Country");
			Constructor<Country> c = Country.class.getConstructor(String.class, Double.TYPE, Long.TYPE);
			Country c1 = c.newInstance("USA", 9525067.00, 329064917);
			Method m = Country.class.getMethod("getArea");
			String actual = "" + m.invoke(c1);
			testEquality("" + 9525067.00, actual, testNum + " getArea:");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Country does not exist");
			out.println("or no constructor Country(String, double, long)");
			out.println("or no method getArea()");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Country");
			Method m = Country.class.getMethod("getPopulation");
			Class<?> c2 = m.getReturnType();
			testEquality("" + Long.TYPE, "" + c2, testNum + " getPopulation return type:");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Country does not exist");
			out.println("or no method getPopulation()");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Country");
			Constructor<Country> c = Country.class.getConstructor(String.class, Double.TYPE, Long.TYPE);
			Country c1 = c.newInstance("USA", 9525067.00, 329064917);
			Method m = Country.class.getMethod("getPopulation");
			String actual = "" + m.invoke(c1);
			testEquality("" + 329064917, actual, testNum + " getPopulation");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Country does not exist");
			out.println("or no constructor Country(String, double, long)");
			out.println("or no method long getPopulation()");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Country");
			Method m = Country.class.getMethod("getAveragePopulationDensity");
			Class<?> c2 = m.getReturnType();
			testEquality("" + Double.TYPE, "" + c2, testNum + " getAveragePopulationDensity return type:");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Country does not exist");
			out.println("or no method getAveragePopulationDensity()");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Country");
			Constructor<Country> c = Country.class.getConstructor(String.class, Double.TYPE, Long.TYPE);
			Country c1 = c.newInstance("USA", 9525067.00, 329064917);
			Method m = Country.class.getMethod("getAveragePopulationDensity");
			String actual = "" + m.invoke(c1);
			testEquality("" + 329064917/9525067.00, actual, testNum + " getAveragePopulationDensity");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Country does not exist");
			out.println("or no constructor Country(String, double, long)");
			out.println("or no method long getPopulation()");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
	}
	public static void testQ2() 
	{
		out.println("*********TESTING QUESTION 2*********");
		try
		{
			++testNum;
			Class.forName("lab01.Person");
			out.println("TEST " + testNum + " Class lab01.Person exists");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: class Person does not exist");
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Person");
			Person.class.getConstructor(String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
			out.println("TEST " + testNum + " Person constructor exists");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Person does not exist");
			out.println("or no constructor Person(String, String, int, int, int)");
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Person");
			Method m = Person.class.getMethod("getLastNames");
			Class<?> c2 = m.getReturnType();
			testEquality("" + String.class, "" + c2, testNum + " getLastNames return type:");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Person does not exist");
			out.println("or no method getLastNames()");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Person");
			Constructor<Person> c = Person.class.getConstructor(String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
			Person c1 = c.newInstance("Wilson", "Mary Joe", 2005, 3, 20);
			Method m = Person.class.getMethod("getLastNames");
			String actual = (String)m.invoke(c1);
			testEquality("Wilson", actual, testNum + " getLastNames:");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Person does not exist");
			out.println("or no constructor Person(String, String, int, int, int)");
			out.println("or no method getLastNames()");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Person");
			Method m = Person.class.getMethod("getFirstNames");
			Class<?> c2 = m.getReturnType();
			testEquality("" + String.class, "" + c2, testNum + " getFirstNames return type:");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Person does not exist");
			out.println("or no method getFirstNames()");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Person");
			Constructor<Person> c = Person.class.getConstructor(String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
			Person c1 = c.newInstance("Wilson", "Mary Joe", 2005, 3, 20);
			Method m = Person.class.getMethod("getFirstNames");
			String actual = (String)m.invoke(c1);
			testEquality("Mary Joe", actual, testNum + " getFirstNames:");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Person does not exist");
			out.println("or no constructor Person(String, String, int, int, int)");
			out.println("or no method getFirstNames()");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Person");
			Method m = Person.class.getMethod("getDateOfBirth");
			Class<?> c2 = m.getReturnType();
			testEquality("" + LocalDate.class, "" + c2, testNum + " getDateOfBirth return type:");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Person does not exist");
			out.println("or no method getDateOfBirth()");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Person");
			Constructor<Person> c = Person.class.getConstructor(String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
			Person c1 = c.newInstance("Wilson", "Mary Joe", 2005, 3, 20);
			Method m = Person.class.getMethod("getDateOfBirth");
			LocalDate actual = (LocalDate)m.invoke(c1);
			testEquality("2005-03-20", actual, testNum + " getDateOfBirth:");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Person does not exist");
			out.println("or no constructor Person(String, String, int, int, int)");
			out.println("or no method getDateOfBirth()");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Person");
			Method m = Person.class.getMethod("ageInYears");
			Class<?> c2 = m.getReturnType();
			testEquality("" + Integer.TYPE, "" + c2, testNum + " ageInYears return type:");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Person does not exist");
			out.println("or no method ageInYears()");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Person");
			Constructor<Person> c = Person.class.getConstructor(String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
			Person c1 = c.newInstance("Wilson", "Mary Joe", 2005, 3, 20);
			Method m = Person.class.getMethod("ageInYears");
			int actual = (int)m.invoke(c1);
			testEquality("14", actual, testNum + " ageInYears:");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Person does not exist");
			out.println("or no constructor Person(String, String, int, int, int)");
			out.println("or no method ageInYears()");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
	}

	public static void testQ3() 
	{
		out.println("*********TESTING QUESTION 3*********");
		try
		{
			++testNum;
			Class.forName("lab01.Student");
			out.println("TEST " + testNum + " Class lab01.Student exists");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: class Student does not exist");
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Student");
			Student.class.getConstructor(Person.class, String.class, Double.TYPE);
			out.println("TEST " + testNum + " Student constructor exists");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Student does not exist");
			out.println("or no constructor Student(String, String, int, int, int)");
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Student");
			Method m = Student.class.getMethod("getAsPerson");
			Class<?> c2 = m.getReturnType();
			testEquality("" + Person.class, "" + c2, testNum + " getAsPerson return type:");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Student does not exist");
			out.println("or no method getAsPerson()");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Person");
			Class.forName("lab01.Student");
			Constructor<Person> pc = Person.class.getConstructor(String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
			Constructor<Student> sc = Student.class.getConstructor(Person.class, String.class, Double.TYPE);
			Person p = pc.newInstance("Wilson", "Mary Joe", 2005, 3, 20);
			Student s = sc.newInstance(p, "Computer Science", 3.5);
			Method m = Student.class.getMethod("getAsPerson");
			Person actual = (Person)m.invoke(s);
			testEquality("" + p, actual, testNum + " getAsPerson:");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Person does not exist");
			out.println("or Student does not exist");
			out.println("or no constructor Person(String, String, int, int, int)");
			out.println("or no constructor Student(Person, String, double)");
			out.println("or no method getAsPerson()");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Student");
			Method m = Student.class.getMethod("getMajor");
			Class<?> c2 = m.getReturnType();
			testEquality("" + String.class, "" + c2, testNum + " getMajor return type:");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Student does not exist");
			out.println("or no method getMajor()");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Person");
			Class.forName("lab01.Student");
			Constructor<Person> pc = Person.class.getConstructor(String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
			Constructor<Student> sc = Student.class.getConstructor(Person.class, String.class, Double.TYPE);
			Person p = pc.newInstance("Wilson", "Mary Joe", 2005, 3, 20);
			Student s = sc.newInstance(p, "Computer Science", 3.5);
			Method m = Student.class.getMethod("getMajor");
			String actual = (String)m.invoke(s);
			testEquality("Computer Science", actual, testNum + " getMajor:");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Person does not exist");
			out.println("or Student does not exist");
			out.println("or no constructor Person(String, String, int, int, int)");
			out.println("or no constructor Student(Person, String, double)");
			out.println("or no method getMajor()");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Student");
			Method m = Student.class.getMethod("getGpa");
			Class<?> c2 = m.getReturnType();
			testEquality("" + Double.TYPE, "" + c2, testNum + " getGpa return type:");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Student does not exist");
			out.println("or no method getGpa()");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Person");
			Class.forName("lab01.Student");
			Constructor<Person> pc = Person.class.getConstructor(String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
			Constructor<Student> sc = Student.class.getConstructor(Person.class, String.class, Double.TYPE);
			Person p = pc.newInstance("Wilson", "Mary Joe", 2005, 3, 20);
			Student s = sc.newInstance(p, "Computer Science", 3.5);
			Method m = Student.class.getMethod("getGpa");
			double actual = (double)m.invoke(s);
			testEquality("3.5", actual, testNum + " getGpa:");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Person does not exist");
			out.println("or Student does not exist");
			out.println("or no constructor Person(String, String, int, int, int)");
			out.println("or no constructor Student(Person, String, double)");
			out.println("or no method getGpa()");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Student");
			Method m = Student.class.getMethod("setGpa", Double.TYPE);
			Class<?> c2 = m.getReturnType();
			testEquality("" + Void.TYPE, "" + c2, testNum + " setGpa(double) return type:");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Student does not exist");
			out.println("or no method setGpa(double)");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Person");
			Class.forName("lab01.Student");
			Constructor<Person> pc = Person.class.getConstructor(String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
			Constructor<Student> sc = Student.class.getConstructor(Person.class, String.class, Double.TYPE);
			Person p = pc.newInstance("Wilson", "Mary Joe", 2005, 3, 20);
			Student s = sc.newInstance(p, "Computer Science", 3.5);
			Method m = Student.class.getMethod("setGpa", Double.TYPE);
			m.invoke(s, 3.0);
			Method m1 = Student.class.getMethod("getGpa");
			double actual = (double)m1.invoke(s);
			testEquality("3.0", actual, testNum + " getGpa() and setGpa(double):");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Person does not exist");
			out.println("or Student does not exist");
			out.println("or no constructor Person(String, String, int, int, int)");
			out.println("or no constructor Student(Person, String, double)");
			out.println("or no method getGpa()");			
			out.println("or no method setGpa(double)");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
	}
	
	public static void testQ4() 
	{
		out.println("*********TESTING QUESTION 4*********");
		try
		{
			++testNum;
			Class.forName("lab01.Driver");
			out.println("TEST " + testNum + " Class lab01.Driver exists");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: class Driver does not exist");
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try
		{
			++testNum;
			Class.forName("lab01.Driver");
			Method m = Driver.class.getMethod("main", String[].class);
			Class<?> c2 = m.getReturnType();
			testEquality("" + Void.TYPE, "" + c2, testNum + " main(String[]) return type:");
			testEquality("public static void lab01.Driver.main(java.lang.String[])", 
					m.toGenericString(), testNum + " main(String[]) generic name:");
		} 
		catch(Exception e)
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Either Driver does not exist");
			out.println("or no method main(String[])");			
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);
		}
		try 
		{
			++testNum;
			Class.forName("lab01.Driver");
			Method m = Driver.class.getMethod("main", String[].class);
			//https://stackoverflow.com/questions/8708342/redirect-console-output-to-string-in-java
			// Create a stream to hold the output
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(baos);
			// IMPORTANT: Save the old System.out!
			PrintStream old = System.out;
			// Tell Java to use your special stream
			System.setOut(ps);
			// Print some output: goes to your special stream
			String[] args = {};
			m.invoke(null, new Object[]{args});
			// Put things back
			System.out.flush();
			System.setOut(old);
			// Compare what happened with the expectation
			String actual = baos.toString();
			String expected = "14 years, 10 months, 3 days"
					+ "Wilson "
					+ "Computer Science"
					+ "3.5"
					+ "3.4";
			testEquality(expected.replaceAll("\\s",""), 
					actual.replaceAll("\\s",""), testNum + " main(String[]) execution:");
		} 
		catch (Exception e) 
		{
			++numWrong;
			out.println("TEST " + testNum + " FAILED: Driver.main())");
//			out.println("ERROR MESSAGE SHOWN BELOW");
//			e.printStackTrace(out);			
		}
	}
	
	private static void testEquality(Object expected, Object actual, String testNum) 
	{
		if (!expected.toString().equals(actual.toString())) 
		{
			++numWrong;
			out.printf("TEST " + testNum + " FAILED: Expected '%s', received '%s'\n",
					expected.toString(),
					actual.toString());
		} 
		else 
		{
			out.printf("TEST " + testNum + " Passed: '%s' == '%s'\n",
					expected.toString(),
					actual.toString());
		}
	}
}
