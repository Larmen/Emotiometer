package mah.k3.pfi2.twitterstream;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * Just a simple TextArea widget. The textarea by itself doesn't allow for
 * scrolling, so to make it simplistic in the Main Panel we define our own
 * custom composite components on JPanel classes.
 * 
 * @author andreas
 * 
 */
public class ProductPanel extends JPanel {
	private JLabel productCounter;

	/**
	 * Create the panel.
	 */
	public ProductPanel() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
				null), "Product Hits:", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		setLayout(new GridLayout(1, 0, 0, 0));
		
		productCounter = new JLabel("...");
		add(productCounter);

	}

	/*
	public void changeValue(int i) {
		// TODO Auto-generated method stub
		txtrTotal.append("nytt värde" + i);
	}
	*/

	public void setProductCounter(int productCounter) {
		// TODO Auto-generated method stub
		this.productCounter.setText(""+productCounter);
	}
	
	public JLabel getLabel() {
		return productCounter;
	}
}

