package assignment06;

import java.util.Arrays;

public class Tester2 {

	public static void main(String[] args) 
	{
		int failCount = 0;
		System.out.println("TESTING Rectangle");
		GraphicObject test = new Rectangle(new double[] {7.0, 10.0, 25.0, 30.0});
		test.move(55.0, 65.0);
		System.out.println("Expected: [62.0, 75.0, 80.0, 95.0]");
		System.out.println("Actual:   " + Arrays.toString(test.getReferenceValues()));
		if(Arrays.equals(test.getReferenceValues(), new double[] {62.0, 75.0, 80.0, 95.0}))
			System.out.println("Test 1 SUCCEEDED");
		else 
		{
			System.out.println("Test 1 FAILED");
			failCount++;
		}
		try 
		{
			new Rectangle((double[])null);
		} 
		catch(IllegalArgumentException e)
		{
			System.out.println("Expected: argument must have length 4");
			System.out.println("Actual:   " + e.getMessage());
			if(e.getMessage().equals("argument must have length 4"))
				System.out.println("Test 2 SUCCEEDED");
			else 
			{
				System.out.println("Test 2 FAILED");
				failCount++;
			}
		}
		try 
		{
			new Rectangle(new double[] {7.0, 10.0, 30.0});
		} 
		catch(IllegalArgumentException e)
		{
			System.out.println("Expected: argument must have length 4");
			System.out.println("Actual:   " + e.getMessage());
			if(e.getMessage().equals("argument must have length 4"))
				System.out.println("Test 3 SUCCEEDED");
			else 
			{
				System.out.println("Test 3 FAILED");
				failCount++;
			}
		}
		try 
		{
			new Rectangle(new double[] {7.0, 10.0, 25.0, 30.0, 100.0});
		} 
		catch(IllegalArgumentException e)
		{
			System.out.println("Expected: argument must have length 4");
			System.out.println("Actual:   " + e.getMessage());
			if(e.getMessage().equals("argument must have length 4"))
				System.out.println("Test 4 SUCCEEDED");
			else 
			{
				System.out.println("Test 4 FAILED");
				failCount++;
			}
		}
		try 
		{
			new Rectangle(new double[] {50.0, 10.0, 25.0, 30.0});
		} 
		catch(IllegalArgumentException e)
		{
			System.out.println("Expected: top left, bottom right out of position");
			System.out.println("Actual:   " + e.getMessage());
			if(e.getMessage().equals("top left, bottom right out of position"))
				System.out.println("Test 5 SUCCEEDED");
			else 
			{
				System.out.println("Test 5 FAILED");
				failCount++;
			}
		}
		try 
		{
			new Rectangle(new double[] {10.0, 60.0, 25.0, 30.0});
		} 
		catch(IllegalArgumentException e)
		{
			System.out.println("Expected: top left, bottom right out of position");
			System.out.println("Actual:   " + e.getMessage());
			if(e.getMessage().equals("top left, bottom right out of position"))
				System.out.println("Test 6 SUCCEEDED");
			else 
			{
				System.out.println("Test 6 FAILED");
				failCount++;
			}
		}

		System.out.println("TESTING Circle");
		test = new Circle(new double[] {7.0, 10.0, 25.0});
		test.move(55.0, 65.0);
		System.out.println("Expected: [62.0, 75.0, 25.0]");
		System.out.println("Actual:   " + Arrays.toString(test.getReferenceValues()));
		if(Arrays.equals(test.getReferenceValues(), new double[] {62.0, 75.0, 25.0}))
			System.out.println("Test 7 SUCCEEDED");
		else 
		{
			System.out.println("Test 7 FAILED");
			failCount++;
		}
		try 
		{
			new Circle((double[])null);
		} 
		catch(IllegalArgumentException e)
		{
			System.out.println("Expected: argument must have length 3");
			System.out.println("Actual:   " + e.getMessage());
			if(e.getMessage().equals("argument must have length 3"))
				System.out.println("Test 8 SUCCEEDED");
			else 
			{
				System.out.println("Test 8 FAILED");
				failCount++;
			}
		}
		try 
		{
			new Circle(new double[] {7.0, 10.0});
		} 
		catch(IllegalArgumentException e)
		{
			System.out.println("Expected: argument must have length 3");
			System.out.println("Actual:   " + e.getMessage());
			if(e.getMessage().equals("argument must have length 3"))
				System.out.println("Test 9 SUCCEEDED");
			else 
			{
				System.out.println("Test 9 FAILED");
				failCount++;
			}
		}
		try 
		{
			new Circle(new double[] {7.0, 10.0, 25.0, 30.0, 100.0});
		} 
		catch(IllegalArgumentException e)
		{
			System.out.println("Expected: argument must have length 3");
			System.out.println("Actual:   " + e.getMessage());
			if(e.getMessage().equals("argument must have length 3"))
				System.out.println("Test 10 SUCCEEDED");
			else 
			{
				System.out.println("Test 10 FAILED");
				failCount++;
			}
		}
		try 
		{
			new Circle(new double[] {50.0, 10.0, 0.0});
		} 
		catch(IllegalArgumentException e)
		{
			System.out.println("Expected: radius must be non-zero");
			System.out.println("Actual:   " + e.getMessage());
			if(e.getMessage().equals("radius must be non-zero"))
				System.out.println("Test 11 SUCCEEDED");
			else 
			{
				System.out.println("Test 11 FAILED");
				failCount++;
			}
		}
		try 
		{
			new Circle(new double[] {50.0, 10.0, -5.0});
		} 
		catch(IllegalArgumentException e)
		{
			System.out.println("Expected: radius must be non-zero");
			System.out.println("Actual:   " + e.getMessage());
			if(e.getMessage().equals("radius must be non-zero"))
				System.out.println("Test 12 SUCCEEDED");
			else 
			{
				System.out.println("Test 12 FAILED");
				failCount++;
			}
		}

		System.out.println("TESTING Triangle");
		test = new Triangle(new double[] {7.0, 10.0, 25.0, 30.0, 1.0, 40.0});
		test.move(55.0, 65.0);
		System.out.println("Expected: [62.0, 75.0, 80.0, 95.0, 56.0, 105.0]");
		System.out.println("Actual:   " + Arrays.toString(test.getReferenceValues()));
		if(Arrays.equals(test.getReferenceValues(), new double[] {62.0, 75.0, 80.0, 95.0, 56.0, 105.0}))
			System.out.println("Test 13 SUCCEEDED");
		else 
		{
			System.out.println("Test 13 FAILED");
			failCount++;
		}
		try 
		{
			new Triangle((double[])null);
		} 
		catch(IllegalArgumentException e)
		{
			System.out.println("Expected: argument must have length 6");
			System.out.println("Actual:   " + e.getMessage());
			if(e.getMessage().equals("argument must have length 6"))
				System.out.println("Test 14 SUCCEEDED");
			else 
			{
				System.out.println("Test 14 FAILED");
				failCount++;
			}
		}
		try 
		{
			new Triangle(new double[] {62.0, 75.0, 80.0, 95.0, 56.0});
		} 
		catch(IllegalArgumentException e)
		{
			System.out.println("Expected: argument must have length 6");
			System.out.println("Actual:   " + e.getMessage());
			if(e.getMessage().equals("argument must have length 6"))
				System.out.println("Test 15 SUCCEEDED");
			else 
			{
				System.out.println("Test 15 FAILED");
				failCount++;
			}
		}
		try 
		{
			new Triangle(new double[] {7.0, 10.0, 25.0, 30.0, 100.0, 0.0, 0.0});
		} 
		catch(IllegalArgumentException e)
		{
			System.out.println("Expected: argument must have length 6");
			System.out.println("Actual:   " + e.getMessage());
			if(e.getMessage().equals("argument must have length 6"))
				System.out.println("Test 16 SUCCEEDED");
			else 
			{
				System.out.println("Test 16 FAILED");
				failCount++;
			}
		}
		try 
		{
			new Triangle(new double[] {7.0, 10.0, 25.0, 30.0, 43.0, 50.0});
		} 
		catch(IllegalArgumentException e)
		{
			System.out.println("Expected: points must give non-zero area");
			System.out.println("Actual:   " + e.getMessage());
			if(e.getMessage().equals("points must give non-zero area"))
				System.out.println("Test 17 SUCCEEDED");
			else 
			{
				System.out.println("Test 17 FAILED");
				failCount++;
			}
		}
		
		System.out.println("\nNumber of FAILURES " + failCount);		
	}

}
