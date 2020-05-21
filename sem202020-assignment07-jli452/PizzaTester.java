package assignment07;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PizzaTester {
	@Test
	void testMediumPizzaCost() {
		Pizza order = new MediumCheesePizza();
		order = new Mushroom(order);
		order = new Pepperoni(order);
		order = new Pepperoni(order);
		try {
			assertEquals(11.05, order.getCost(), 1e-6);
		}
		catch(AssertionError e) {
			System.out.println("MediumCheesePizza's getCost() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	void testSmallPizzaCost() {
		Pizza order = new SmallCheesePizza();
		order = new GoatCheese(order);
		order = new Mushroom(order);
		try {
			assertEquals(8.55, order.getCost(), 1e-6);
		}
		catch(AssertionError e) {
			System.out.println("SmallCheesePizza's getCost() method failed: " + e.getMessage());
			throw e;
		}
	}
}
