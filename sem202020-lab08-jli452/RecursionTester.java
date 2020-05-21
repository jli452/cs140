package lab08;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class RecursionTester extends Recursion{
	@Test
	void testRecurse() {
		try {
			assertEquals(1, recurse(1));
		}
		catch(AssertionError e) {
			System.out.println("recurse(int n) method failed for n = 1: " + e.getMessage());
			throw e;
		}
	}

	@Test
	void testRecurse2() {
		try {
			assertEquals(3, recurse(2));
		}
		catch(AssertionError e) {
			System.out.println("recurse(int n) method failed for n = 2: " + e.getMessage());
			throw e;
		}
	}

	@Test
	void testRecurse3() {
		try {
			assertEquals(3, recurse(5));
		}
		catch(AssertionError e) {
			System.out.println("recurse(int n) method failed for n > 2: " + e.getMessage());
			throw e;
		}
	}

	@Test
	void testSquareRoot() {
		try {
			assertEquals(0, squareRoot(0), 1e-6);
		}
		catch(AssertionError e) {
			System.out.println("squareRoot(double n) method failed for n = 0: " + e.getMessage());
			throw e;
		}
	}
	@Test
	void testSquareRoot2() {
		try {
			assertEquals(1, squareRoot(1), 1e-6);
		}
		catch(AssertionError e) {
			System.out.println("squareRoot(double n) method failed for n = 1: " + e.getMessage());
			throw e;
		}
	}
	@Test
	void testSquareRoot3() {
		try {
			assertEquals(7, squareRoot(49), 1e-6);
		}
		catch(AssertionError e) {
			System.out.println("squareRoot(double n) method failed for n = 16: " + e.getMessage());
			throw e;
		}
	}

	@Test
	void testSumList() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(5);
		try {
			assertEquals(9, sum(list));
		}
		catch(AssertionError e) {
			System.out.println("sum(List<Integer> nums) method failed: " + e.getMessage());
			throw e;
		}
	}

	@Test
	void testSumArr() {
		int[] arr = new int[]{5, 7 ,9};
		try {
			assertEquals(21, sum(arr));
		}
		catch(AssertionError e) {
			System.out.println("sum(int[] nums) method failed: " + e.getMessage());
			throw e;
		}
	}

	@Test
	void testBinomialCoefficient() {
		try {
			assertEquals(84, binomialCoefficient(9,3));
		}
		catch(AssertionError e) {
			System.out.println("binomialCoefficient() method failed for k < n/2: " + e.getMessage());
			throw e;
		}
	}

	@Test
	void testBinomialCoefficient2() {
		try {
			assertEquals(252, binomialCoefficient(10,5));
		}
		catch(AssertionError e) {
			System.out.println("binomialCoefficient() method failed for k > n/2: " + e.getMessage());
			throw e;
		}

	}
}
