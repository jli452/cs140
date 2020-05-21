package lab04;
import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileExtractor
{
	private int[] array;
	private List<Integer> list;
	
	public FileExtractor(String fileName)
	{
		list = new ArrayList<Integer>();

		try(Scanner sc = new Scanner(new File(fileName)))
		{
			while (sc.hasNextInt())
				list.add(sc.nextInt());
			array = new int[list.size()];
			for (int i = 0; i < list.size(); i++)
				array[i] = list.get(i);
		}

		catch(FileNotFoundException e)
		{
			array = new int[0];
			System.out.println("File '" + fileName + "' not found, initializing both 'list' and 'array' to be empty\n");

		}

		catch(Exception e)
		{
			System.out.println("Error occurred while extracting data:\n");
			e.printStackTrace();
		}

	}

	public List<Integer> getList()
	{
		return list;
	}

	public int[] getArray()
	{
		return array;
	}
	
	public String toString()
	{
		return "array: " + Arrays.toString(array) + "\nlist: " + list.toString();

	}

	public void removeOddElements()
	{
		int numEven = 0;
		for (int num : array)
		{
			if (num % 2 == 0)
				numEven++;
		}
		int[] temp = new int[numEven];
		int index = 0;

		for (int num : array)
		{
			if (num % 2 == 0)
			{
				temp[index] = num;
				index++;
			}
		}
		array = temp;
	}

	public void removeEvenElements()
	{
		Iterator<Integer> iter = list.iterator();
		while (iter.hasNext())
		{
			Integer i = iter.next();
			if (i % 2 == 0)
				iter.remove(); 
		}
	}

	public FileExtractor()
	{
	}

	public static FileExtractor makeUsingStream(String fileName)
	{
		var retVal = new FileExtractor();
		try (Stream<String> lines = Files.lines(Paths.get(fileName))){
		 	retVal.list = lines
		 		.map(line -> line.trim())
		 		.filter(line -> line.length() > 0)
		 		.map(Integer::valueOf)
		 		.collect(Collectors.toList());
			retVal.array = retVal.list.stream()
				.mapToInt(v -> v)
				.toArray();
		} catch (IOException e) {
		   e.printStackTrace();
		}
		return retVal;
	}

	public void streamRemoveOddElements()
	{
		array = list.stream()
			.mapToInt(v -> v)
			.filter(x -> x%2 == 0)
			.toArray();
	}

	public static FileExtractor oldWayButWorksOnAllFiles(String fileName)
	{
		// Many have seen the Scanner version breaks on very large files
		// this version does work. I have not seen the results from the 
		// Stream version and have not tested it myself
		var retVal = new FileExtractor(); 
		retVal.list = new ArrayList<>();
		try (var b = new BufferedReader(new FileReader(fileName))) {
			String readLine = "";
			while((readLine = b.readLine()) != null) {
				retVal.list.add(Integer.valueOf(readLine.trim()));
	 		}
	 		retVal.array = new int[retVal.list.size()];
	 		int i = 0;
	 		for(int x : retVal.list) retVal.array[i++] = x;
	 	} catch (IOException e) {
			e.printStackTrace();
		}
		return retVal;
	}
}
