import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.*;

/**
 * This class acts as the controller of the ice cream application. It extends
 * JPanel and implements ActionListener.
 * 
 * @author Nada-Al-Thawr
 *
 */
public class IceCreamMaker extends JPanel implements ActionListener {
    // Ice cream cone instance
    private IceCreamCone cone = new IceCreamCone();

    // Buttons for flavors and actions
    private JButton vanButton;
    private JButton chocolateButton;
    private JButton strawButton;
    private JButton teaButton;
    private JButton trashButton;
    private JButton randomButton;

    /**
     * Constructor to set up the UI components
     */
    public IceCreamMaker() {
        super(new BorderLayout());
        setupUI();
    }

    /**
     * Set up the UI components
     */
    private void setupUI() {
        // Create and add buttons panel to the north
        add(createButtonPanel(), BorderLayout.NORTH);
        // Add the ice cream cone component to the center
        add(cone, BorderLayout.CENTER);
    }

    /**
     * Create a panel with buttons for adding flavors and actions
     * 
     * @return JPanel with buttons
     */
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5));
        JPanel trashPanel = new JPanel(new GridLayout(1, 1));
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create and add flavor buttons
        vanButton = createButton("Vanilla", Color.white);
        teaButton = createButton("Green Tea", Color.green);
        strawButton = createButton("Strawberry", Color.pink);
        chocolateButton = createButton("Chocolate", Color.orange);
        randomButton = createButton("Random", Color.yellow);

        // Create and add trash button
        trashButton = createButton("Eat the heart out of your scoop!", Color.cyan);

        // Add buttons to the button panel
        buttonPanel.add(vanButton);
        buttonPanel.add(teaButton);
        buttonPanel.add(strawButton);
        buttonPanel.add(chocolateButton);
        buttonPanel.add(randomButton);
        
        // Add trash button to the trash panel
        trashPanel.add(trashButton);

        // Add button panels to the main panel
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(trashPanel, BorderLayout.SOUTH);

        return mainPanel;
    }

    /**
     * Create a JButton with specified text and background color
     * 
     * @param text  the text of the button
     * @param color the background color of the button
     * @return configured JButton
     */
    private JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setOpaque(true);
        button.addActionListener(this);
        return button;
    }

    /**
     * Handle button actions to add flavors or perform actions
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == vanButton) {
            cone.addFlavor("vanilla");
        } else if (source == chocolateButton) {
            cone.addFlavor("chocolate");
        } else if (source == teaButton) {
            cone.addFlavor("tea");
        } else if (source == strawButton) {
            cone.addFlavor("strawberry");
        } else if (source == trashButton) {
            cone.deleteScoop();
        } else if (source == randomButton) {
            cone.addRandomScoop();
        }
    }
}

/* Método setupUI: Se creó un método para configurar los componentes de la interfaz de usuario.
Método createButtonPanel: Se creó un método para crear y configurar el panel de botones.
Método createButton: Se creó un método auxiliar para configurar cada botón.
Uso de Object source en lugar de múltiples if: Simplificación de la comparación de la fuente del evento en el método actionPerformed. */