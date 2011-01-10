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
public class TimePanel extends JPanel {
	private JLabel timeCounter;

	/**
	 * Create the panel.
	 */
	public TimePanel() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
				null), "Time started:", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		setLayout(new GridLayout(1, 0, 0, 0));
		
		timeCounter = new JLabel("...");
		add(timeCounter);

	}

	/*
	public void changeValue(int i) {
		// TODO Auto-generated method stub
		txtrTotal.append("nytt värde" + i);
	}
	*/

	public void setPositiveCounter(int positiveCounter) {
		// TODO Auto-generated method stub
		this.timeCounter.setText(""+timeCounter);
	}
	
	public JLabel getLabel() {
		return timeCounter;
	}
}

