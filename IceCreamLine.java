import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;

/**
 * This class acts as the model for our ice cream line. It extends Box so we can
 * add it to the Icecream shop later.
 * 
 * @author Nada-Al-Thawr
 *
 */
public class IceCreamLine extends Box {
    private QueueLL<IceCreamCone> orderLine = new QueueLL<>();
    private IceCreamCone newCone = new IceCreamCone();

    public IceCreamLine() {
        super(BoxLayout.Y_AXIS);
    }

    /**
     * Checks if the Queue is not empty.
     * 
     * @return true if the queue has orders, false otherwise.
     */
    public boolean hasOrder() {
        return !orderLine.isEmpty();
    }

    /**
     * Adds an order using IceCreamCone as a parameter.
     * 
     * @param cone the IceCreamCone to add.
     */
    public void addOrder(IceCreamCone cone) {
        orderLine.enqueue(cone);
        add(cone);
        validate();
        repaint();
    }

    /**
     * Adds a random order to the box.
     */
    public void addRandomOrder() {
        IceCreamCone randomCone = newCone.createRandom();
        orderLine.enqueue(randomCone);
        add(randomCone);
        validate();
        repaint();
    }

    /**
     * Deletes the order by dequeuing the first item in the queue.
     */
    public void deleteOrder() {
        if (!orderLine.isEmpty()) {
            remove(orderLine.dequeue());
            validate();
            repaint();
        }
    }
}

/* Encapsulate Field: Los campos orderLine y newCone son ahora privados.

Remove Dead Code: Eliminado el método getQueue ya que no se usa.
Replace Conditional with Polymorphism: Simplificado el método hasOrder eliminando condicionales redundantes. */