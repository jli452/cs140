package assignment06;

public class Tester4 {

	public static void main(String[] args) 
	{
		int failCount = 0;

		System.out.println("TESTING SmallCheesePizza");
		Pizza test = new SmallCheesePizza();
		System.out.println("Expecting: Small cheese pizza");
		System.out.println("Actual:    " + test.getDescription());
		if(test.getDescription().equals("Small cheese pizza"))
			System.out.println("Test 1 SUCCEEDED");
		else 
		{
			System.out.println("Test 1 FAILED");
			failCount++;
		}
		System.out.println("Expecting cost: 8.0");
		System.out.printf("Actual cost:    %.6f\n", test.getCost());
		if(Math.abs(test.getCost() - 8.0) < 1e-6)
			System.out.println("Test 2 SUCCEEDED");
		else 
		{
			System.out.println("Test 2 FAILED");
			failCount++;
		}
		
		test = new Mushroom(test);
		System.out.println("Expecting: Mushroom on Small cheese pizza");
		System.out.println("Actual:    " + test.getDescription());
		if(test.getDescription().equals("Mushroom on Small cheese pizza"))
			System.out.println("Test 3 SUCCEEDED");
		else 
		{
			System.out.println("Test 3 FAILED");
			failCount++;
		}
		System.out.println("Expecting cost: 8.25");
		System.out.printf("Actual cost:    %.6f\n", test.getCost());
		if(Math.abs(test.getCost() - 8.25) < 1e-6)
			System.out.println("Test 4 SUCCEEDED");
		else 
		{
			System.out.println("Test 4 FAILED");
			failCount++;
		}

		test = new GoatCheese(test);
		System.out.println("Expecting: Goat cheese, Mushroom on Small cheese pizza");
		System.out.println("Actual:    " + test.getDescription());
		if(test.getDescription().equals("Goat cheese, Mushroom on Small cheese pizza"))
			System.out.println("Test 5 SUCCEEDED");
		else 
		{
			System.out.println("Test 5 FAILED");
			failCount++;
		}
		System.out.println("Expecting cost: 8.55");
		System.out.printf("Actual cost:    %.6f\n", test.getCost());
		if(Math.abs(test.getCost() - 8.55) < 1e-6)
			System.out.println("Test 6 SUCCEEDED");
		else 
		{
			System.out.println("Test 6 FAILED");
			failCount++;
		}
		
		test = new Pepperoni(test);
		System.out.println("Expecting: Pepperoni, Goat cheese, Mushroom on Small cheese pizza");
		System.out.println("Actual:    " + test.getDescription());
		if(test.getDescription().equals("Pepperoni, Goat cheese, Mushroom on Small cheese pizza"))
			System.out.println("Test 7 SUCCEEDED");
		else 
		{
			System.out.println("Test 7 FAILED");
			failCount++;
		}
		System.out.println("Expecting cost: 8.95");
		System.out.printf("Actual cost:    %.6f\n", test.getCost());
		if(Math.abs(test.getCost() - 8.95) < 1e-6)
			System.out.println("Test 8 SUCCEEDED");
		else 
		{
			System.out.println("Test 8 FAILED");
			failCount++;
		}
		
		System.out.println("TESTING LargeSheetPizza");
		test = new Mushroom(new Pepperoni(new ExtraCheese(new LargeSheetPizza())));
		System.out.println("Expecting: Mushroom, Pepperoni, Extra cheese on Large sheet pizza");
		System.out.println("Actual:    " + test.getDescription());
		if(test.getDescription().equals("Mushroom, Pepperoni, Extra cheese on Large sheet pizza"))
			System.out.println("Test 1 SUCCEEDED");
		else 
		{
			System.out.println("Test 1 FAILED");
			failCount++;
		}
		System.out.println("Expecting cost: 15.8");
		System.out.printf("Actual cost:    %.6f\n", test.getCost());
		if(Math.abs(test.getCost() -15.8) < 1e-6)
			System.out.println("Test 2 SUCCEEDED");
		else 
		{
			System.out.println("Test 2 FAILED");
			failCount++;
		}

		System.out.println("TESTING MediumPizza");
		test = new Mushroom(new Pepperoni(new ExtraCheese(new MediumCheesePizza())));
		System.out.println("Expecting: Mushroom, Pepperoni, Extra cheese on Medium cheese pizza");
		System.out.println("Actual:    " + test.getDescription());
		if(test.getDescription().equals("Mushroom, Pepperoni, Extra cheese on Medium cheese pizza"))
			System.out.println("Test 1 SUCCEEDED");
		else 
		{
			System.out.println("Test 1 FAILED");
			failCount++;
		}
		System.out.println("Expecting cost: 10.8");
		System.out.printf("Actual cost:    %.6f\n", test.getCost());
		if(Math.abs(test.getCost() -10.8) < 1e-6)
			System.out.println("Test 2 SUCCEEDED");
		else 
		{
			System.out.println("Test 2 FAILED");
			failCount++;
		}
		
		System.out.println("\nNumber of FAILURES " + failCount);		
	}

}
