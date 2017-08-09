/**
 * This is a class to initialize a linked list With all the methods used
 * 
 * @author Nada Al-Thawr
 * @param <T>
 */
public class LinkedList<T> {
	// initialize head
	private LinkedListNode<T> head;

	public LinkedList() {

	}

	/**
	 * Get data stored in head node of list.
	 */
	public T getFirst() {
		// if the head is not null
		if (head != null) {
			// return the data in the head
			return head.getData();
		} else {
			return null;
		}
	}

	/**
	 * Get the head node of the list.
	 */
	public LinkedListNode<T> getFirstNode() {
		return head;
	}

	/**
	 * Get data stored in last node of list.
	 */
	public T getLast() {
		// our current node will be the head
		LinkedListNode<T> currentNode = head;
		// if what's after the current node isn't null
		while (currentNode.getNext() != null) {
			// then current node is the next one after
			currentNode = currentNode.getNext();
		}
		// return the data in the current node
		return currentNode.getData();
	}

	/**
	 * Get the tail node of the list.
	 */
	public LinkedListNode<T> getLastNode() {
		// current node as head
		LinkedListNode<T> currentNode = head;
		// if the head isn't empty
		if (isEmpty() == false) {
			// and the next value isn't null
			while (currentNode.getNext() != null) {
				// current node will be the next one
				currentNode = currentNode.getNext();
			}
		}
		return currentNode;
	}

	/**
	 * Insert a new node with data at the head of the list.
	 */
	public void insertFirst(T data) {
		// create a new node
		LinkedListNode<T> newNode = new LinkedListNode<T>(data);
		// if head isn't empty
		if (head != null) {
			// new node becomes the next
			newNode.setNext(head);
			// head is the new node
			head = newNode;
		} else {
			head = newNode;
		}
	}

	/**
	 * Insert a new node with data after currentNode
	 */
	public void insertAfter(LinkedListNode<T> currentNode, T data) {
		// create a new linked list node
		LinkedListNode<T> newNode = new LinkedListNode<T>(data);
		// create a second node that is the next after the current node
		LinkedListNode<T> secondNode = currentNode.getNext();
		// set the current node as the new and new and the second
		currentNode.setNext(newNode);
		newNode.setNext(secondNode);
	}

	/**
	 * Insert a new node with data at the end of the list.
	 */
	public void insertLast(T data) {
		// create a new node
		LinkedListNode<T> newNode = new LinkedListNode<T>(data);
		// and make the second node the last one and set as the new one
		LinkedListNode<T> secondNode = getLastNode();
		secondNode.setNext(newNode);
	}

	/**
	 * Remove the first node
	 */
	public void deleteFirst() {
		// create a temp node as the next value after head
		LinkedListNode<T> tempNode = head.getNext();
		// set the current head as null and the temp node as the new head
		head.setNext(null);
		head = tempNode;

	}

	/**
	 * Remove the last node
	 */
	public void deleteLast() {
		// create a current node as the head
		LinkedListNode<T> currentNode = head;
		// if the node after the next after the next isn't null
		while (currentNode.getNext().getNext() != null) {
			// make the current node the next one
			currentNode = currentNode.getNext();
		}
		// set the current node as null
		currentNode.setNext(null);
	}

	/**
	 * Remove node following currentNode If no node exists (i.e., currentNode is
	 * the tail), do nothing
	 */
	public void deleteNext(LinkedListNode<T> currentNode) {
		// if the next node isn't null
		if (currentNode.getNext() != null) {
			// set the temp node as the next after the next after current node
			LinkedListNode<T> tempNode = currentNode.getNext().getNext();
			// next node as the next after current
			LinkedListNode<T> nextNode = currentNode.getNext();
			// next node as null
			nextNode.setNext(null);
			// current node as temp node
			currentNode.setNext(tempNode);
		}
	}

	/**
	 * Return the number of nodes in this list.
	 */
	public int size() {
		// initialize the size as 0
		int sizeList = 0;
		// current node as head
		LinkedListNode<T> currentNode = head;
		// while current node isn't null
		while (currentNode != null) {
			// increase the size by 1
			// and change the current node to the next one
			sizeList += 1;
			currentNode = currentNode.getNext();
		}
		return sizeList;
	}

	/**
	 * Check if list is empty.
	 * 
	 * @return true if list contains no items.
	 */
	public boolean isEmpty() {
		// if the head is empty
		if (head == null) {
			// return true
			return true;
		}
		// else return false
		return false;
	}

	/**
	 * Return a String representation of the list.
	 */

	public String toString() {
		// create new string buffer
		StringBuffer str = new StringBuffer();
		// current node is head
		LinkedListNode<T> currentNode = head;
		// while current node isn't null
		while (currentNode.getNext() != null) {
			// get data in the current node and add the arrow
			str.append(currentNode.getData().toString() + "->");
			// then get next
			currentNode = currentNode.getNext();

		}
		// if data current data isn't null append the data
		// else delete
		if (currentNode.getData() != null) {
			str.append(currentNode.getData().toString());
		} else
			str.delete(str.length() - 2, str.length());

		// print the list and return it
		System.out.println(str);
		return str.toString();
	}

}
