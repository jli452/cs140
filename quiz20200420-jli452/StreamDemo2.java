package quiz20200420;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo2 {
	static int LENGTH = 7;
	public static int test() throws IOException {
		var a = 0;
		var b = 1;
		while(a != b)
		{
			LENGTH++;
			try (Stream<String> lines = Files.lines(Paths.get("countries.txt"))) { 
				// Read the lines
				List<String> result = lines
						.filter(w -> w.length() >= LENGTH) // Keep only long words
						.map(w -> w.substring(0, LENGTH)) // Truncate to seven characters
						.distinct() // Remove duplicates
						.collect(Collectors.toList()); // Collect into a list
				System.out.println(result.size());
				System.out.println(result);
				a = result.size();
			}
			try (Stream<String> lines = Files.lines(Paths.get("countries.txt"))) { 
				// Read the lines
				List<String> result = lines
						.filter(w -> w.length() >= LENGTH) // Keep only long words
						.map(w -> w.substring(0, LENGTH)) // Truncate to seven characters
						.collect(Collectors.toList()); // Collect into a list
				System.out.println(result.size());
				System.out.println(result);
				b = result.size();
			}
		}
		return LENGTH;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(test());
	}
}
