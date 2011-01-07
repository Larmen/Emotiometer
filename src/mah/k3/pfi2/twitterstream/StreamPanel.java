package mah.k3.pfi2.twitterstream;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 * Just a simple TextArea widget. The textarea by itself doesn't allow for
 * scrolling, so to make it simplistic in the Main Panel we define our own
 * custom composite components on JPanel classes.
 * 
 * @author andreas
 * 
 */
public class StreamPanel extends JPanel {
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public StreamPanel() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
				null), "Twitter Stream", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);

		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

	}

	public JTextArea getTextArea() {
		return textArea;
	}
}
