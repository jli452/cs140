package assignment06;

public class Triangle extends GraphicObject
{
	public Triangle(double[] pts)
	{
		super(pts);
	}
	
	protected RuntimeException checkForExceptions(double[] pts)
	{
		if (pts == null || pts.length != 6)
			return new IllegalArgumentException("argument must have length 6");
		if (pts[0]*pts[3] + pts[2]*pts[5] + pts[4]*pts[1] - pts[1]*pts[2] - pts[3]*pts[4] - pts[5]*pts[0] == 0)
			return new IllegalArgumentException("points must give non-zero area");
		return null;
	}

	public void move(double dx, double dy)
	{
		double[] values = getReferenceValues();
		values[0] += dx;
		values[2] += dx;
		values[4] += dx;
		values[1] += dy;
		values[3] += dy;
		values[5] += dy;
	}
}
