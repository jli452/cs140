package quiz20200316;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonStudentTester {
	
	Person[] pArray = new Person[6];
	Student[] sArray = new Student[6];
	@BeforeEach
	void setUp() throws Exception {
		pArray[0] = new Person ("Alberston", "Mary", 2005, 5, 15);
		pArray[1] = new Person ("Bennett", "Anne", 2000, 4, 10);
		pArray[2] = new Person ("Bennett", "Jane", 2000, 8, 1);
		pArray[3] = new Person ("Alberston", "Brian", 2005, 5, 15);
		pArray[4] = new Person ("Bennett", "Anne", 2005, 5, 15);
		pArray[5] = new Person ("Alberston", "Mary", 2005, 5, 15);
		
		sArray[0] = new Student (pArray[0], "Philosophy", 3.7);
		sArray[1] = new Student (pArray[1], "Physics", 3.5);
		sArray[2] = new Student (pArray[2], "History", 3.5);
		sArray[3] = new Student (pArray[3], "German", 3.7);
		sArray[4] = new Student (pArray[4], "English", 3.5);
		sArray[5] = new Student (pArray[5], "Art", 3.7);
	}

	@Test
	void testPersonCompareTo1() {
		assertTrue(pArray[0].compareTo(pArray[1]) > 0);
	}
	@Test
	void testPersonCompareTo2() {
		assertTrue(pArray[0].compareTo(pArray[3]) > 0);
	}
	@Test
	void testPersonCompareTo3() {
		assertTrue(pArray[0].compareTo(pArray[4]) < 0);
	}
	@Test
	void testPersonCompareTo4() {
		assertTrue(pArray[0].compareTo(pArray[5]) == 0);
	}
	@Test
	void testPersonCompareTo5() {
		assertTrue(pArray[0].compareTo(pArray[4]) < 0);
	}
	@Test
	void testStudentCompareTo1() {
		assertTrue(sArray[0].compareTo(sArray[1]) > 0);
	}
	@Test
	void testStudentCompareTo2() {
		assertTrue(sArray[0].compareTo(sArray[3]) > 0);
	}
	@Test
	void testStudentCompareTo3() {
		assertTrue(sArray[0].compareTo(sArray[4]) > 0);
	}
	@Test
	void testStudentCompareTo4() {
		assertTrue(sArray[0].compareTo(sArray[5]) == 0);
	}
	@Test
	void testStudentCompareTo5() {
		assertTrue(sArray[1].compareTo(sArray[2]) < 0);
	}
	@Test
	void testStudentCompareTo6() {
		assertTrue(sArray[0].compareTo(sArray[4]) > 0);
	}
	@Test
	void testClone1() {
		Person p = pArray[0].clone();
		assertAll (
				() -> assertEquals(pArray[0].getLastNames(),p.getLastNames()),
				() -> assertEquals(pArray[0].getFirstNames(),p.getFirstNames()),
				() -> assertEquals(pArray[0].getDateOfBirth(),p.getDateOfBirth())
				);
	}
	@Test
	void testClone2() {
		Student s = sArray[0].clone();
		assertAll (
				() -> assertEquals(sArray[0].getAsPerson().getLastNames(),s.getAsPerson().getLastNames()),
				() -> assertEquals(sArray[0].getAsPerson().getFirstNames(),s.getAsPerson().getFirstNames()),
				() -> assertEquals(sArray[0].getAsPerson().getDateOfBirth(),s.getAsPerson().getDateOfBirth()),
				() -> assertEquals(sArray[0].getMajor(),s.getMajor()),
				() -> assertEquals(sArray[0].getGpa(),s.getGpa())
				);
	}
}