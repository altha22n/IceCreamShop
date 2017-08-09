import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * This class is the class with the main method
 * 
 * @author Nada-Al-Thawr
 *
 */
public class IceCreamMakerApplication {

	public IceCreamMakerApplication() {

	}

	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// creates an instant of ice cream maker
		IceCreamMaker ice = new IceCreamMaker();
		// creates a new JFrame
		JFrame myFrame = new JFrame("Icecream");
		// sets the size
		myFrame.setSize(400, 500);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// we add ice which is an instant of the icecreammaker class
		myFrame.add(ice);
		// set it to be visible
		myFrame.setVisible(true);
	}
}
