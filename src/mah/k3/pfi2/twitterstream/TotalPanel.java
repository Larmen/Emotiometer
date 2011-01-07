package mah.k3.pfi2.twitterstream;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;

/**
 * Just a simple TextArea widget. The textarea by itself doesn't allow for
 * scrolling, so to make it simplistic in the Main Panel we define our own
 * custom composite components on JPanel classes.
 * 
 * @author andreas
 * 
 */
public class TotalPanel extends JPanel {
	private JLabel totalCounter;

	/**
	 * Create the panel.
	 */
	public TotalPanel() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
				null), "Total Tweets:", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		setLayout(new GridLayout(1, 0, 0, 0));
		
		totalCounter = new JLabel("...");
		add(totalCounter);

	}

	/*public JTextArea getTextArea() {
		return txtrTotal;
	}*/

	/*
	public void changeValue(int i) {
		// TODO Auto-generated method stub
		txtrTotal.append("nytt värde" + i);
	}
	*/

	public void setTotalCounter(int totalCounter) {
		// TODO Auto-generated method stub
		this.totalCounter.setText(""+totalCounter);
	}
	
	public JLabel getLabel() {
		return totalCounter;
	}
}
