/**
 * This is a class to initialize a linked list node with all the methods used.
 * 
 * @param <T> the type of elements held in this node
 */
public class LinkedListNode<T> {

    private T data;
    private LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }

    /**
     * Get the data stored at this node.
     *
     * @return the data stored at this node
     */
    public T getData() {
        return data;
    }

    /**
     * Set the data stored at this node.
     *
     * @param data the data to be stored at this node
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Get the next node.
     *
     * @return the next node
     */
    public LinkedListNode<T> getNext() {
        return next;
    }

    /**
     * Set the next pointer to the passed node.
     *
     * @param next the node to be set as the next node
     */
    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }

    /**
     * Returns a string representation of this node.
     *
     * @return a string representation of this node
     */
    @Override
    public String toString() {
        return (data != null) ? data.toString() : "null";
    }
}
