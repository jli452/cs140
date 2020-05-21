package exam01;
import java.util.ArrayList;
import java.util.List;

public class Question3
{
	private List<Student> students = new ArrayList<>();
	
	public void addStudent(Student stdt)
	{
		if (stdt != null)
			students.add(stdt);
	}

	public double[] fractions()
	{
		if (students == null)
			return null;
		double counter0 = 0;
		double counter1 = 0;
		double counter2 = 0;
		double counter3 = 0;
		double[] retArr = new double[4];
		for (int i = 0; i < students.size(); i++)
		{
			if (students.get(i).getGpa() >= 0 && students.get(i).getGpa() < 1)
				counter0++;
			if (students.get(i).getGpa() >= 1 && students.get(i).getGpa() < 2)
				counter1++;
			if (students.get(i).getGpa() >= 2 && students.get(i).getGpa() < 3)
				counter2++;
			if (students.get(i).getGpa() >= 3)
				counter3++;
		}
		retArr[0] = 100*counter0/students.size();
		retArr[1] = 100*counter1/students.size();
		retArr[2] = 100*counter2/students.size();
		retArr[3] = 100*counter3/students.size();
		return retArr;
	}
}
