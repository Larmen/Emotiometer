package mah.k3.pfi2.twitterstream;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Just a simple TextArea widget. The textarea by itself doesn't allow for
 * scrolling, so to make it simplistic in the Main Panel we define our own
 * custom composite components on JPanel classes.
 * 
 * @author andreas
 * 
 */
public class TotalPanel extends JPanel {
	private JTextArea txtrTotal;

	/**
	 * Create the panel.
	 */
	public TotalPanel() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
				null), "Total Tweets:", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		 add(scrollPane);

		txtrTotal = new JTextArea();
	
		txtrTotal.setEditable(false);
		scrollPane.setViewportView(txtrTotal);

	}

	public JTextArea getTextArea() {
		return txtrTotal;
	}
}
