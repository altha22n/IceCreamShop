/** 
 * The Queue interface encapsulates the ADT for a queue data structure.
 * 
 * @param <T> the type of elements held in this queue
 **/
public interface Queue<T> {

    /** 
     * Tests if the queue is empty.
     * 
     * @return true if the queue is empty, otherwise false
     **/
    boolean isEmpty();
 
    /** 
     * Gets the element at the front of the queue without removing it.
     * 
     * @return the element at the front of the queue
     **/
    T peek();
 
    /**
     * Removes the front element of the queue and returns it.
     * 
     * @return the element removed from the front of the queue
     **/
    T dequeue();
 
    /**
     * Adds an element to the end of the queue.
     * 
     * @param data the element to be added to the queue
     **/
    void enqueue(T data);
 
    /** 
     * Returns a String representation of the queue.
     * 
     * @return a string representation of the queue
     **/
    @Override
    String toString();
}
/*
 * Eliminar modificadores de acceso redundantes: Los métodos en una interfaz son implícitamente públicos, por lo que no es necesario especificar public.
 */