public class QueueLL<T> implements Queue<T> {

	private LinkedList<T> myData;

	public QueueLL() {
		myData = new LinkedList<T>();

	}

	/**
	 * Tests if the queue is empty.
	 * 
	 * @return true iff the queue is empty
	 **/
	public boolean isEmpty() {
		// return the method is empty from linked list
		return myData.isEmpty();
	}

	/**
	 * Gets the element at the front of the queue without removing it.
	 * 
	 * @return the peeked data
	 **/
	public T peek() {
		// only return the first element without removing it
		return myData.getFirst();
	}

	/**
	 * Removes the front element of the queue and returns it.
	 * 
	 * @return the dequeued data
	 **/
	public T dequeue() {
		//put my first data in a temp value 
		T tempData = myData.getFirst();
		//then delete it 
		 myData.deleteFirst();
		 //and then return it 
		return tempData;
		
	}

	/**
	 * Adds an element to the end of the queue.
	 **/
	public void enqueue(T data) {
		if (!myData.isEmpty()){
			myData.insertLast(data);
		}
		else {
			myData.insertFirst(data);
		}
		

	}

	/**
	 * Returns a String representation of the queue.
	 * 
	 * @return queue as String
	 **/
	public String toString() {
		// calls the method toString from linked list
		return myData.toString();
	}
}