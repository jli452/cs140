package assignment05;

public class Point
{
	private double x;
	private double y;

	public Point(double inputX, double inputY)
	{
		if (inputX < 0 || inputY < 0)
			throw new IllegalArgumentException("points must be non-negative");
		x = inputX;
		y = inputY;
	}

	public double getX()
	{
		return x;
	}
	public double getY()
	{
		return y;
	}

	public String toString()
	{
		return "(" + x + ", " + y + ")";
	}
}
