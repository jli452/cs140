package lab05;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Tester {

    public static void main(String[] args) {
    	testDivision();
    	testFunWithStrings();
        testZipper();
    }

    //uncomment for testing Division
    
    public static void testDivision() {
        Division set = new Division(new double[]{1,2,3,0,4,5,0,6,0,7,8,9,0});
        set.removeZeroes();
        set.divide(2);
        System.out.println("Expecting [0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5]");
        System.out.println("Received  " + set + "\n");

		Division set2 = new Division(new double[]{5, 0, 5, 0, 50, 10, 5});
        set2.removeZeroes();
        set2.divide(5);
        System.out.println("Expecting [1.0, 1.0, 10.0, 2.0, 1.0]");
        System.out.println("Received  " + set2 + "\n");
        
    }
   

    //uncomment for testing FunWithStrings
    
    public static void testFunWithStrings() {
    	List<String> list1 = new ArrayList<String>(Arrays.asList("to", "cellphone", "truck", "fire"));
    	List<String> list2 = new ArrayList<String>(Arrays.asList("delicious", "copper", "blue", "red"));
    	FunWithStrings.swapMaxes(list1, list2);
        System.out.println("Expecting [to, delicious, truck, fire] [cellphone, copper, blue, red]");
        System.out.println("Received  " + list1 + " " + list2 + "\n");
		List<String> list3 = new ArrayList<String>(Arrays.asList("what", "is", "a", "computer"));
    	List<String> list4 = new ArrayList<String>(Arrays.asList("its", "a", "machine", "right"));
    	FunWithStrings.swapMaxes(list3, list4);
		System.out.println("Expecting [what, is, a, machine] [its, a, computer, right]");
        System.out.println("Received  " + list3 + " " + list4 + "\n");
    }
    
    
    //uncomment for testing Zipper
    
    public static void testZipper() {
        int ret[] = Zipper.zip(new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8});
        System.out.println("Expecting [1, 5, 2, 6, 3, 7, 4, 8]");
        System.out.println("Received  " + Arrays.toString(ret));
	int ret2[] = Zipper.zip(new int[]{1, 2, 3, 4, 5}, new int[]{5, 6, 7, 8, 9});
        System.out.println("Expecting [1, 5, 2, 6, 3, 7, 4, 8, 5, 9]");
        System.out.println("Received  " + Arrays.toString(ret2));
    }
    
}
