import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

/**
 * This class acts as the controller of the ice cream application it extends
 * JPanel and implements Action Listener
 * 
 * @author Nada-Al-Thawr
 *
 */
public class IceCreamMaker extends JPanel implements ActionListener {
	/**
	 * @param cone
	 *            , which is an instant of the ice cream cone class
	 * @param vanButton
	 *            , JButton
	 * @param chocolateButton
	 *            , JButton
	 * @param strawButton
	 *            , JButton
	 * @param teaButton
	 *            , JButton
	 * @param trashButton
	 *            , JButton
	 * @param randomButton
	 *            , JButton
	 */
	IceCreamCone cone = new IceCreamCone();
	JButton vanButton;
	JButton chocolateButton;
	JButton strawButton;
	JButton teaButton;
	JButton trashButton;
	JButton randomButton;

	/**
	 * constructor
	 */
	public IceCreamMaker() {
		// call super
		super(new BorderLayout());
		// create a new icecreamcone
		
		// call make button
		makeButton();
		// add make button to the north of the border layout
		add(makeButton(), BorderLayout.NORTH);
		// add the cone to the center of the border layout
		add(cone, BorderLayout.CENTER);

	}

	/**
	 * makeButton, makes all the buttons
	 * 
	 * @return JPanel
	 */

	public JPanel makeButton() {
		// two new grid layouts for the flavor buttons and the trash button
		GridLayout buttonGrid = new GridLayout(1, 5);
		GridLayout trashGrid = new GridLayout(1, 1);
		// create three panels for both the grids
		// and the main panel they're both added to
		JPanel myPanel = new JPanel(buttonGrid);
		JPanel trashPanel = new JPanel(trashGrid);
		JPanel thePanel = new JPanel(new BorderLayout());
		// add the grid panels to the main panel
		thePanel.add(myPanel, BorderLayout.NORTH);
		thePanel.add(trashPanel, BorderLayout.SOUTH);
		// create the trash button, set the color and show it
		trashButton = new JButton("Eat the heart out of your scoop!");
		trashButton.setBackground(Color.cyan);
		trashButton.setOpaque(true);

		// create the vanilla button, set the color and show it
		vanButton = new JButton("vanilla");
		vanButton.setBackground(Color.white);
		vanButton.setOpaque(true);

		// create the tea button, set the color and show it
		teaButton = new JButton("Green Tea");
		teaButton.setBackground(Color.green);
		teaButton.setOpaque(true);

		// create the strawberry button, set the color and show it
		strawButton = new JButton("strawberry");
		strawButton.setBackground(Color.pink);
		strawButton.setOpaque(true);

		// create the chocolate button, set the color and show it
		chocolateButton = new JButton("chocolate");
		chocolateButton.setBackground(Color.orange);
		chocolateButton.setOpaque(true);

		// create the random button, set the color and show it
		randomButton = new JButton("Random");
		randomButton.setBackground(Color.YELLOW);
		randomButton.setOpaque(true);

		myPanel.add(vanButton);
		myPanel.add(teaButton);
		myPanel.add(strawButton);
		myPanel.add(chocolateButton);
		myPanel.add(randomButton);
		trashPanel.add(trashButton);

		// implement action listener for the buttons
		vanButton.addActionListener(this);
		strawButton.addActionListener(this);
		teaButton.addActionListener(this);
		chocolateButton.addActionListener(this);
		trashButton.addActionListener(this);
		randomButton.addActionListener(this);

		// return the main panel
		return thePanel;

	}

	/*
	 * To make the buttons do what they are supposed to Call the addFlavor
	 * method for each
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vanButton) {
			// the vanilla button adds vanilla flavor
			cone.addFlavor("vanilla");
		}

		if (e.getSource() == chocolateButton) {
			// the chocolate button adds chocolate flavor
			cone.addFlavor("chocolate");
		}

		if (e.getSource() == teaButton) {
			// the tea button adds tea flavor
			cone.addFlavor("tea");
		}

		if (e.getSource() == strawButton) {
			// the strawbutton adds strawberry flavor
			cone.addFlavor("strawberry");
		}

		if (e.getSource() == trashButton) {
			// the trash button deletes the scoop
			cone.deleteScoop();

		}
		if (e.getSource() == randomButton) {
			// the random button adds random scoops
			cone.addRandomScoop();

		}

	}
}
