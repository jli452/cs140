package lab01;

public class Driver
{
	public static void main(String[] args)
	{
		var p = new Person("Wilson", "Mary Joe", 2005, 3, 20);
		var s = new Student(p, "Computer Science", 3.5);

		System.out.println(p.exactAge());
		System.out.println(s.getAsPerson().getLastNames());
		System.out.println(s.getMajor());
		System.out.println(s.getGpa());

		s.setGpa(3.4);
		System.out.println(s.getGpa());
	}
}
