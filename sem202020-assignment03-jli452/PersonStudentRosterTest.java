package assignment03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class PersonStudentRosterTest 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		Roster roster = new Roster();
		try (Scanner lines = new Scanner(new File("students.txt"))) { 
			// Read the lines
			while(lines.hasNextLine())
			{
				String line = lines.nextLine();
				if(line.trim().length() > 0)
				{
					String[] parts = line.split(",");
					Person p = new Person(parts[0].trim(), parts[1].trim(), 
							Integer.parseInt(parts[2].trim()), // year 
							Integer.parseInt(parts[3].trim()), // month
							Integer.parseInt(parts[4].trim())); // day
					Student s = new Student(p, parts[5], Double.parseDouble(parts[6]), parts[7].trim());
					roster.addStudent(s);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		try (PrintStream out = new PrintStream("output.txt")) 
		{
			System.out.print(roster);
			out.println(roster);
			System.out.println("\n----------------");
			roster.sortByBNum();
			System.out.print(roster);
			out.println(roster);
		}
	}
}
