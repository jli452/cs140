package assignment03;

public class RosterTester
{
	public static void main(String[] args)
	{
		Roster roster = new Roster();

		Person p0 = new Person("Griffin", "Peter", 2001, 4, 18);
		Person p1 = new Person("Simpson", "Homer", 2009, 10, 21);
		Person p2 = new Person("Madden", "Patrick", 1960, 1, 12);
		Person p3 = new Person("Lander", "Les", 2002, 7, 15);
		Person p4 = new Person("Guy", "Cool", 2001, 9, 16);

		Student s0 = new Student(p0, "Psychology", 2.3, "B00222222");
		Student s1 = new Student(p1, "Chemistry", 2.4, "B00333333");
		Student s2 = new Student(p2, "Computer Science", 3.4, "B00555555");
		Student s3 = new Student(p3, "Computer Science", 3.7, "B00444444");
		Student s4 = new Student(p4, "Art", 2.8, "B00111111");

		roster.addStudent(s0);
		roster.addStudent(s1);
		roster.addStudent(s2);
		roster.addStudent(s3);
		roster.addStudent(s4);

		System.out.println(roster.toString());

		roster.dropStudent("B00555555");
		System.out.println(roster.toString());

		roster.sortByBNum();
		System.out.println(roster);
		
		for (var st : roster.getClassRoster())
		{
			System.out.println("Name: " + st.getAsPerson().getFirstNames() + " " + st.getAsPerson().getLastNames());
			System.out.println("B Number: " + st.getBNumber());
		}
	}
}
