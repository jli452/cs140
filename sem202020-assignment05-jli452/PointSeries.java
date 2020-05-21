package assignment05;
import java.util.ArrayList;
import java.util.List;

public class PointSeries
{
	private List<Point> points = new ArrayList<>();

	public void addPoint(Point point)
	{
		points.add(point);
	}
	
	public Point findCenter()
	{
		boolean isNull = true;
		for (int i = 0; i < points.size(); i++)
		{
			if (points.get(i) != null)
			{
				isNull = false;
				break;
			}
		}
		if (points.size() == 0 || isNull)
			return new Point(0, 0);
		double xBar = 0;
		double yBar = 0;
		double dividingOver = 0;
		for (int i = 0; i < points.size(); i++)
		{
			if (points.get(i) == null)
				continue;
			xBar += points.get(i).getX();
			yBar += points.get(i).getY();
			dividingOver++;
		}
		return new Point(xBar/dividingOver, yBar/dividingOver);
	}

	public void translate(int horz, int vert)
	{
		if (horz < 0 || vert < 0)
			throw new IllegalArgumentException("translations must be non-negative");
		double addX = horz;
		double addY = vert;
		for (int i = 0; i < points.size(); i++)
		{
			if (points.get(i) == null)
			{
				continue;
			}
			points.set(i, new Point(points.get(i).getX() + addX, points.get(i).getY() + addY));
		}
	}

	public String toString()
	{
		return "" + points;
	}
}
