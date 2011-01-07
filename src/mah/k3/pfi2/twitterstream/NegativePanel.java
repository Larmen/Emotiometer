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
public class NegativePanel extends JPanel {
	private JLabel negativeCounter;

	/**
	 * Create the panel.
	 */
	public NegativePanel() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
				null), "Negative Tweets:", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		setLayout(new GridLayout(1, 0, 0, 0));
		
		negativeCounter = new JLabel("...");
		add(negativeCounter);

	}

	/*
	public void changeValue(int i) {
		// TODO Auto-generated method stub
		txtrTotal.append("nytt värde" + i);
	}
	*/

	public void setNegativeCounter(int negativeCounter) {
		// TODO Auto-generated method stub
		this.negativeCounter.setText(""+negativeCounter);
	}
	
	public JLabel getLabel() {
		return negativeCounter;
	}
}

