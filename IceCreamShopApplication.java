import javax.swing.JFrame;

public class IceCreamShopApplication {
    /**
     * Main method
     * 
     * @param args
     */
    public static void main(String[] args) {
        // Create a new JFrame with title "shop"
        JFrame nFrame = new JFrame("shop");

        // Create an instance of IceCreamShop
        IceCreamShop ice = new IceCreamShop();
        // Add the instance of IceCreamShop to the JFrame
        nFrame.add(ice);
        // Set default close operation to exit the application
        nFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the size of the JFrame
        nFrame.setSize(900, 600);
        // Set the JFrame to be visible
        nFrame.setVisible(true);
    }
}
/* Usar JFrame.EXIT_ON_CLOSE asegura que tu aplicación se cierre correctamente cuando se cierre la ventana.
 * nFrame.setVisible(true) es crucial para que la ventana de la aplicación aparezca.
 */