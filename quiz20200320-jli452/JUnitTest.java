package quiz20200320;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnitTest {

	@BeforeEach
	public void setUp() throws Exception {
	}

	@Test
	public void testMakeComp1() {
		Comparator<RadioStation> test = RadioStationDriver.makeComp();
		assertEquals("MyComp", test.getClass().getSimpleName());
	}
	@Test
	public void testMakeComp2() {
		Comparator<RadioStation> test = RadioStationDriver.makeComp();
		assertTrue(test.compare(new RadioStation("Test1", 90.9F, WaveBand.FM, 
				"Test3", Format.PUBLIC_RADIO, "WAXX"),
				new RadioStation("Test2", 900F, WaveBand.AM, 
						"Test4", Format.CLASSIC_HITS, "WAYY")) > 0);
	}

	@Test
	public void testMakeComp3() {
		Comparator<RadioStation> test = RadioStationDriver.makeComp();
		assertTrue(test.compare(new RadioStation("Test1", 90.9F, WaveBand.FM, 
				"Test3", Format.PUBLIC_RADIO, "WAXX"),
				new RadioStation("Test2", 91.0F, WaveBand.AM, 
						"Test4", Format.PUBLIC_RADIO, "WAYY")) > 0);
	}

	@Test
	public void testMakeComp4() {
		Comparator<RadioStation> test = RadioStationDriver.makeComp();
		assertTrue(test.compare(new RadioStation("Test1", 90.9F, WaveBand.FM, 
				"Test3", Format.PUBLIC_RADIO, "WAXX"),
				new RadioStation("Test2", 91.0F, WaveBand.FM, 
						"Test4", Format.PUBLIC_RADIO, "WAYY")) < 0);
	}

	@Test
	public void testMakeComp5() {
		Comparator<RadioStation> test = RadioStationDriver.makeComp();
		assertTrue(test.compare(new RadioStation("Test1", 91.0F, WaveBand.FM, 
				"Test3", Format.PUBLIC_RADIO, "WAXX"),
				new RadioStation("Test2", 91.0F, WaveBand.FM, 
						"Test4", Format.PUBLIC_RADIO, "WAYY")) == 0);
	}

	@Test
	public void testMakeComp6() {
		Comparator<RadioStation> test = RadioStationDriver.makeComp1();
		assertTrue(test.getClass().getName().startsWith("quiz20200320.RadioStationDriver$"));
	}
	@Test
	public void testMakeComp7() {
		Comparator<RadioStation> test = RadioStationDriver.makeComp1();
		assertTrue(test.compare(new RadioStation("Test1", 90.9F, WaveBand.FM, 
				"Test3", Format.PUBLIC_RADIO, "WAXX"),
				new RadioStation("Test2", 900F, WaveBand.AM, 
						"Test4", Format.CLASSIC_HITS, "WAYY")) > 0);
	}

	@Test
	public void testMakeComp8() {
		Comparator<RadioStation> test = RadioStationDriver.makeComp1();
		assertTrue(test.compare(new RadioStation("Test1", 90.9F, WaveBand.FM, 
				"Test3", Format.PUBLIC_RADIO, "WAXX"),
				new RadioStation("Test2", 91.0F, WaveBand.AM, 
						"Test4", Format.PUBLIC_RADIO, "WAYY")) > 0);
	}

	@Test
	public void testMakeComp9() {
		Comparator<RadioStation> test = RadioStationDriver.makeComp1();
		assertTrue(test.compare(new RadioStation("Test1", 90.9F, WaveBand.FM, 
				"Test3", Format.PUBLIC_RADIO, "WAXX"),
				new RadioStation("Test2", 91.0F, WaveBand.FM, 
						"Test4", Format.PUBLIC_RADIO, "WAYY")) < 0);
	}

	@Test
	public void testMakeComp10() {
		Comparator<RadioStation> test = RadioStationDriver.makeComp1();
		assertTrue(test.compare(new RadioStation("Test1", 91.0F, WaveBand.FM, 
				"Test3", Format.PUBLIC_RADIO, "WAXX"),
				new RadioStation("Test2", 91.0F, WaveBand.FM, 
						"Test4", Format.PUBLIC_RADIO, "WAYY")) == 0);
	}
	@Test
	public void testMakeComp11() {
		Comparator<RadioStation> test = RadioStationDriver.makeComp2();
		assertTrue(test.getClass().getName().startsWith("quiz20200320.RadioStationDriver$$Lambda$"));
	}
	@Test
	public void testMakeComp12() {
		Comparator<RadioStation> test = RadioStationDriver.makeComp2();
		assertTrue(test.compare(new RadioStation("Test1", 90.9F, WaveBand.FM, 
				"Test3", Format.PUBLIC_RADIO, "WAXX"),
				new RadioStation("Test2", 900F, WaveBand.AM, 
						"Test4", Format.CLASSIC_HITS, "WAYY")) > 0);
	}

	@Test
	public void testMakeComp13() {
		Comparator<RadioStation> test = RadioStationDriver.makeComp2();
		assertTrue(test.compare(new RadioStation("Test1", 90.9F, WaveBand.FM, 
				"Test3", Format.PUBLIC_RADIO, "WAXX"),
				new RadioStation("Test2", 91.0F, WaveBand.AM, 
						"Test4", Format.PUBLIC_RADIO, "WAYY")) > 0);
	}

	@Test
	public void testMakeComp14() {
		Comparator<RadioStation> test = RadioStationDriver.makeComp2();
		assertTrue(test.compare(new RadioStation("Test1", 90.9F, WaveBand.FM, 
				"Test3", Format.PUBLIC_RADIO, "WAXX"),
				new RadioStation("Test2", 91.0F, WaveBand.FM, 
						"Test4", Format.PUBLIC_RADIO, "WAYY")) < 0);
	}

	@Test
	public void testMakeComp15() {
		Comparator<RadioStation> test = RadioStationDriver.makeComp2();
		assertTrue(test.compare(new RadioStation("Test1", 91.0F, WaveBand.FM, 
				"Test3", Format.PUBLIC_RADIO, "WAXX"),
				new RadioStation("Test2", 91.0F, WaveBand.FM, 
						"Test4", Format.PUBLIC_RADIO, "WAYY")) == 0);
	}
	
}
