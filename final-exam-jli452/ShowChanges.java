package finalexam;
import java.awt.BorderLayout;

import javax.swing.JFrame;
public class ShowChanges {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		GraphComponent comp = new GraphComponent(100, 100);
		frame.setSize(400, 550);
		frame.setTitle("Move Line");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(comp);
		frame.add(new ButtonArea(frame, comp), BorderLayout.PAGE_END);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
