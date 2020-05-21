package finalexam;
import java.util.Arrays;
public class BinarySearchTree {
	private int[] data;
	private BinarySearchTree left;
	private BinarySearchTree right;

	public BinarySearchTree(int[] arr) {
		if(valid(arr))
			this.data = arr;
		else throw new IllegalArgumentException("Invalid input");
	}

	/**
	 * The method valid returns true if arr is not null, not empty
	 * and every element is an int between 0 and 9 inclusive. One extra
	 * condition is arr is NOT valid if the lenght is greater than 1 and arr[0] is 0.
	 * @param arr the array to validate
	 * @return true if the array elements are all between 0 and 9 and there
	 * is at least one element in the array, returns false in all other cases.
	 */
	public static boolean valid(int[] arr) {
		//TODO
		int counter = 0;
		if (arr == null)
			return false;
		if (arr.length != 0) {
			if (arr[0] == 0 && arr.length > 1)
				return false;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] < 0 || arr[i] > 9)
					counter++;
			}
			if (counter == 0)
				return true;
		}
		return false;
	}

	/**
	 * Converts an array that is valid using the test above into
	 * a long formed by the sequence of digits in the array, e.g.
	 * [3, 5, 8, 2, 0, 3] becomes 358203L. We do accept that [0] 
	 * becomes 0L. Note that and array [0, 3, 4, 6] is NOT valid.
	 * This is to avoid the confusion of 0346L and 346L, which 
	 * are the same numerically.
	 *
	 * You start with 0L as the return value and loop through the array
	 * multiplying the return value by 10 and adding the next element 
	 * in the array.
	 *
	 * Return 0L if the array is not valid. 
	 * @param arr the array of digits to convert
	 * @return the sequence of digits in the array as a long an 0L if the array
	 * is not valid 
	 */
	public static Long makeLong(int[] arr) {
		//TODO
		long retLong = 0L;
		if (valid(arr)) {
			for (int i = 0; i < arr.length; i++) {
				retLong = retLong + (long)(arr[i]*Math.pow(10, arr.length-i-1));
			}
		}
		return retLong;
	}

	/**
	 * The insert is provided. The element arr must be
	 * a valid array using the test above and it is stored
	 * according to its numerical value when converted to a 
	 * long.
	 * @param arr array to be inserted in the tree
	 */
	public void insert(int[] arr){
		if (valid(arr)) {
			if(makeLong(data) == makeLong(arr)) return;
			else if(makeLong(data) > makeLong(arr)) {
				if(left == null) left = new BinarySearchTree(arr);
				else left.insert(arr);
			}
			else{
				if(right == null) right = new BinarySearchTree(arr);
				else right.insert(arr);
			}
		}
	}

	/**
	 * Return the array with greatest length in the tree.
	 * If two or more arrays have the same length, return one
	 * of them (which one is not specified by the question)
	 * @return one of the arrays in the tree of greatest length
	 */
	public int[] longest() {
		//TODO
		int[] retArr = new int[0];
		int len = retArr.length;
	    if (data != null) {
			while (left != null) {
				if (left.data.length > len) {
					len = left.data.length;
					retArr = left.data;
				}
				left = left.left;
			}
			while (right != null) {
				if (right.data.length > len) {
					len = right.data.length;
					retArr = right.data;
				}
				right = right.right;
		}
	    }
		return retArr;
	}
	public void prettyPrint() {
		prettyPrint(0);
	}

	private void prettyPrint(int indentLevel) {
		if(left != null) left.prettyPrint(indentLevel + 1);
		for(int i = 0; i < indentLevel; i++) System.out.print("  ");
		System.out.println(Arrays.toString(data));
		if(right != null) right.prettyPrint(indentLevel + 1);
	}
}
