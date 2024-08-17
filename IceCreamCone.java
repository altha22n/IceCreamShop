import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.JComponent;

public class IceCreamCone extends JComponent {
    private StackLL<String> iceCreamCone;
    private StackLL<String> tempStack;
    private static final int WIDTH = 30;
    private static final int HEIGHT = 40;
    private static final int DIAM_SCOOP = 40;
    private static final int OVERLAP_SCOOP = 10;
    private static final Color BROWN = new Color(156, 93, 82);

    public IceCreamCone() {
        iceCreamCone = new StackLL<>();
        tempStack = new StackLL<>();
    }

    @Override
    public void paint(Graphics g) {
        paintCone(g);
        paintScoops(g);
    }

    private void paintCone(Graphics g) {
        Graphics2D graph = (Graphics2D) g;
        Polygon polygon = new Polygon();
        polygon.addPoint((getWidth() - WIDTH) / 2, getHeight() - HEIGHT);
        polygon.addPoint((getWidth() - WIDTH) / 2 + WIDTH, getHeight() - HEIGHT);
        polygon.addPoint((getWidth() - WIDTH) / 2 + (WIDTH / 2), getHeight());
        graph.setPaint(BROWN);
        graph.fill(polygon);
    }

    private void paintScoops(Graphics g) {
        int scoopNum = 0;
        while (!iceCreamCone.isEmpty()) {
            tempStack.push(iceCreamCone.pop());
        }
        while (!tempStack.isEmpty()) {
            String flavor = tempStack.pop();
            Color color = getFlavorColor(flavor);
            g.setColor(color);
            g.fillOval(getWidth() / 2 - 20, getHeight() - 30 - HEIGHT
                    - (scoopNum * DIAM_SCOOP) + (scoopNum * OVERLAP_SCOOP),
                    DIAM_SCOOP, DIAM_SCOOP);
            iceCreamCone.push(flavor);
            scoopNum++;
        }
    }

    private Color getFlavorColor(String flavor) {
        Map<String, Color> flavorColors = new HashMap<>();
        flavorColors.put("vanilla", Color.WHITE);
        flavorColors.put("chocolate", new Color(51, 32, 13));
        flavorColors.put("tea", Color.GREEN);
        flavorColors.put("strawberry", Color.PINK);
        return flavorColors.getOrDefault(flavor, Color.GRAY);
    }

    public void addFlavor(String flavor) {
        if (isValidFlavor(flavor)) {
            iceCreamCone.push(flavor);
        }
        repaint();
    }

    private boolean isValidFlavor(String flavor) {
        return flavor.equals("vanilla") || flavor.equals("chocolate") ||
                flavor.equals("tea") || flavor.equals("strawberry");
    }

    public void addRandomScoop() {
        String[] flavors = {"vanilla", "strawberry", "chocolate", "tea"};
        Random numGenerator = new Random();
        String flavor = flavors[numGenerator.nextInt(flavors.length)];
        iceCreamCone.push(flavor);
        repaint();
    }

    public IceCreamCone createRandom() {
        IceCreamCone newCone = new IceCreamCone();
        Random numGen = new Random();
        int numScoops = numGen.nextInt(4);
        for (int i = 0; i <= numScoops; i++) {
            newCone.addRandomScoop();
            repaint();
        }
        return newCone;
    }

    public StackLL<String> getStack() {
        return iceCreamCone;
    }

    public void deleteScoop() {
        if (!iceCreamCone.isEmpty()) {
            iceCreamCone.pop();
        }
        repaint();
    }
}

/* 	Replace Conditional with Polymorphism: Refactorización del método paintScoop mediante el uso de un método getFlavorColor que usa un Map para mapear sabores a colores.
Encapsulate Field: Hacer que iceCreamCone y tempStack sean privados.
Extract Method: Se extrajo la lógica de obtención de colores a un método separado getFlavorColor. */