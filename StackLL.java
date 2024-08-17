public class StackLL<T> implements Stack<T> {

    private LinkedList<T> myData;

    public StackLL() {
        myData = new LinkedList<>();
    }

    /**
     * Pushes an element onto the top of the stack.
     * 
     * @param data the element to be pushed onto the stack
     */
    @Override
    public void push(T data) {
        myData.insertFirst(data);
    }

    /**
     * Removes the top element of the stack and returns it.
     * 
     * @return the element removed from the top of the stack
     */
    @Override
    public T pop() {
        T tempData = myData.getFirst();
        myData.deleteFirst();
        return tempData;
    }

    /**
     * Gets the element at the top of the stack without removing it.
     * 
     * @return the element at the top of the stack
     */
    @Override
    public T peek() {
        return myData.getFirst();
    }

    /**
     * Tests if the stack is empty.
     * 
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return myData.isEmpty();
    }

    /**
     * Returns a String representation of the stack.
     * 
     * @return a string representation of the stack
     */
    @Override
    public String toString() {
        return myData.toString();
    }
}
