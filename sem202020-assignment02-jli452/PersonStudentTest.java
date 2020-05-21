package assignment02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PersonStudentTest 
{
	public static void sortByGpa(Student[] students)
	{
		for (int i = 0; i < students.length; i++)
		{
			int minIndex = i;
			for (int j = i+1; j < students.length; j++)
			{
				if (students[j].getGpa() < students[minIndex].getGpa())
					minIndex = j;
			}
			if (i != minIndex)
			{
				var temp = students[minIndex];
				students[minIndex] = students[i];
				students[i] = temp;
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException 
	{
		Student[] students = {};
		try (Scanner lines = new Scanner(new File("students.txt"))) { 
			// Read the lines
			String line = lines.nextLine();
			Scanner firstLine = new Scanner(line);
			int numLines = firstLine.nextInt();
			firstLine.close();
			students = new Student[numLines];
			for(int i = 0; i < numLines; i++) {
				String[] parts = lines.nextLine().split(",");
				Person p = new Person(parts[0], parts[1], 
						Integer.parseInt(parts[2].trim()), // year 
						Integer.parseInt(parts[3].trim()), // month
						Integer.parseInt(parts[4].trim())); // day
				students[i] = new Student(p, parts[5], Double.parseDouble(parts[6]));
			}
		} catch(FileNotFoundException e){
			System.out.println("File Not Found");
		} catch(Exception e) {
			System.out.println("Some other exception " + e.getMessage());
		}
		for(int i = 0; i < students.length; i++) {
			System.out.print(students[i].getGpa() + ", ");
		}
		System.out.println("\n----------------");
		sortByGpa(students);
		for(int i = 0; i < students.length; i++) {
			System.out.print(students[i].getGpa() + ", ");
		}
	}
}
