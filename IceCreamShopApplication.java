import javax.swing.JFrame;

public class IceCreamShopApplication {
	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame nFrame = new JFrame("shop");

		// an instance of IceCreamShop 
		IceCreamShop ice = new IceCreamShop();
		//add it to the nFrame
		nFrame.add(ice);
		//exit on close
		nFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set size
		nFrame.setSize(900, 600);
		//set visible true so it appears
		nFrame.setVisible(true);

	}
}
