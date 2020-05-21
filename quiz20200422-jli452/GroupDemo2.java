package quiz20200422;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupDemo2 {
	public static void main(String[] args) throws IOException {
		try (Stream<String> lines = Files.lines(Paths.get("CountryData.txt"))) {
			Stream<Country> countries = lines
					.map(line -> line.split("\\t"))
					.map(Country::new);

			Map<Continent, Long> groupSum = countries.collect(
					Collectors.groupingBy(
							c -> c.getCont(), // The function for extracting the keys
							Collectors.summingLong(
									c -> c.getPop()))); // The function for getting the summands

			System.out.println("Population per continent: ");
			for(Entry<Continent, Long> e : groupSum.entrySet()) {
				System.out.println(e);
			}
		}
	}
}

