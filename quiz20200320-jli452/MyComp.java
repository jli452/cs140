package quiz20200320;
import java.util.Comparator;
public class MyComp implements Comparator<RadioStation> {

	@Override
	public int compare(RadioStation arg0, RadioStation arg1) {
		// TODO
	    // all enums are Comparable, so the first retVal is arg0.getFormat().compareTo(arg1.getFormat())
	    // if that is zero the value is changed to the same compareTo but replacing getFormat by getBand
	    // if retVal is still zero return Float.compare with the arguments arg0.getFreq() and arg1.getFreq()
	    int retVal = 0;
	    retVal = arg0.getFormat().compareTo(arg1.getFormat());
	    if (retVal == 0)
	    	retVal = arg0.getBand().compareTo(arg1.getBand());
	    if (retVal == 0)
	    	return Float.compare(arg0.getFreq(), arg1.getFreq());
		return retVal;
	}
}
