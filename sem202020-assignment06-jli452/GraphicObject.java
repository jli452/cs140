package assignment06;

public abstract class GraphicObject
{
	private double[] referenceValues;

	protected abstract RuntimeException checkForExceptions(double[] pts);
	public abstract void move(double dx, double dy);
	public GraphicObject (double[] pts)
	{
		if (checkForExceptions(pts) != null)
			throw checkForExceptions(pts);
		referenceValues = pts;
	}
	public double[] getReferenceValues()
	{
		return referenceValues;
	}
}
