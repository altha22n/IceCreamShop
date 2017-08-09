import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class is the class that creates the icecreamshop and deals with its
 * methods and functionalities
 * 
 * @author Nada-Al-Thawr
 */
public class IceCreamShop extends JPanel implements ActionListener {
	// creating an instance of IceCreamCone
	IceCreamCone cone = new IceCreamCone();
	// instances of IceCreamLine and IceCreamMaker
	IceCreamLine line;
	IceCreamMaker maker;
	// int variable score, initialize it to 0
	int score = 0;
	// instances of the randbutton and serve button
	JButton randButton;
	JButton serveButton;
	JLabel scoreLabel;

	/**
	 * constructor
	 */
	public IceCreamShop() {
		// call super to inherit from the JPanel
		super(new BorderLayout());
		// initialize the IceCreamLine and IceCreamMaker instances
		line = new IceCreamLine();
		maker = new IceCreamMaker();

		// create all the panels
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel topPanel = new JPanel(new BorderLayout());
		JPanel firstPanel = new JPanel(new BorderLayout());
		JPanel secondPanel = new JPanel(new BorderLayout());
		JPanel scorePanel = new JPanel(new BorderLayout());

		// create all the JLabels
		JLabel instr = new JLabel(
				" Make IceCreamCone to match the order(at the top).");
		JLabel instr2 = new JLabel(
				" For every correct order, you get 10 points.");
		JLabel instr3 = new JLabel(" For every wrong order, you lose 5 points.");

		scoreLabel = new JLabel(" score: " + score);

		// add all the instructions to the top panel
		topPanel.add(instr, BorderLayout.NORTH);
		topPanel.add(instr2, BorderLayout.CENTER);
		topPanel.add(instr3, BorderLayout.SOUTH);
		scorePanel.add(scoreLabel, BorderLayout.CENTER);

		// add the top panel and the serve button to the first panel
		firstPanel.add(topPanel, BorderLayout.NORTH);
		firstPanel.add(scorePanel, BorderLayout.CENTER);
		firstPanel.add(serveNewButton(), BorderLayout.SOUTH);
		// add the line and random button to the second panel
		secondPanel.add(line, BorderLayout.CENTER);
		secondPanel.add(randomButton(), BorderLayout.NORTH);

		// then add the first panel, second panel and maker to the main panel
		mainPanel.add(firstPanel, BorderLayout.NORTH);
		mainPanel.add(secondPanel, BorderLayout.WEST);
		mainPanel.add(maker, BorderLayout.EAST);
		// and add the main panel to the super JPanel
		add(mainPanel, BorderLayout.CENTER);
	}

	/**
	 * method to create the randomButton
	 * 
	 * @return JButton
	 */
	private JButton randomButton() {
		// create the button
		randButton = new JButton("Create a random order!");
		// add action listener
		randButton.addActionListener(this);
		// and return it
		return randButton;

	}

	/**
	 * method to create the serveNewButton
	 * 
	 * @return JButton
	 */
	private JButton serveNewButton() {
		// create the button
		serveButton = new JButton("Serve new order");
		// resize it
		serveButton.setSize(new Dimension(600, 40));
		// add action listener
		serveButton.addActionListener(this);
		// and return it
		return serveButton;
	}

	/**
	 * method that serves by deleting both icecreams
	 */
	public void serve() {
		// if line has an ice cream in it
		if (line.hasOrder()) {
			// delete the order
			line.deleteOrder();
			// while the icecreamcone is not empty
			while (!maker.cone.iceCreamCone.isEmpty()) {
				// keep deleting the scoops
				maker.cone.deleteScoop();
			}

		}

	}

	/**
	 * updates the score
	 */
	private void updateScore() {
		// if matches for both cones returns true
		if (matches(maker.cone, line.newCone)==true) {
			// testing
			System.out.println("is this working?");
			// set the text to update
			scoreLabel.setText(" score: " + score);
			// increase the score by 10
			score += 10;
		} else
			// set the text to update
			scoreLabel.setText(" score: " + score);
		// else decrease by 5
		score -= 5;
	}

	/**
	 * 
	 * @param c1
	 * @param c2
	 * @return boolean
	 * 
	 *         This method didn't seem to be working, the logic makes sense to
	 *         me, but it doesn't work when we call it on update score
	 */
	public boolean matches(IceCreamCone c1, IceCreamCone c2) {
		// while first cone and second cone are not empty
		while (!c1.getStack().isEmpty() && !c2.getStack().isEmpty()) {
			// if the top scoop aren't equal, return false
			if (c1.iceCreamCone.peek() != c2.iceCreamCone.peek()) {
				return false;
			}
			// else if the top scoops are equal
			else if (c1.iceCreamCone.peek() == c2.iceCreamCone.peek()) {
				// pop from both cones
				c1.iceCreamCone.pop();
				c2.iceCreamCone.pop();
				// testing
				System.out.println("is this true");
				// return true
				return true;
			}

		}
		// if the one of them is empty, return false
		if (c1.getStack().isEmpty() && !c2.getStack().isEmpty()) {
			return false;
		}
		// if one of them is empty, return false
		if (!c1.getStack().isEmpty() && c2.getStack().isEmpty()) {
			return false;

		}

		return true;
	}

	/**
	 * Listens for mouse actions
	 */
	public void actionPerformed(ActionEvent e) {
		// create a string object that gets action commands
		String action = e.getActionCommand();
		// if the actions equals the text in randomButton
		if (action.equals("Create a random order!")) {
			// add random order
			line.addRandomOrder();
			// then validate and repaint
			validate();
			repaint();

		}
		//if the action equals the serveNewButton
		if (action.equals("Serve new order")) {
			//call serve
			//which means delete the cone from the queue and the scoops from the stack
			serve();
			//call update score
			updateScore();
			//validate and repaint
			validate();
			repaint();

		}

	}
}
