public class QueueLL<T> implements Queue<T> {

    private LinkedList<T> myData;

    public QueueLL() {
        myData = new LinkedList<T>();
    }

    /**
     * Tests if the queue is empty.
     * 
     * @return true if the queue is empty
     **/
    @Override
    public boolean isEmpty() {
        return myData.isEmpty();
    }

    /**
     * Gets the element at the front of the queue without removing it.
     * 
     * @return the element at the front of the queue
     **/
    @Override
    public T peek() {
        return myData.getFirst();
    }

    /**
     * Removes the front element of the queue and returns it.
     * 
     * @return the element removed from the front of the queue
     **/
    @Override
    public T dequeue() {
        T tempData = myData.getFirst();
        myData.deleteFirst();
        return tempData;
    }

    /**
     * Adds an element to the end of the queue.
     * 
     * @param data the element to be added to the queue
     **/
    @Override
    public void enqueue(T data) {
        myData.insertLast(data);
    }

    /**
     * Returns a String representation of the queue.
     * 
     * @return a string representation of the queue
     **/
    @Override
    public String toString() {
        return myData.toString();
    }
}
/*
 Simplificación de la lógica: La lógica en el método enqueue se simplificó eliminando el if-else redundante, ya que el método insertLast ya maneja el caso de agregar un elemento al final de la lista, independientemente de si la lista está vacía o no.
 */