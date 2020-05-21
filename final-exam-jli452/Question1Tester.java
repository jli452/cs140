package finalexam;

import java.util.Arrays;

public class Question1Tester {
	public static void main(String[] args) {
		System.out.println(BinarySearchTree.valid(new int[] {1,-1,2}) + " should be false");
		System.out.println(BinarySearchTree.valid(new int[] {0, 1, 2}) + " should be false");
		System.out.println(BinarySearchTree.valid(new int[] {0, 0, 1, 2}) + " should be false");
		System.out.println(BinarySearchTree.valid(new int[] {11,2}) + " should be false");
		System.out.println(BinarySearchTree.valid(new int[] {}) + " should be false");
		System.out.println(BinarySearchTree.valid(null) + " should be false");
		System.out.println(BinarySearchTree.valid(new int[] {0}) + " should be true");
		System.out.println(BinarySearchTree.valid(new int[] {1, 2, 3, 4}) + " should be true");
		System.out.println(BinarySearchTree.makeLong(new int[] {0}) + " should be 0");
		System.out.println(BinarySearchTree.makeLong(new int[] {1, 2, 3, 4}) + " should be 1234");
		System.out.println(BinarySearchTree.makeLong(new int[] {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}) + " should be 9999999999999999");
		BinarySearchTree tree = new BinarySearchTree(new int[] {6, 2, 3, 4});
		tree.insert(new int[] {3, 2, 3, 4});
		tree.insert(new int[] {7, 2, 3, 4});
		tree.insert(new int[] {2, 2, 3, 4});
		tree.insert(new int[] {1, 2, 3, 4, 6});
		tree.insert(new int[] {7, 2, 3, 4, 6});
		tree.insert(new int[] {5, 2, 3, 4});
		tree.insert(new int[] {8, 2, 3, 4});
		tree.insert(new int[] {9, 2, 3, 4});
		tree.insert(new int[] {4, 2, 3, 4});
		System.out.println("TREE:");
		tree.prettyPrint();
		System.out.println("CHECKING longest:");
		System.out.println(Arrays.toString(tree.longest()) + " should be [1, 2, 3, 4, 6] or [7, 2, 3, 4, 6]");
	}

}
