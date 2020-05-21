package quiz20200323;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.swing.JPanel;

public class SelectionArea extends JPanel {

	private static final long serialVersionUID = 2921334465396158425L;
	private Rectangle2D.Double currentRect = new Rectangle2D.Double();
	private Rectangle2D.Double rectToDraw = new Rectangle2D.Double();
	private Rectangle2D.Double previousRectDrawn = new Rectangle2D.Double();	
	private SelectionDemo controller;
	private boolean movingMode;
	private boolean printAll;
	private boolean draggingFigure;
	private int baseOfMoveMouseX;
	private int baseOfMoveMouseY;
	private double baseOfMoveRectX;
	private double baseOfMoveRectY;
	private List<Rectangle2D.Double> list;

	public SelectionArea(SelectionDemo controller, 
			List<Rectangle2D.Double> list) {
		this.controller = controller;    
		this.list = list;
		//TODO setBackground(Color.BLACK); or choose your own color
		// the basic colors are here
		// https://docs.oracle.com/en/java/javase/12/docs/api/java.desktop/java/awt/Color.html
		// or you cna use RGB values with new Color(r, g, b)--values 0-255
		setBackground(Color.YELLOW);
		addMouseListener(MouseListenerFactory.mousePressedHandler( e -> {
			printAll = false;
			int x = e.getX();// TODO use getX() applied ot e
			int y = e.getY();// TODO similarly use getY
			if (movingMode) {
				if(currentRect.contains(x, y)) {
					//TODO: change draggingFigure to true
					// set  baseOfMoveMouseX to x
					// and  baseOfMoveMouseY to y
					// and  baseOfMoveRectX to currentRect.x
					// and  baseOfMoveRectY to currentRect.y
					draggingFigure = true;
					baseOfMoveMouseX = x;
					baseOfMoveMouseY = y;
					baseOfMoveRectX = currentRect.x;
					baseOfMoveRectY = currentRect.y;
				}
			} else {
				currentRect.setRect(x, y, 0, 0);
				updateDrawableRect(getWidth(), getHeight());
				repaint();
			}
		}));
		addMouseListener(MouseListenerFactory.mouseReleasedHandler(e -> {
			if(movingMode) {
				if(draggingFigure) {
					//TODO: 
					// call	updatePosition(e)
					// add a new Rectangle2D.Double with arguments
					// rectToDraw.x, rectToDraw.y, 
					// rectToDraw.width - 1, rectToDraw.height - 1
					// to list
					updatePosition(e);
					list.add(new Rectangle2D.Double(rectToDraw.x, rectToDraw.y, rectToDraw.width-1, rectToDraw.height-1));

				}
			} else {
				updateSize1(e);
			}
			//TODO: toggle the value od movingMode using
			// movingMode = !movingMode;
			// set draggingFigure to false
			movingMode = !movingMode;
			draggingFigure = false;
		}));

		addMouseMotionListener(MouseListenerFactory.mouseDraggedHandler(e -> {
			if(movingMode) {
				if(draggingFigure) {
					updatePosition(e);
				}
			} else {
				updateSize(e);			
			}
		}));
	}

	public void setPrintAll(boolean printAll) {
		this.printAll = printAll;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g); //paints the background and image
		//Cast the Graphics context to Graphics2D
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(4));
		if(printAll) {
			for(Rectangle2D.Double r : list) {
				//TODO try with my colors and then change to your prefences
				// see line 32 above for colors
				Color color1 = Color.RED;
						g2.setColor(color1);
						g2.fill(r);
						Color color = Color.GREEN;
						g2.setColor(color);
						g2.draw(r);			
			}
		} else {
			Rectangle2D.Double temp = new Rectangle2D.Double(
					rectToDraw.x, rectToDraw.y, 
					rectToDraw.width - 1, rectToDraw.height - 1);
			Color color1 = Color.RED;
			g2.setColor(color1);
			g2.fill(temp);

			Color color = Color.GREEN;
			g2.setColor(color);
			g2.draw(temp);
			controller.updateLabel(rectToDraw);
		}
	}

	public void updateDrawableRect(int compWidth, int compHeight) {
		double x = currentRect.x;
		double y = currentRect.y;
		double width = currentRect.width;
		double height = currentRect.height;

		//Make the width and height positive, if necessary.
		if (width < 0) {
			width = 0 - width;
			x = x - width + 1; 
			if (x < 0) {
				width += x; 
				x = 0;
			}
		}
		if (height < 0) {
			height = 0 - height;
			y = y - height + 1; 
			if (y < 0) {
				height += y; 
				y = 0;
			}
		}

		//The rectangle shouldn't extend past the drawing area.
		if ((x + width) > compWidth) {
			width = compWidth - x;
		}
		if ((y + height) > compHeight) {
			height = compHeight - y;
		}

		//Update rectToDraw after saving old value.
		if (rectToDraw != null) {
			previousRectDrawn.setFrame(
					rectToDraw.x, rectToDraw.y, 
					rectToDraw.width, rectToDraw.height);
			rectToDraw.setFrame(x, y, width, height);
		} else {
			rectToDraw = new Rectangle2D.Double(x, y, width, height);
		}
	}


	void updateSize(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		currentRect.setRect(currentRect.x, currentRect.y,
				x - currentRect.x, y - currentRect.y);
		updateDrawableRect(getWidth(), getHeight());
		Rectangle2D.Double totalRepaint = new Rectangle2D.Double(); 
		Rectangle2D.Double.union(rectToDraw, previousRectDrawn, totalRepaint);
		repaint((int)totalRepaint.x-4, (int)totalRepaint.y-4,
				(int)totalRepaint.width+5, (int)totalRepaint.height+5);
	}

	void updateSize1(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		double topLeftX = Math.min(x, currentRect.x);
		double topLeftY = Math.min(y, currentRect.y);
		double wid = Math.abs(x - currentRect.x);
		double ht = Math.abs(y - currentRect.y);

		currentRect.setRect(topLeftX, topLeftY, wid, ht);
		updateDrawableRect(getWidth(), getHeight());
		Rectangle2D.Double totalRepaint = new Rectangle2D.Double(); 
		Rectangle2D.Double.union(rectToDraw, previousRectDrawn, totalRepaint);
		repaint((int)totalRepaint.x-4, (int)totalRepaint.y-4,
				(int)totalRepaint.width+5, (int)totalRepaint.height+5);
	}

	void updatePosition(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int dispX = x - baseOfMoveMouseX;
		int dispY = y - baseOfMoveMouseY;
		currentRect.setRect(baseOfMoveRectX + dispX, baseOfMoveRectY + dispY,
				currentRect.width, currentRect.height);
		updateDrawableRect(getWidth(), getHeight());
		Rectangle2D.Double totalRepaint = new Rectangle2D.Double(); 
		Rectangle2D.Double.union(rectToDraw, previousRectDrawn, totalRepaint);
		repaint((int)totalRepaint.x-4, (int)totalRepaint.y-4,
				(int)totalRepaint.width+5, (int)totalRepaint.height+5);
	}
}
