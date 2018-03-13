package intro_to_array_lists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other
	// button reads "View Names".
	// When the add name button is clicked, display an input dialog that asks the
	// user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a
	// message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	public static void main(String[] args) {
		GuestBook elRegistroDeHuespedes = new GuestBook();
	}

	JFrame frame;
	JPanel panel;
	JButton addName;
	JButton viewNames;
	ArrayList<String> names;

	public GuestBook() {
		frame = new JFrame();
		panel = new JPanel();
		addName = new JButton("Add Names");
		viewNames = new JButton("View Names");
		names = new ArrayList<String>();
		run();
	}

	void run() {
		addName.addActionListener(this);
		viewNames.addActionListener(this);
		panel.add(addName);
		panel.add(viewNames);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == viewNames) {
			String s = "";
			for (int i = 0; i < names.size(); i++) {
				s += "Guest " + (i + 1) + ": " + names.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, s);
		}
		if (e.getSource() == addName) {
			String name = JOptionPane.showInputDialog("What name would you like to add?");
			names.add(name);

		}
	}
}
