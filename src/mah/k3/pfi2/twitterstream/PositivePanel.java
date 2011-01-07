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
public class PositivePanel extends JPanel {
	private JLabel positiveCounter;

	/**
	 * Create the panel.
	 */
	public PositivePanel() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
				null), "Positive Tweets:", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		setLayout(new GridLayout(1, 0, 0, 0));
		
		positiveCounter = new JLabel("...");
		add(positiveCounter);

	}

	/*
	public void changeValue(int i) {
		// TODO Auto-generated method stub
		txtrTotal.append("nytt värde" + i);
	}
	*/

	public void setPositiveCounter(int positiveCounter) {
		// TODO Auto-generated method stub
		this.positiveCounter.setText(""+positiveCounter);
	}
	
	public JLabel getLabel() {
		return positiveCounter;
	}
}

