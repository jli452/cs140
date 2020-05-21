package lab04;

class BadClass2 {
    private int[] myArray;

    public BadClass2(int[] anArray) {
    	int[] myArray = anArray;
    }

    public static void main(String[] args){
    	int[] test = {1,2,3,4,5};
    	var obj = new BadClass2(test);
    	int[] arr = obj.myArray;
    	System.out.println(arr.length);
    }
}
