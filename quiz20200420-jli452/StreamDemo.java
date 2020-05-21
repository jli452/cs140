package quiz20200420;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
	static int LENGTH = 7;
	public static void main(String[] args) throws IOException {
		try (Stream<String> lines = Files.lines(Paths.get("countries.txt"))) { 
			// Read the lines
			List<String> result = lines
					.filter(w -> w.length() >= LENGTH + 3) // Keep only long words
					.map(w -> w.substring(0, LENGTH)) // Truncate to seven characters
					.map(w -> w + "...") // Add ellipses
					.limit(20)
					.distinct() // Remove duplicates
					.collect(Collectors.toList()); // Collect into a list
			System.out.println(result.size());
			System.out.println(result);
		}
	}
}
