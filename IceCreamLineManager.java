import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class acts as the controller for the IceCreamLine class. It extends
 * JComponent and implements ActionListener.
 * 
 * @author Nada-Al-Thawr
 *
 */
public class IceCreamLineManager extends JComponent implements ActionListener {
    private IceCreamLine line = new IceCreamLine();
    private JFrame myFrame = new JFrame("Ice Cream Line!");
    private JPanel myPanel = new JPanel();

    /**
     * Constructor
     */
    public IceCreamLineManager() {
        myPanel.setLayout(new BorderLayout());
        myPanel.add(createButton("Add a random order", BorderLayout.NORTH));
        myPanel.add(createButton("Serve the next order", BorderLayout.CENTER));

        myFrame.add(myPanel, BorderLayout.NORTH);
        myFrame.setSize(400, 500);
        myFrame.add(line, BorderLayout.CENTER);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }

    /**
     * Creates a JButton with specified label and action command, and adds it to the
     * specified position.
     * 
     * @param label    the text to display on the button
     * @param position the BorderLayout position for the button
     * @return the created JButton
     */
    private JButton createButton(String label, String position) {
        JButton button = new JButton(label);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        switch (action) {
            case "Add a random order":
                System.out.println("Adding a random order");
                line.addRandomOrder();
                break;
            case "Serve the next order":
                System.out.println("Serving the next order");
                line.deleteOrder();
                break;
            default:
                break;
        }
    }
}
/* Encapsulate Field: Los campos line, myFrame y myPanel son ahora privados.
Remove Duplication: La creación de botones se ha simplificado en un único método createButton.
 Reemplazo de if-else con switch para mejorar la claridad y reducir la complejidad. */