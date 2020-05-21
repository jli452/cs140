package quiz20200320;

import java.util.Arrays;
import java.util.Comparator;

public class RadioStationDriver {
	public static Comparator<RadioStation> makeComp() {
		return new MyComp();
	}
	public static Comparator<RadioStation> makeComp1() {
		return new Comparator<RadioStation>() {
			public int compare(RadioStation arg0, RadioStation arg1) {
				// TODO
				// cut and paste the body of the compare method of MyComp
				int retVal = 0;
			    retVal = arg0.getFormat().compareTo(arg1.getFormat());
			    if (retVal == 0)
			    	retVal = arg0.getBand().compareTo(arg1.getBand());
			    if (retVal == 0)
			    	return Float.compare(arg0.getFreq(), arg1.getFreq());
				return retVal;
			}
		};
	}
	public static Comparator<RadioStation> makeComp2() {
		return (arg0, arg1) -> {
			// TODO
			// cut and paste the body of the compare method of MyComp
			int retVal = 0;
		    retVal = arg0.getFormat().compareTo(arg1.getFormat());
		    if (retVal == 0)
		    	retVal = arg0.getBand().compareTo(arg1.getBand());
		    if (retVal == 0)
		    	return Float.compare(arg0.getFreq(), arg1.getFreq());
			return retVal;
		};
	}
	// the following is a full-scale lambda expression and 
	// Comparator-methods way of doing the methods above and I
	// will explain it in Monday's class, there is no TODO
	public static Comparator<RadioStation> makeComp3() {
		return Comparator.comparing(RadioStation::getFormat)
				.thenComparing(RadioStation::getBand)
				.thenComparingDouble(RadioStation::getFreq);
	}
	public static void main(String[] args) {
		RadioStation[] stations = {				
				new RadioStation("WAMC, Inc.", 90.9F, WaveBand.FM, 
						"Kingston", Format.PUBLIC_RADIO, "WAMK"),
				new RadioStation("Empire Broadcasting Corporation", 900F, WaveBand.AM, 
						"Watervleit", Format.CLASSIC_HITS, "WABY"),
				new RadioStation("Waynco Radio, Inc.", 1420F, WaveBand.AM, 
						"Newark", Format.NEWS_TALK_INFORMATION, "WACK"),
				new RadioStation("AMFM Radio Licenses, L.L.C.", 680F, WaveBand.AM, 
						"Binghamton", Format.CLASSIC_COUNTRY, "WINR"),
				new RadioStation("CC Licenses, LLC", 103.3F, WaveBand.FM, 
						"Vestal", Format.ADULT_CONTEMPORARY, "WMXW"),
				// TODO add a comma to the line above and make 3 more Radio Stations
				// from https://en.wikipedia.org/wiki/List_of_radio_stations_in_New_York
				// using only the formats coded in Format.java

		};

		RadioStation[] stations1 = stations.clone();
		RadioStation[] stations2 = stations.clone();
		RadioStation[] stations3 = stations.clone();

		for(RadioStation e : stations) {
			System.out.print(e + ", ");
		}
		System.out.println();
		Arrays.sort(stations, makeComp());
		for(RadioStation e : stations) {
			System.out.print(e + ", ");
		}
		System.out.println("\n---------------");

		for(RadioStation e : stations1) {
			System.out.print(e + ", ");
		}
		System.out.println();
		Arrays.sort(stations1, makeComp1());
		for(RadioStation e : stations1) {
			System.out.print(e + ", ");
		}
		System.out.println("\n---------------");

		for(RadioStation e : stations2) {
			System.out.print(e + ", ");
		}
		System.out.println();
		Arrays.sort(stations2, makeComp2());
		for(RadioStation e : stations2) {
			System.out.print(e + ", ");
		}
		System.out.println("\n---------------");

		for(RadioStation e : stations3) {
			System.out.print(e + ", ");
		}
		System.out.println();
		Arrays.sort(stations3, makeComp3());
		for(RadioStation e : stations3) {
			System.out.print(e + ", ");
		}
		System.out.println("\n---------------");
	}
}
