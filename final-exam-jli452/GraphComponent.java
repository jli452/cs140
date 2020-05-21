package finalexam;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class GraphComponent extends JComponent {
	private static final long serialVersionUID = -3637548029443088090L;
	private double ptX; 
	private double ptY;
	
	public GraphComponent(double x, double y) {
		this.ptX = x;
		this.ptY = y;
	}

	public double getPtX() {
		return ptX;
	}

	public double getPtY() {
		return ptY;
	}

	/** 
	 * multiplies otX and ptY by the multipler m and THEN
	 * CALLS repaint()
	 * @param m the multiplier
	 */
	public void multiply(double m) {
		// TODO
		ptX *= m;
		ptY *= m;
		repaint();
	}
	
	/**
	 * Converts the angle in degrees a to radians using
	 * a = Math.toRadians(a).
	 * Makes a copy tempX of ptX.
	 * Changes ptX to Math.cos(a) times ptX minus Math.siz(a) times ptY.
	 * Changes ptY to Math.sin(a) times tempX plus Math.cos(a) times ptY.
	 * THEN CALLS repaint()
	 * (You have just applied a matrix to a vector--linear algebra)
	 * @param
	 */
	public void rotate(double a) {
		a = Math.toRadians(a);
		double tempX = ptX;
		ptX = Math.cos(a) * ptX - Math.sin(a) * ptY;
		ptY = Math.sin(a) * tempX + Math.cos(a) * ptY;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {  
		super.paintComponent(g);
		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.BLACK);		
		g2.setStroke(new BasicStroke(2));
		g2.draw(new Line2D.Double(new Point2D.Double(200,0),
				new Point2D.Double(200,400)));
		g2.draw(new Line2D.Double(new Point2D.Double(0,200),
				new Point2D.Double(400, 200)));

		g2.setColor(Color.BLUE);
		g2.draw(new Line2D.Double(new Point2D.Double(200,200),
				new Point2D.Double(200+ptX, 200-ptY)));		
	}
}
