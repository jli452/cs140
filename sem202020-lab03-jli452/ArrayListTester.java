package lab03;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class ArrayListTester {
	public static void main (String[] args) {
		System.out.println(ArrayListPractice.intRemoveAll1(List.of(), 1)); // prints 0
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 2, 3));
		System.out.println(ArrayListPractice.intRemoveAll1(list, 2)); // prints 2
		System.out.println(list); // prints [1, 3]

		System.out.println(ArrayListPractice.intRemoveAll2(null, 1));
		System.out.println(ArrayListPractice.intRemoveAll2(List.of(), 1));
		List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(null, null, 1, 2));
		System.out.println(ArrayListPractice.intRemoveAll2(list2, 2));
		System.out.println(list2);

		List<Integer> a = new ArrayList<>();
		List<Integer> b = new LinkedList<>();
		System.out.println(ArrayListPractice.isEqual1(a, b)); // true
		a = new ArrayList<>(Arrays.asList(1,2,3,4));
		b = new LinkedList<>(Arrays.asList(1,2,3,4));
		System.out.println(ArrayListPractice.isEqual1(a, b)); // true
		a = new ArrayList<>(Arrays.asList(1,2,4));
		b = new LinkedList<>(Arrays.asList(1,2,3,4));
		System.out.println(ArrayListPractice.isEqual1(a, b)); // false
		a = new ArrayList<>(Arrays.asList(1,2,4));
		b = new LinkedList<>(Arrays.asList(1,2,3));
		System.out.println(ArrayListPractice.isEqual1(a, b)); // false
		a = new ArrayList<>(Arrays.asList(3,1,2));
		b = new ArrayList<>(Arrays.asList(1,2,3));
		System.out.println(ArrayListPractice.isEqual1(a, b)); // false

		a = new ArrayList<>();
		b = new LinkedList<>();
		System.out.println(ArrayListPractice.isEqual2(a, b)); // true
		a = new ArrayList<>(Arrays.asList(1,2,3,4));
		b = new LinkedList<>(Arrays.asList(1,2,3,4));
		System.out.println(ArrayListPractice.isEqual2(a, b)); // true
		a = new ArrayList<>(Arrays.asList(1,2,4));
		b = new LinkedList<>(Arrays.asList(1,2,3,4));
		System.out.println(ArrayListPractice.isEqual2(a, b)); // false
		a = new ArrayList<>(Arrays.asList(1,2,4));
		b = new LinkedList<>(Arrays.asList(1,2,3));
		System.out.println(ArrayListPractice.isEqual2(a, b)); // false
		a = new ArrayList<>(Arrays.asList(3,1,2));
		b = new ArrayList<>(Arrays.asList(1,2,3));
		System.out.println(ArrayListPractice.isEqual2(a, b)); // false
		System.out.println("-------------------");
		System.out.println(ArrayListPractice.isEqual2(null, null)); // true
		System.out.println(ArrayListPractice.isEqual2(null, List.of())); // false
		System.out.println(ArrayListPractice.isEqual2(List.of(1, 2), null)); // false
		a = new ArrayList<>(Arrays.asList(1,null,2,3,null,4));
		b = new LinkedList<>(Arrays.asList(1,null,2,3,null,4));
		System.out.println(ArrayListPractice.isEqual2(a, b)); // true
		a = new ArrayList<>(Arrays.asList(1,null,2,null,3,4));
		b = new LinkedList<>(Arrays.asList(1,null,2,3,null,4));
		System.out.println(ArrayListPractice.isEqual2(a, b)); // false
	}
}
