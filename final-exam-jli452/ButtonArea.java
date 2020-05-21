package finalexam;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class ButtonArea extends JPanel {
	private JFrame frame; 
	private GraphComponent component;
	private JTextField multiplier = new JTextField(10);
	private JTextField rotation = new JTextField(10);
	public ButtonArea(JFrame frame, GraphComponent component) {
		this.frame = frame;
		this.component = component;
		
		setLayout(new GridLayout(3,0));
		this.add(new JLabel("THERE IS NO ERROR CHECKING", SwingConstants.CENTER));
		JPanel panel1 = new JPanel();
		this.add(panel1);
		panel1.add(new JLabel("Change length by this multiplier (a double): "));
		panel1.add(multiplier);
		JPanel panel2 = new JPanel();
		this.add(panel2);
		panel2.add(new JLabel("Rotate by this amount (a double): "));
		panel2.add(rotation);
		// TODO write the lambda expressions to call component.multiply and component.rotate, respectively
		// Note if txt is a JTextField, text.getText() returns the String that is typed into the JTextField.
		// Note Double.parseDouble(str) converts the String str to a double, e.g it converts "21.5" to the 
		// double 21.5
		multiplier.addActionListener(e -> {
			component.multiply(Double.parseDouble(multiplier.getText()));
		}); // e is actually the ActionEvent of the JTextField
		rotation.addActionListener(e -> {
			component.rotate(Double.parseDouble(rotation.getText()));
		});  // it is not used in the TODO part
	}

}
