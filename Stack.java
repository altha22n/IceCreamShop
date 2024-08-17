/**
 * The interface which contains the methods for a stack data structure.
 * 
 * @param <T> the type of elements in this stack
 */
public interface Stack<T> {

    /**
     * Pushes an element onto the top of the stack.
     * 
     * @param data the element to be pushed onto the stack
     */
    void push(T data);

    /**
     * Removes the top element of the stack and returns it.
     * 
     * @return the element removed from the top of the stack
     */
    T pop();

    /**
     * Gets the element at the top of the stack without removing it.
     * 
     * @return the element at the top of the stack
     */
    T peek();

    /**
     * Tests if the stack is empty.
     * 
     * @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns a String representation of the stack.
     * 
     * @return a string representation of the stack
     */
    @Override
    String toString();
}
/*
 Documentación mejorada: Los comentarios de documentación han sido mejorados para ser más descriptivos y seguir un formato consistente.
Uso de @param y @return en la documentación: Se ha añadido @param y @return en los comentarios de los métodos para proporcionar información adicional sobre los parámetros y los valores de retorno.
Eliminación de modificadores redundantes: En las interfaces, todos los métodos son implícitamente public, por lo que el modificador public no es necesario.
 */