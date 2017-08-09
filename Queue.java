/** 
 * The Queue interface encapsulates the ADT for a queue data structure.
 **/
public interface Queue<T>
{
	/** 
	 * Tests if the queue is empty.
	 * @return true iff the queue is empty
	 **/
	public boolean isEmpty();
 
	/** 
	 * Gets the element at the front of the queue without removing it.
	 * @return the peeked data
	 **/
	public T peek();
 
	/**
	 * Removes the front element of the queue and returns it.
	 * @return the dequeued data
	 **/
	public T dequeue();
 
	/**
	 * Adds an element to the end of the queue.
	 **/
	public void enqueue( T data );
 
	/** 
	 * Returns a String representation of the queue.
	 * @return queue as String
	 **/
	public String toString();
}
