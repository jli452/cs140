package quiz20200323;
import java.awt.Component;
import java.awt.Container;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/* 
 * When the user drags within the area of the JFrame, 
 * this program displays a rectangle and a string
 * indicating the bounds of the rectangle.
 */

public class SelectionDemo {
	private JLabel label;
	private JButton drawAll;
	private JButton sort;
	private JButton align;
	private ArrayList<Rectangle2D.Double> list = new ArrayList<>();
	private Comparator<Rectangle2D.Double> comp = Comparator.comparingDouble(r -> r.getWidth()*r.getHeight());
	//TODO use Comparator.comparingDouble to make a Comparator
	// using the function r -> r.getWidth()*r.getHeight()

	private void buildUI(Container container) {
		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
		SelectionArea area = new SelectionArea(this, list);
		label = new JLabel("Drag within the image.");
		label.setLabelFor(area);
		container.add(label);
		container.add(area);
		drawAll = new JButton("Draw All");
		drawAll.addActionListener(
				e -> {
					area.setPrintAll(true);
					area.repaint();
				}
				//TODO a lambda expresion e -> {...}
				// where the ... calls the method setPrintAll(true) on area
				// and then calls the method repaint() on area
				);
		container.add(drawAll);
		sort = new JButton("Sort");
		sort.addActionListener(
				e -> {
					Collections.sort(list, comp);
					Collections.reverse(list);
					area.setPrintAll(true);
					area.repaint();
				}
				// TODO a lambda expresion e -> {...}
				// where the ... calls Collections.sort(list, comp)
				// then Collections.reverse(list);
				// then calls the method setPrintAll(true) on area
				// then calls the method repaint() on area
				);
		container.add(sort);
		align = new JButton("Align Left");
		align.addActionListener(e -> { double d = 0;
		Collections.sort(list, comp);
		for(var r : list) {
			r.setRect(0, d, r.getWidth(), r.getHeight());
			d += r.getHeight();
		}
		area.setPrintAll(true); 
		area.repaint();
		});
		container.add(align);
		area.setAlignmentX(Component.LEFT_ALIGNMENT);
	}


	public void updateLabel(Rectangle2D.Double rect) {
		double width = rect.width;
		double height = rect.height;
		//Make the coordinates look OK if a dimension is 0.
		if (width == 0) width = 1;
		if (height == 0) height = 1;
		label.setText("Rectangle area = " + (width*height) 
				+ ", perimeter = " + (2*width+2*height));
	}

	/**
	 * Create the GUI and show it. For thread safety, 
	 * this method should be invoked from the 
	 * event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		//Make sure we have nice window decorations.
		JFrame.setDefaultLookAndFeelDecorated(true);
		//Create and set up the window.
		JFrame frame = new JFrame("SelectionDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Set up the content pane.
		SelectionDemo controller = new SelectionDemo();
		controller.buildUI(frame.getContentPane());

		//Display the window.
		frame.setSize(600,600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(); 
			}
		});
	}
}
