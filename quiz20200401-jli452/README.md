# quiz20200401

Do all the TODOs in MyList.java above. The main method provides a test. I will use a JUnit to grade (not provided but just checks what the main method does)

Then
Make a file MyOrderedList.java containing the class
public class MyOrderedList<T extends Comparable<? super T>>

Change "void append" in Node to "public Node insert(T datum)" which must keep the list in increasing order
using the "compareTo". However, if datum is already in the the linked list using the "equals" method, 
then datum is NOT inserted a second time but it if datum.compareTo(data) and (!datum.equals(data)) you
must put datum in the linked list after the Node containg data.

Change the corresponding append in MyOrderedList to insert

NOTE: I will post the guidance for writing insert on Piazza because I have not got my code working yet.
