import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;

/**
 * This class acts as the model for our ice cream line It extends Box so we can
 * add it to the Icecream shop later
 * 
 * @author Nada-Al-Thawr
 *
 */
public class IceCreamLine extends Box {
	// create a new Queue that takes IcecreamCone as an argument
	public QueueLL<IceCreamCone> orderLine = new QueueLL<IceCreamCone>();
	public IceCreamCone newCone = new IceCreamCone();

	public IceCreamLine() {
		// inherit from the super class of the box
		// set the box layout to be Y axis
		super(BoxLayout.Y_AXIS);

	}

	/**
	 * Checks if the Queue is not empty
	 * 
	 * @return false
	 */
	public boolean hasOrder() {
		//if the order line is not empty
		if (!orderLine.isEmpty()) {
			//return true
			return true;
		}
		//else return false
		return false;
	}

	/**
	 * adds an order using Icecreamcone as a param
	 * 
	 * @param cone
	 */
	public void addOrder(IceCreamCone cone) {
		// enqueue cone
		orderLine.enqueue(cone);
		// add the cone
		add(cone);
		// validate and repaint
		validate();
		repaint();

	}

	/**
	 * Adds a random order to the box
	 */
	public void addRandomOrder() {
		// create a new ice cream cone
		
		// call create random from the icecream cone class
		newCone = newCone.createRandom();
		// enqueue the new cone and then add it
		orderLine.enqueue(newCone);
		add(newCone);
		// for testing purposes
		IceCreamCone testCone = orderLine.peek();
		System.out.println(testCone.iceCreamCone.toString());
		// validate and repaint
		validate();
		repaint();
	}

	/**
	 * Deletes the order by dequeuing the first item in the queue
	 */
	public void deleteOrder() {
		// if the queue isn't empty
		if (!orderLine.isEmpty()) {
			// remove what we dequeue
			remove(orderLine.dequeue());
			// validate and repaint
			validate();
			repaint();

		}

	}
	/**
	 * Was going to use this with the matching method
	 * ended up not using it 
	 * @return
	 */
	public Queue<IceCreamCone> getQueue() {
		if (!orderLine.isEmpty()) {
			return orderLine;
		}
		return orderLine;
	}

	
}
