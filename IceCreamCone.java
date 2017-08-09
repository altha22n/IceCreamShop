import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Random;

import javax.swing.JComponent;

/**
 * This class acts as the model and view for our ice cream application It
 * extends JComponent
 * 
 * @author Nada-Al-Thawr
 *
 */
public class IceCreamCone extends JComponent {
	/**
	 * @param iceCreameCone
	 *            , which is our original stack
	 * @param tempStack
	 *            , which is our temp stack
	 * @param WIDTH
	 * 
	 * @param HEIGHT
	 * 
	 * @param diamScoop
	 *            , which is the size of the scoop
	 * @param overlapScoop
	 *            , which is the overlap size of our scoops
	 * @param brown
	 *            , which is a color
	 */
	public StackLL<String> iceCreamCone;
	public StackLL<String> tempStack;
	private static final int WIDTH = 30;
	private static final int HEIGHT = 40;
	private static final int diamScoop = 40;
	private static final int overlapScoop = 10;
	private Color brown = new Color(156, 93, 82);

	/**
	 * Constructor
	 */
	public IceCreamCone() {
		// create the original and temporary stacks
		iceCreamCone = new StackLL<String>();
		tempStack = new StackLL<String>();

	}

	/**
	 * paint method
	 * 
	 * @param g
	 *            , Graphics object
	 */
	public void paint(Graphics g) {
		// call paint cone and paint scoop
		paintCone(g);
		paintScoop(g);

	}

	/**
	 * paint cone method
	 * 
	 * @param g
	 *            , Graphics object
	 */
	public void paintCone(Graphics g) {
		System.out.println("print cone");
		Graphics2D graph = (Graphics2D) g;
		Polygon polygon = new Polygon();
		polygon.addPoint((getWidth() - WIDTH) / 2, getHeight() - HEIGHT);
		polygon.addPoint((getWidth() - WIDTH) / 2 + WIDTH, getHeight() - HEIGHT);
		polygon.addPoint((getWidth() - WIDTH) / 2 + (WIDTH / 2), getHeight());
		graph.setPaint(brown);
		graph.fill(polygon);
	}

	/**
	 * paint scoop method
	 * 
	 * @param g
	 *            , Graphics object
	 */
	public void paintScoop(Graphics g) {
		// set the number of scoops to 0 initially
		int scoopNum = 0;
		// while the original stack is not empty
		while (!iceCreamCone.isEmpty()) {
			// pop the original and push on the temp stack
			tempStack.push(iceCreamCone.pop());

		}
		// while the temp stack is not empty
		while (!tempStack.isEmpty()) {
			// our flavor is what's popped from temp stack
			String flavor = tempStack.pop();
			// if the flavor is vanilla
			if (flavor.equals("vanilla")) {
				// set the scoop color to white
				g.setColor(Color.white);
				// draw the scoop with getWidth and getHeight, while
				// decrementing y
				// depending on the scoop number
				// and add the overlapscoop
				g.fillOval(getWidth() / 2 - 20, getHeight() - 30 - HEIGHT
						- (scoopNum * diamScoop) + (scoopNum * overlapScoop),
						diamScoop, diamScoop);

			}
			// if the flavor is chocolate
			if (flavor.equals("chocolate")) {
				// set the color to brown
				g.setColor(new Color(51, 32, 13));
				// draw the scoop with getWidth and getHeight, while
				// decrementing y
				// depending on the scoop number
				// and add the overlapscoop
				g.fillOval(getWidth() / 2 - 20, getHeight() - 30 - HEIGHT
						- (scoopNum * diamScoop) + (scoopNum * overlapScoop),
						diamScoop, diamScoop);
			}
			// if the flavor is tea
			if (flavor.equals("tea")) {
				// set the color to green
				g.setColor(Color.green);
				// draw the scoop with getWidth and getHeight, while
				// decrementing y
				// depending on the scoop number
				// and add the overlapscoop
				g.fillOval(getWidth() / 2 - 20, getHeight() - 30 - HEIGHT
						- (scoopNum * diamScoop) + (scoopNum * overlapScoop),
						diamScoop, diamScoop);
			}
			// if the flavor is strawberry
			if (flavor.equals("strawberry")) {
				// set the color to red
				g.setColor(Color.pink);
				// draw the scoop with getWidth and getHeight, while
				// decrementing y
				// depending on the scoop number
				// and add the overlapscoop
				g.fillOval(getWidth() / 2 - 20, getHeight() - 30 - HEIGHT
						- (scoopNum * diamScoop) + (scoopNum * overlapScoop),
						diamScoop, diamScoop);
			}
			// push the flavor on the original stack
			iceCreamCone.push(flavor);
			// increment the number of scoops based on how many we add
			scoopNum++;
		}

	}

	/**
	 * add flavor method pushes the flavors depending on the string
	 * 
	 * @param flavor
	 *            , of string type
	 */
	public void addFlavor(String flavor) {
		// if the string is vanilla, then push vanilla on the stack
		if (flavor.equals("vanilla")) {
			iceCreamCone.push("vanilla");
		}
		// if the string is strawberry, then push strawberry on the stack
		if (flavor.equals("strawberry")) {
			iceCreamCone.push("strawberry");
		}
		// if the string is chocoalte, then push chocolate on the stack
		if (flavor.equals("chocolate")) {
			iceCreamCone.push("chocolate");
		}
		// if the string is tea, then push tea on the stack
		if (flavor.equals("tea")) {
			iceCreamCone.push("tea");
		}
		// repaint
		repaint();

	}

	/**
	 * add a random scoop method
	 */
	public void addRandomScoop() {
		// create random num generator
		Random numGenerator = new Random();
		int num = numGenerator.nextInt(4);
		String flavor;
		// if num = 0, push vanilla
		if (num == 0) {
			flavor = "vanilla";
			iceCreamCone.push("vanilla");
		}
		// if num is 1, push strawberry
		if (num == 1) {
			flavor = "strawberry";
			iceCreamCone.push("strawberry");
		}
		// if num is 2, push chocolate
		if (num == 2) {
			flavor = "chocolate";
			iceCreamCone.push("chocolate");
		}
		// if num is 3, push tea
		if (num == 3) {
			flavor = "tea";
			iceCreamCone.push("tea");
		}
		// repaint
		repaint();
	}

	/**
	 * this method creates the random icecreams with the cone and the scoops
	 * with random scoops flavors and numbers
	 * 
	 * @return IceCreamCone
	 */
	public IceCreamCone createRandom() {
		// create a new IceCreamCone
		IceCreamCone newCone = new IceCreamCone();
		// create a new random numGenerator
		Random numGen = new Random();
		// numScoops is randomly choosing next int(4)
		int numScoops = numGen.nextInt(4);
		// we loop through our random numbers
		for (int i = 0; i <= numScoops; i++) {
			// and we add a random scoop to the new cone
			newCone.addRandomScoop();
			// then repaint
			repaint();
		}
		// and return the cone object
		return newCone;
	}
	/**
	 * method to get stack to use in the icecreamshop
	 * @return iceCreamCone
	 */
	public StackLL<String> getStack(){
		//if the stack is not empty
		if(!iceCreamCone.isEmpty()){
			//return the stack
		return iceCreamCone;
		}
		return iceCreamCone;
	}

	/**
	 * delete scoop method removes scoop on top of the stack First in last out
	 */
	public void deleteScoop() {
		// if ice cream cone is not empty
		if (!iceCreamCone.isEmpty()) {
			// pop
			iceCreamCone.pop();
		}
		// repaint
		repaint();
	}

}
