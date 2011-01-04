package mah.k3.pfi2.twitterstream;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


import processing.core.*;
// added so it can import processing sketches into the frame -ME

/**
 * Just a simple TextArea widget. The textarea by itself doesn't allow for
 * scrolling, so to make it simplistic in the Main Panel we define our own
 * custom composite components on JPanel classes.
 * 
 * @author andreas
 * 
 */

/*public class GraphicPanel extends JPanel {


	private JTextArea textArea;
    
	//Create the panel.

	public GraphicPanel() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
				null), "Thermometer %", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		// add(scrollPane);

		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

	}

	public JTextArea getTextArea() {
		return textArea;
	}
}
*/

/* tryck på rutan i övre högra hörnet, då slumpas ett tal för smilies 
respektive frownies. De delas genom sig själva ((s/f+s)+(f/f+s)/2). ut får man en 
jämkning av procentsatserna som visas längs status-baren.*/


public class GraphicPanel extends PApplet {
 	public GraphicPanel() {
	}


	
	  public void setup() {
		    size(200,200);
		    background(0);
		  }

	  public void draw() {
		    stroke(255);
		    if (mousePressed) {
		      line(mouseX,mouseY,pmouseX,pmouseY);
		    }
		  }


	}
