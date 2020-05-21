package quiz20200422;
public class Country {
	private String name;
	private double area;
	private double landArea;
	private int gnp;
	private int pop;
	private Continent cont;

	public Country (String[] arr) {
		if (arr.length != 6)
			throw new IllegalArgumentException("Bad data format");
		for (int i = 0; i < arr.length; i++) {
			if (i == 0)
				name = arr[i].trim();
			if (i == 1)
				area = Double.parseDouble(arr[i].trim());
			if (i == 2)
				landArea = Double.parseDouble(arr[i].trim());
			if (i == 3)
				gnp = Integer.parseInt(arr[i].trim());
			if (i == 4)
				pop = Integer.parseInt(arr[i].trim());
		}
		String temp = arr[5].trim().toUpperCase();
		cont = Continent.valueOf(temp.replace(' ', '_'));
	}

	/**	public static Country parse(String line) {
		String[] fields = line.split("\\|");
		Country country = new Country();
		country.name = fields[0];
		country.cont = fields[1];
		country.pop = Integer.parseInt(fields[2]);
		return country;
	}
	 */

	@Override
	public String toString() {
		return String.format("%s, %s, area(sq km)=%,.2f (%,.2f), GNP=$%,d, Population=%,d", name, cont, area, landArea, gnp, pop);
	}

	public String getName() {
		return name;
	}

	public double getArea() {
		return area;
	}

	public double getLandArea() {
		return landArea;
	}

	public int getGnp() {
		return gnp;
	}

	public int getPop() {
		return pop;
	}

	public Continent getCont() {
		return cont;
	}
}

