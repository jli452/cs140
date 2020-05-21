package assignment06;

public class Rectangle extends GraphicObject
{
	public Rectangle(double[] pts)
	{
		super(pts);
	}
	protected RuntimeException checkForExceptions(double[] pts)
	{
		if (pts == null || pts.length !=4)
			return new IllegalArgumentException("argument must have length 4");
		if (pts[0] >= pts[2] || pts[1] >= pts[3])
			return new IllegalArgumentException("top left, bottom right out of position");
		return null;
	}
	public void move(double dx, double dy)
	{
		double[] values = getReferenceValues();
		values[0] += dx;
		values[2] += dx;
		values[1] += dy;
		values[3] += dy;
	}
}
