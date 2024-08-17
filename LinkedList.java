/**
 * This is a class to initialize a linked list with all the methods used.
 * 
 * @param <T> the type of elements held in this list
 */
public class LinkedList<T> {
    // Initialize head
    private LinkedListNode<T> head;

    /**
     * Get data stored in head node of list.
     */
    public T getFirst() {
        return (head != null) ? head.getData() : null;
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
        LinkedListNode<T> lastNode = getLastNode();
        return (lastNode != null) ? lastNode.getData() : null;
    }

    /**
     * Get the tail node of the list.
     */
    public LinkedListNode<T> getLastNode() {
        if (head == null) return null;
        
        LinkedListNode<T> currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    /**
     * Insert a new node with data at the head of the list.
     */
    public void insertFirst(T data) {
        LinkedListNode<T> newNode = new LinkedListNode<>(data);
        newNode.setNext(head);
        head = newNode;
    }

    /**
     * Insert a new node with data after currentNode.
     */
    public void insertAfter(LinkedListNode<T> currentNode, T data) {
        if (currentNode == null) return;

        LinkedListNode<T> newNode = new LinkedListNode<>(data);
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
    }

    /**
     * Insert a new node with data at the end of the list.
     */
    public void insertLast(T data) {
        if (head == null) {
            insertFirst(data);
            return;
        }

        LinkedListNode<T> newNode = new LinkedListNode<>(data);
        LinkedListNode<T> lastNode = getLastNode();
        if (lastNode != null) {
            lastNode.setNext(newNode);
        }
    }

    /**
     * Remove the first node.
     */
    public void deleteFirst() {
        if (head != null) {
            head = head.getNext();
        }
    }

    /**
     * Remove the last node.
     */
    public void deleteLast() {
        if (head == null || head.getNext() == null) {
            head = null;
            return;
        }

        LinkedListNode<T> currentNode = head;
        while (currentNode.getNext().getNext() != null) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(null);
    }

    /**
     * Remove node following currentNode. If no node exists (i.e., currentNode is the tail), do nothing.
     */
    public void deleteNext(LinkedListNode<T> currentNode) {
        if (currentNode != null && currentNode.getNext() != null) {
            currentNode.setNext(currentNode.getNext().getNext());
        }
    }

    /**
     * Return the number of nodes in this list.
     */
    public int size() {
        int size = 0;
        LinkedListNode<T> currentNode = head;
        while (currentNode != null) {
            size++;
            currentNode = currentNode.getNext();
        }
        return size;
    }

    /**
     * Check if list is empty.
     * 
     * @return true if list contains no items.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Return a String representation of the list.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        LinkedListNode<T> currentNode = head;
        while (currentNode != null) {
            str.append(currentNode.getData());
            if (currentNode.getNext() != null) {
                str.append("->");
            }
            currentNode = currentNode.getNext();
        }
        return str.toString();
    }
}

/*
Remover constructor innecesario: No tener un constructor vacío redundante.
Extracción de métodos: getLastNode() simplifica getLast() y se usa en otros lugares.
Control de nulls: Mejor manejo de valores nulos para evitar NullPointerException.
Eliminar duplicación de código: Reducción de lógica repetitiva al extraer métodos.
 */