// DO all the TODO
// THEN READ THE README
package quiz20200401;
public class MyList<T> {
	private class Node {
		private T data;
		private Node next;
		Node(T datum) {
			//TODO, set data to datum and leave next null
			// (this constructor will not be called if datum is null)
			data = datum;
		}
		Node(T datum, Node link) {
			//TODO, set data to datum and sete next to link
			// (this constructor will not be called with datum null)
			data = datum;
			next = link;
		}
			public void append(T datum) {
			//TODO, if next is null change it to a new Node with datum as its data field
     	 // otherwise call append on next with the argument datum
			// (this method will not be called with datum null)
			if (next == null)
				next = new Node(datum);
			else {
				next.append(datum);
			}
		}
		
		public void print() {
			//TODO, use System.out.print to print data followed by a space
			// if next is not null call print on next
			System.out.print(data + " ");
			if (next != null)
				next.print();
		}
		public boolean find(T datum) {
			//TODO, if data equals (not ==) datum return true
			// if next is null return false (no else needed after a return)
			// return the call to find(datum) on next (no else needed after a return)
			if (data.equals(datum))
				return true;
			if (next == null)
				return false;
			return next.find(datum);
		}
		public Node remove(T datum) {
			//TODO, find(datum) is false (use the ! operator) return this
			// if data equals datum return next (no else needed after a return)
			// assign next to the call to remove(datum) on next (no else needed after a return)
			// return this
			if (!find(datum))
				return this;
			if (data.equals(datum))
				return next;
			next = next.remove(datum);
			return this;
		}		
	}

	private Node list; // a MyList object wraps a Node "list" and the linked 
	// chain of nodes it links to

	public MyList () {
	} // this constructor leaves list null
	public MyList (T datum) {
		//TODO, make list a new Node containing datum using the first Node constructor 
		// but if datum is null, do nothing
		if (datum == null);
		else
			list = new Node(datum);
	}
	public MyList (T datum, MyList<T> myList) {
		//TODO, make list a new Node with data set to datum and with next set to myList using the second Node constructor 
		// but if datum is null, make list a new Node with data set to myList.data and
		// next set to myList.next using the second Node constructor
		if (datum == null && myList == null)
			throw new IllegalArgumentException("Both arguments cannot be null");
		if (myList == null)
			list = new Node(datum);
		else if (datum == null) {
			list = myList.list;
		}
		else {
			list = new Node(datum, myList.list);
		}
	}
	public void append (T datum) {
		//TODO if list is null change it to a new Node containing datum
		// otherwise call append datum on list
		// if datum is null do nothing
		if (datum == null);
		else if (list == null)
			list = new Node(datum);
		else
			list.append(datum);
	}
	public boolean find(T datum) {
		//TODO if list is null return false
		// if datum is null return false
		// return the call to find datum on list (else not needed after return)
		if (list == null)
			return false;
		if (datum == null)
			return false;
		return list.find(datum);
	}
	public boolean remove(T datum) {
		//TODO if datum is null just return false
		// if calling find datum (the method just above this one) returns false (use the ! operator) return false
		// change list to the call of remove(datum) on list (else not needed after return)
		// return true
		if (datum == null)
			return false;
		if (!find(datum))
			return false;
		list = list.remove(datum);
		return true;
	}
	public void print() {
		//TODO if list is null print "empty" using println
		// otherwise call print(0) in list and then call
		// System.out.println() to get a new-line
		if (list == null)
			System.out.println("empty");
		else {
			list.print();
			System.out.println();
		}
	}
	public boolean isEmpty() {
		return list==null;
	}
	public T head() {
		return list.data;
	}
	public MyList<T> tail (){
		MyList<T> temp = new MyList<T>();
		temp.list = list.next;
		return temp;
	}
	public static int sum(MyList<Integer> list) 
	{
		if(list.isEmpty()) return 0;
		return list.head() + sum(list.tail());
	}
	
	public static void main(String[] args) {
		var test = new MyList<String>();
		test.print();
		test.append("A");
		test.append("G");
		test.append("J");
		test.append("D");
		test.append("N");
		test.append("K");
		test.append("T");
		test.append("S");
		test.append("A");
		test.append("V");
		test.print();
		System.out.println(test.find("X"));
		System.out.println(test.remove("X"));
		test.print();
		System.out.println(test.find("V"));
		System.out.println(test.remove("V"));
		test.print();
		System.out.println(test.find("K"));
		System.out.println(test.remove("K"));
		test.print();
		System.out.println(test.find("A"));
		System.out.println(test.remove("A"));
		test.print();
		System.out.println(test.find("A"));
		System.out.println(test.remove("A"));
		test.print();
		System.out.println(test.find("D"));
		System.out.println(test.remove("D"));
		test.print();
		System.out.println(test.find("J"));
		System.out.println(test.remove("J"));
		test.print();
		System.out.println(test.find("G"));
		System.out.println(test.remove("G"));
		test.print();
		System.out.println(test.find("N"));
		System.out.println(test.remove("N"));
		test.print();
		System.out.println(test.find("S"));
		System.out.println(test.remove("S"));
		test.print();
		System.out.println(test.find("T"));
		System.out.println(test.remove("T"));
		test.print();
		System.out.println(test.find("D"));
		System.out.println(test.remove("D"));
		test.print();
		test = new MyList<String>("X");
		test.print();
		test.append("A");
		test.append("G");
		test.append("J");
		test.append("D");
		test.append("N");
		test.append("K");
		test.append("T");
		test.print();
		var test1 = new MyList<String>("B", test);
		test1.print();
		var test2 = new MyList<String>("B", null);
		test2.print();
		var list = new MyList<Integer>();
		list.append(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(5);
		list.append(6);
		System.out.print("List is: ");
		list.print();
		System.out.println("Sum is: " + sum(list));
		System.out.print("Now list is: ");
		list.print();
		System.out.println("and sum is: " + sum(list));
	}
}
