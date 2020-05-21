package assignment01;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PersonStudentTest
{
	public static void main(String[] args)
		throws FileNotFoundException
	{
		var out = new PrintStream(new File("test.txt"));

		var p0 = new Person("Griffin", "Peter", 2001, 4, 18);
		var p1 = new Person("Simpson", "Homer", 2009, 10, 21);
		var p2 = new Person("Madden", "Patrick", 1960, 1, 12);
		var p3 = new Person("Lander", "Les", 2002, 7, 15);
		var p4 = new Person("Guy", "Cool", 2001, 9, 16);

		Person p = Utilities.oldest(p0,p1,p2,p3,p4);

		out.println(p.getLastNames());
		out.println("EXPECTED VALUE: Madden");

		out.println(p.ageInYears());
		out.println("EXPECTED VALUE: 60");

		out.println(p.equals(p2));
		out.println("EXPECTED VALUE: true");

		var s0 = new Student(p0, "Psychology", 2.3);
		var s1 = new Student(p1, "Chemistry", 2.4);
		var s2 = new Student(p2, "Computer Science", 3.4);
		var s3 = new Student(p3, "Computer Science", 3.7);
		var s4 = new Student(p4, "Art", 2.8);
		
		Student s = Utilities.topGpa(s0,s1,s2,s3,s4);

		out.println(s.getAsPerson().getLastNames());
		out.println("EXPECTED VALUE: Lander");
		out.println(s.getGpa());
		out.println("EXPECTED VALUE: 3.7");
		out.println(s.equals(s3));
		out.println("EXPECTED VALUE: true");

		out.close();
	}
}
