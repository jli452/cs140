package assignment06;

public class Circle extends GraphicObject
{
	public Circle(double[] pts)
	{
		super(pts);
	}
	
	protected RuntimeException checkForExceptions(double[] pts)
	{
		if (pts == null || pts.length != 3)
			return new IllegalArgumentException("argument must have length 3");
		if (pts[2] <= 0)
			return new IllegalArgumentException("radius must be non-zero");
		return null;
	}

	public void move(double dx, double dy)
	{
		double[] values = getReferenceValues();
		values[0] += dx;
		values[1] += dy;
	}
}
