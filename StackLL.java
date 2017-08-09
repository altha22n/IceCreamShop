
public class StackLL<T> implements Stack<T>{
	
	private LinkedList<T> myData;
	 
	public StackLL(){
		
		myData = new LinkedList<T>();
	}
		
	/**
	 * Pushes an element onto the top of the stack.
	 */
	public void push( T data ){

		 myData.insertFirst(data);
	}
 
	/**
	 * Removes the top of the stack and returns it.
	 * @return the popped data
	 */
	public T pop(){
		//put my first data in a temp value 
		T tempData = myData.getFirst();
		//then delete it 
		 myData.deleteFirst();
		 //and then return it 
		return tempData;
		
	
	}
 
	/** 
	 * Gets the element at the top of the stack without removing it.
	 * @return the peeked data
	 */
	public T peek(){
		//only return the first element 
		return myData.getFirst();
		
	}
 
	/** 
	 * Tests if the stack is empty.
	 * @return true if the stack is empty
	 */
	public boolean isEmpty(){
		//return the method is empty from linked list 
		return myData.isEmpty();
	}
 
	/** 
	 * Returns a String representation of the stack.
	 * @return stack as String
	 */
	public String toString(){
		//calls the method toString from linked list 
		return myData.toString();
		
	}
	
	
}
