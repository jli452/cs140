package assignment06;
public class Tester1 
{
	public static void main(String[] args)
	{
		int failCount = 0;
		System.out.println("TESTING Haskell");
		String test = new Haskell().forLayout();
		System.out.println("Expected:");
		System.out.println("no \"for\" construct"); 
		System.out.println("Actual:");
		System.out.println(test);		
		if(test.equals("no \"for\" construct"))
			System.out.println("Test 1 SUCCEEDED");
		else 
		{
			System.out.println("Test 1 FAILED");
			failCount++;
		}

		System.out.println("TESTING Java");
		test = new Java().forLayout("int i = 0", " i < arr.length", " i++");
		System.out.println("Expected:");
		System.out.println("for(int i = 0; i < arr.length; i++)"); 
		System.out.println("{");
		System.out.println();
		System.out.println();
		System.out.println("}");
		System.out.println("Actual:");
		System.out.println(test);
		while(test.indexOf("  ") >= 0) test = test.replace("  ", " ");
		while(test.indexOf(" \n") >= 0) test = test.replace(" \n", "\n");
		while(test.indexOf("\n ") >= 0) test = test.replace("\n ", "\n");
		if(test.equals("for(int i = 0; i < arr.length; i++)\n{\n\n\n}") || 
				test.equals("for(int i = 0; i < arr.length; i++){\n\n\n}"))
			System.out.println("Test 2 SUCCEEDED");
		else 
		{
			System.out.println("Test 2 FAILED");
			failCount++;
		}
		test = new Java().forLayout("arr");
		System.out.println("Expected:");
		System.out.println("for(var x : arr)"); 
		System.out.println("{");
		System.out.println();
		System.out.println();
		System.out.println("}");
		System.out.println("Actual:");
		System.out.println(test);
		while(test.indexOf("  ") >= 0) test = test.replace("  ", " ");
		while(test.indexOf(" \n") >= 0) test = test.replace(" \n", "\n");
		while(test.indexOf("\n ") >= 0) test = test.replace("\n ", "\n");
		if(test.equals("for(var x : arr)\n{\n\n\n}") ||
				test.equals("for(var x : arr){\n\n\n}"))
			System.out.println("Test 3 SUCCEEDED");
		else 
		{
			System.out.println("Test 3 FAILED");
			failCount++;
		}
		try 
		{
			new Java().forLayout(null);
		} 
		catch(IllegalArgumentException e)
		{
			System.out.println("Expected: bad arguments");
			System.out.println("Actual:   " + e.getMessage());
			if(e.getMessage().equals("bad arguments"))
				System.out.println("Test 4 SUCCEEDED");
			else 
			{
				System.out.println("Test 4 FAILED");
				failCount++;
			}
		}
		try 
		{
			new Java().forLayout("int i = 0", " i < 10");
		} 
		catch(IllegalArgumentException e)
		{
			System.out.println("Expected: bad arguments");
			System.out.println("Actual:   " + e.getMessage());
			if(e.getMessage().equals("bad arguments"))
				System.out.println("Test 5 SUCCEEDED");
			else 
			{
				System.out.println("Test 5 FAILED");
				failCount++;
			}
		}
		try 
		{
			new Java().forLayout("int i = 0", " i < 10", "i++", "{");
		} 
		catch(IllegalArgumentException e)
		{
			System.out.println("Expected: bad arguments");
			System.out.println("Actual:   " + e.getMessage());
			if(e.getMessage().equals("bad arguments"))
				System.out.println("Test 6 SUCCEEDED");
			else 
			{
				System.out.println("Test 6 FAILED");
				failCount++;
			}
		}

		System.out.println("TESTING Python");
		test = new Python().forLayout("range(0, 3)");
		System.out.println("Expected:");
		System.out.println("for x in range(0, 3)"); 
		System.out.println("Actual:");
		System.out.println(test);
		while(test.indexOf("  ") >= 0) test = test.replace("  ", " ");
		if(test.equals("for x in range(0, 3)"))
			System.out.println("Test 7 SUCCEEDED");
		else 
		{
			System.out.println("Test 7 FAILED");
			failCount++;
		}
		try 
		{
			new Python().forLayout(null);
		} 
		catch(IllegalArgumentException e)
		{
			System.out.println("Expected: bad arguments");
			System.out.println("Actual:   " + e.getMessage());
			if(e.getMessage().equals("bad arguments"))
				System.out.println("Test 8 SUCCEEDED");
			else 
			{
				System.out.println("Test 8 FAILED");
				failCount++;
			}
		}
		try 
		{
			new Python().forLayout("int i = 0", " i < 10");
		} 
		catch(IllegalArgumentException e)
		{
			System.out.println("Expected: bad arguments");
			System.out.println("Actual:   " + e.getMessage());
			if(e.getMessage().equals("bad arguments"))
				System.out.println("Test 9 SUCCEEDED");
			else 
			{
				System.out.println("Test 9 FAILED");
				failCount++;
			}
		}
		try 
		{
			new Python().forLayout("int i = 0", " i < 10", "i++", "{");
		} 
		catch(IllegalArgumentException e)
		{
			System.out.println("Expected: bad arguments");
			System.out.println("Actual:   " + e.getMessage());
			if(e.getMessage().equals("bad arguments"))
				System.out.println("Test 10 SUCCEEDED");
			else 
			{
				System.out.println("Test 10 FAILED");
				failCount++;
			}
		}

		System.out.println("TESTING Ada");
		test = new Ada().forLayout("Integer range 1 .. 10");
		System.out.println("Expected:");
		System.out.println("for x in Integer range 1 .. 10 loop"); 
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("end loop;");
		System.out.println("Actual:");
		System.out.println(test);
		while(test.indexOf("  ") >= 0) test = test.replace("  ", " ");
		while(test.indexOf(" \n") >= 0) test = test.replace(" \n", "\n");
		while(test.indexOf("\n ") >= 0) test = test.replace("\n ", "\n");
		if(test.equals("for x in Integer range 1 .. 10 loop\n\n\n\nend loop;"))
			System.out.println("Test 11 SUCCEEDED");
		else 
		{
			System.out.println("Test 11 FAILED");
			failCount++;
		}
		test = new Ada().forLayout("X'range");
		System.out.println("Expected:");
		System.out.println("for x in X'range loop"); 
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("end loop;");
		System.out.println("Actual:");
		System.out.println(test);
		while(test.indexOf("  ") >= 0) test = test.replace("  ", " ");
		while(test.indexOf(" \n") >= 0) test = test.replace(" \n", "\n");
		while(test.indexOf("\n ") >= 0) test = test.replace("\n ", "\n");
		if(test.equals("for x in X'range loop\n\n\n\nend loop;"))
			System.out.println("Test 12 SUCCEEDED");
		else 
		{
			System.out.println("Test 12 FAILED");
			failCount++;
		}
		try 
		{
			new Ada().forLayout(null);
		} 
		catch(IllegalArgumentException e)
		{
			System.out.println("Expected: bad arguments");
			System.out.println("Actual:   " + e.getMessage());
			if(e.getMessage().equals("bad arguments"))
				System.out.println("Test 13 SUCCEEDED");
			else 
			{
				System.out.println("Test 13 FAILED");
				failCount++;
			}
		}
		try 
		{
			new Ada().forLayout("int i = 0", " i < 10");
		} 
		catch(IllegalArgumentException e)
		{
			System.out.println("Expected: bad arguments");
			System.out.println("Actual:   " + e.getMessage());
			if(e.getMessage().equals("bad arguments"))
				System.out.println("Test 14 SUCCEEDED");
			else 
			{
				System.out.println("Test 14 FAILED");
				failCount++;
			}
		}
		try 
		{
			new Ada().forLayout("int i = 0", " i < 10", "i++", "{");
		} 
		catch(IllegalArgumentException e)
		{
			System.out.println("Expected: bad arguments");
			System.out.println("Actual:   " + e.getMessage());
			if(e.getMessage().equals("bad arguments"))
				System.out.println("Test 15 SUCCEEDED");
			else 
			{
				System.out.println("Test 15 FAILED");
				failCount++;
			}
		}

		System.out.println("\nNumber of FAILURES " + failCount);		
	}
}