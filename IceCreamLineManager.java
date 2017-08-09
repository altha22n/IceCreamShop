import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class acts as the controller for the icecreamline class it extends
 * JComponent and implements ActionListener
 * 
 * @author Nada-Al-Thawr
 *
 */

public class IceCreamLineManager extends JComponent implements ActionListener {
	// create an instance of icecreamline class
	IceCreamLine line = new IceCreamLine();
	// create a new frame
	JFrame myFrame = new JFrame("Ice Cream Line!");
	// and a new JPanel
	JPanel myPanel = new JPanel();

	/**
	 * constructor
	 */
	public IceCreamLineManager() {
		//add the new order button to the panel and put it in the north
		myPanel.add(createNewOrderButton(), BorderLayout.NORTH);
		//add the remove button to the panel and place it in the center 
		myPanel.add(createRemoveNextButton(), BorderLayout.CENTER);
		//add the panel to the frame 
		myFrame.add(myPanel, BorderLayout.NORTH);
		//set the frame's size
		myFrame.setSize(400, 500);
		//add the line to the frame 
		//we can do that because our icecreamline class extends box
		myFrame.add(line, BorderLayout.CENTER);
		//exit on close
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set it to be visible
		myFrame.setVisible(true);

	}

	public void addControls() {

	}
	/**
	 * creates the newOrderButton
	 * @return JButton
	 */
	public JButton createNewOrderButton() {
		//create the button
		JButton newOrderButton = new JButton("Add a random order");
		//add action listener 
		newOrderButton.addActionListener(this);
		//and return it
		return newOrderButton;

	}
	/**
	 * creates the removeNextButton
	 * @return JButton
	 */
	public JButton createRemoveNextButton() {
		//create the button
		JButton removeNextButton = new JButton("Serve the next order");
		//add action listener
		removeNextButton.addActionListener(this);
		//and return it
		return removeNextButton;
	}
	/**
	 * to listen to the mouse clicks
	 */
	public void actionPerformed(ActionEvent e) {
		//we create a new string  that gets action command
		String action = e.getActionCommand();
		//we use action.equals because we are dealing with strings
		//if it equals to the text in newOrderButton 
		if (action.equals("Add a random order")) {
			System.out.println("pls work");
			//we call addRandomOrder in the IceCreamLine class
			line.addRandomOrder();

		}
		//if it equals to the text in removeNextButton
		if (action.equals("Serve the next order")) {
			//call deleteOrder in the IceCreamLine class
			line.deleteOrder();

		}

	}
}
