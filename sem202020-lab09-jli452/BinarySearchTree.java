package lab09;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to implement the Binary Search Tree data structure.
 * The structure is generic in the type of Objects it contains.
 * @param <T> the type of the contained elements this structure is to hold
 */
public class BinarySearchTree<T> {
	private Comparator<T> comparator;
	private T data;
	private BinarySearchTree<T> left;
	private BinarySearchTree<T> right;

	/**
	 * Constructs an empty BST with a Comparator
	 * @param comp the Comparator to use to impose an ordering on instances of T
	 */
	public BinarySearchTree(Comparator<T> comp) {
		this.comparator = comp;
	}

	/**
	 * Constructs a BST with data and a Comparator
	 * @param data the data this BST should hold
	 * @param comp the Comparator to use to impose an ordering on instances of T
	 */
	public BinarySearchTree(T datum, Comparator<T> comp) {
		data = datum;
		comparator = comp;
	}

	/**
	 * Inserts an element into this BST
	 * if element is null, do not insert element
	 * it is worth noting that the only time data could be null is if we created a BST with no initial data
	 * in that case, if data is null, we just update data to equal element, and the insertion is done.
	 * If the element to be inserted and another value that is already in the tree have a comparator.compare value of 0, 
	 * do not insert element we do this for the sake of simplicity, forcing elements in the tree to be unique with respect
	 * to the compare method. Note we were more flexible in quiz20200401 but here we need the < and > values of comparator.compare
	 * to decide whether to go into the left or right subtrees. 
	 * @param element the element to insert into this BST
	 */
	public void insert(T element) {
		// TODO
		if (element == null) return;
		if (data == null)
			data = element;
		if (comparator.compare(element, data) == 0);
		else if (comparator.compare(element, data) < 0) {
			if(left == null)
				left = new BinarySearchTree<T>(element, comparator);
			else
				left.insert(element);
		}
		else if (comparator.compare(element, data) > 0) {
			if(right == null)
				right = new BinarySearchTree<T>(element, comparator);
			else
				right.insert(element);
		}
	}

	/**
	 * Searches for a given element in this BST
	 * if element is null, return null
	 * @param element the element to search this BST for
	 * @return the element in this BST matching the given element, if found,
	 *         otherwise null if the given element is not in this BST
	 */
	public T find(T element) {
		// TODO
		if (element == null) {
			return null;
		}
		if (comparator.compare(element, data) == 0)
			return element;
		if (comparator.compare(element, data) < 0 && left != null)
			return left.find(element);
		if (comparator.compare(element, data) > 0 && right != null)
			return right.find(element);
		return null;
	}

	/**
	 * Gathers all the elements of this BST in order
	 * @return a List holding the elements in this BST in order
	 */
	public List<T> getElements() {
		List<T> list = new ArrayList<>();
		// TODO
		if (data != null) {
			if (left != null) {
				list.addAll(left.getElements());
			}
			list.add(data);
			if (right != null)
				list.addAll(right.getElements());
		}
		return list;
	}

	/**
	 * Pretty prints the contents of this BST in a horizontal tree-like fashion
	 */
	public void prettyPrint() {
		prettyPrint(0);
	}

	private void prettyPrint(int indentLevel) {
		// TODO
		// print `indentLevel` amount of spaces before printing data on its own line
		//HINT: you will want to do an in order traversal here. (see the Traversal section in the explanation of Binary Trees above)
		// you may use a for loop to print `indentLevel` amount of spaces
		// each time you recurse, you add to indentLevel
		if (data != null) {
			if (left != null) {
				left.prettyPrint(indentLevel +1);
			}
			for (int i = 0; i < indentLevel; i++) {
				System.out.print("  ");
			}
			System.out.print(data);
			System.out.println();
			if (right != null) {
				right.prettyPrint(indentLevel +1);
			}
			
		}
	}

	/**
	 * A main method supplied for any debugging needs
	 */
	public static void main(String[] args) {
		// Up to you how you use this main method, feel free to change it
		Comparator<Integer> intComp = (i, j) -> i - j; // lambda expression
		BinarySearchTree<Integer> tree = new BinarySearchTree<>(intComp);
		tree.insert(3);
		tree.insert(8);
		tree.insert(1);
		tree.insert(0);
		tree.insert(3);
		tree.insert(9);
		tree.insert(4);
		tree.prettyPrint();
		System.out.println();
		Comparator<String> strComp = (i, j) -> j.length() - i.length(); // lambda expression
		BinarySearchTree<String> tree2 = new BinarySearchTree<>(strComp);
		tree2.insert("test");
		tree2.insert("hi");
		tree2.insert("stella");
		tree2.insert("a");
		tree2.insert("cat");
		tree2.insert("penta");
		tree2.insert("oxymoron");
		tree2.insert("oranges");
		tree2.insert("blackjack");
		tree2.prettyPrint();
	}
}
