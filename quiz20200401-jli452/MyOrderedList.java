package quiz20200401;

import java.util.ArrayList;

//import quiz20200401.MyList.Node;

public class MyOrderedList<T extends Comparable<? super T>> {
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
		/**public void append(T datum) {
			//TODO, if next is null change it to a new Node with datum as its data field
			// otherwise call append on next with the argument datum
			// (this method will not be called with datum null)
			if (next == null)
				next = new Node(datum);
			else {
				next.append(datum);
			}
		}*/

		public Node insert(T datum) {
			int diff = data.compareTo(datum);
			if(diff < 0) {
				if (next == null)
					next = new Node(datum);
				else
					next = next.insert(datum);
				return this;
			}
			if (diff > 0)
				return new Node(datum, this);
			if (diff == 0 && datum.equals(data))
				return this;
			if (next == null)
				next = new Node(datum);
			else
				next = next.insert(datum);
			return this;
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
			if(datum.compareTo(data) < 0)
				return false;
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

	public MyOrderedList () {
	} // this constructor leaves list null
	public MyOrderedList (T datum) {
		//TODO, make list a new Node containing datum using the first Node constructor 
		// but if datum is null, do nothing
		if (datum == null);
		else
			list = new Node(datum);
	}
	public MyOrderedList (T datum, MyOrderedList<T> myList) {
		if (datum == null && myList == null)
			throw new IllegalArgumentException("Both arguments cannot be null");
		if (myList == null)
			list = new Node(datum);
		else if (datum == null)
			list = myList.list;
		else if (datum.compareTo(myList.list.data) > 0)
			list = new Node(myList.list.data, myList.list.next.insert(datum));
		else
			list = new Node(datum, myList.list);
	}
	public void insert (T datum) {
		if (datum != null) {
			if (list == null)
				list = new Node(datum);
			else
				list = list.insert(datum);
		}
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


	public static void main(String[] args) {
		var test = new MyOrderedList<BankAccount>();
		test.print();
		int[] initBal = {100, 120, 140, 100, 115, 80, 155, 70, 140, 111};
		var list = new ArrayList<BankAccount>();
		for(int bal : initBal) list.add(new BankAccount(bal));
		for(int i = 0; i < 10; i++) {
			test.insert(list.get(i));
			test.print();
		}
		test.insert(list.get(4)); // does not insert, a repeat
		test.print();		
		System.out.println(test.find(new BankAccount(100)));
		System.out.println(test.remove(new BankAccount(100)));
		test.print();
		int[] removeOrder = {0, 7, 8, 1, 6, 3, 5, 2, 9, 4};
		for(int i = 0; i < 10; i++) {
			System.out.println(test.find(list.get(removeOrder[i])));
			System.out.println(test.remove(list.get(removeOrder[i])));
			test.print();
		}
		BankAccount.resetNextId();
		test = new MyOrderedList<BankAccount>(list.get(0));
		test.print();
		for(int i = 1; i < 6; i++) {
			test.insert(list.get(i));
			test.print();
		}
		test.print();
		var test1 = new MyOrderedList<BankAccount>(list.get(6), test);
		test1.print();
		var test2 = new MyList<BankAccount>(list.get(7), null);
		test2.print();
	}
}
