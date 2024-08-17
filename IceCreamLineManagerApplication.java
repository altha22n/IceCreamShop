import javax.swing.JFrame;

/**
 * This class is the main entry point for the Ice Cream Maker application.
 * It initializes the main window and adds the IceCreamMaker panel.
 * 
 * @author Nada-Al-Thawr
 */
public class IceCreamMakerApplication {

    /**
     * Main method to launch the Ice Cream Maker application.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Create an instance of IceCreamMaker
        IceCreamMaker iceCreamMaker = new IceCreamMaker();
        
        // Create a new JFrame with the title "Ice Cream Maker"
        JFrame myFrame = new JFrame("Ice Cream Maker");
        
        // Set the size of the JFrame
        myFrame.setSize(400, 500);
        
        // Set the default close operation to exit the application
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Add the IceCreamMaker panel to the JFrame
        myFrame.add(iceCreamMaker);
        
        // Make the JFrame visible
        myFrame.setVisible(true);
    }
}

/*
  Eliminado el constructor vacío: public IceCreamMakerApplication() fue eliminado porque no es necesario.
Añadido un título descriptivo al JFrame: Cambiado el título de la ventana a "Ice Cream Maker" para mayor claridad.
  */