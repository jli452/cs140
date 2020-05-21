package quiz20200320;
public class RadioStation {
	private String name;
	private float freq;
	private WaveBand band;
	private String licenseCity;
	private Format format;
	private String callSign;
	public RadioStation(String aName, float aFreq, WaveBand aBand, 
			String licCity, Format aFormat, String call) {
		name = aName;
		freq = aFreq;
		band = aBand;
		licenseCity = licCity;
		format = aFormat;
		callSign = call;
	}
	public String getName() {
		return name;
	}
	public float getFreq() {
		return freq;
	}
	public WaveBand getBand() {
		return band;
	}
	public String getLicenseCity() {
		return licenseCity;
	}
	public Format getFormat() {
		return format;
	}	
	public String callSign() {
		return callSign;
	}
	public String toString() {
		return String.format("%s: %.1f %s %s", format, freq, band, name);  
	}
}
